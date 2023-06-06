package com.rtm516.mcxboxbroadcast.bootstrap.standalone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.nukkitx.protocol.bedrock.BedrockClient;
import com.nukkitx.protocol.bedrock.BedrockPong;
import com.rtm516.mcxboxbroadcast.core.Logger;
import com.rtm516.mcxboxbroadcast.core.SessionInfo;
import com.rtm516.mcxboxbroadcast.core.SessionManager;
import com.rtm516.mcxboxbroadcast.core.exceptions.SessionUpdateException;
import com.rtm516.mcxboxbroadcast.core.exceptions.XboxFriendsException;
import com.rtm516.mcxboxbroadcast.core.models.FollowerResponse;
import org.java_websocket.util.NamedThreadFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLogger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StandaloneMain {
    private static StandaloneConfig config;
    private static Logger logger;
    private static HashSet<String> addedPersons = new HashSet<>();
    private static final Database db = new Database();

    public static void main(String[] args) throws Exception {
        logger = new StandaloneLoggerImpl(LoggerFactory.getLogger(StandaloneMain.class));

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2, new NamedThreadFactory("Scheduled Thread"));

        String configFileName = "config.yml";
        File configFile = new File(configFileName);

        // Create the config file if it doesn't exist
        if (!configFile.exists()) {
            try (FileOutputStream fos = new FileOutputStream(configFileName)) {
                try (InputStream input = StandaloneMain.class.getClassLoader().getResourceAsStream(configFileName)) {
                    byte[] bytes = new byte[input.available()];

                    //noinspection ResultOfMethodCallIgnored
                    input.read(bytes);

                    fos.write(bytes);

                    fos.flush();
                }
            } catch (IOException e) {
                logger.error("Failed to create config", e);
                return;
            }
        }

        try {
            config = new ObjectMapper(new YAMLFactory()).readValue(configFile, StandaloneConfig.class);
        } catch (IOException e) {
            logger.error("Failed to load config", e);
            return;
        }

        // Use reflection to put the logger in debug mode
        if (config.debugLog) {
            Field currentLogLevel = SimpleLogger.class.getDeclaredField("currentLogLevel");
            currentLogLevel.setAccessible(true);
            currentLogLevel.set(LoggerFactory.getLogger(StandaloneMain.class), 10);
        }

        SessionManager sessionManager = new SessionManager("./cache", logger);

        SessionInfo sessionInfo = config.sessionConfig.sessionInfo;

        // Sync the session info from the server if needed
        updateSessionInfo(sessionInfo);

        logger.info("Creating session...");

        scheduledThreadPool.scheduleWithFixedDelay(() -> {
            updateSessionInfo(sessionInfo);

            try {
                // Make sure the connection is still active
                sessionManager.checkConnection();

                // Update the session
                sessionManager.updateSession(sessionInfo);

                logger.info("Updated session!");
            } catch (SessionUpdateException e) {
                logger.error("Failed to update session", e);
            }
        }, config.sessionConfig.updateInterval, config.sessionConfig.updateInterval, TimeUnit.SECONDS);

        if (config.database.enableDB) {
            new DatabaseSetup().mysqlSetup(config, logger);
        }

        sessionManager.createSession(sessionInfo);
        logger.info("Created session!");

        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        String botName = config.sessionConfig.botName;
        Runnable friendSyncTask = new Runnable() {
            @Override
            public void run() {
                try {
                    for (FollowerResponse.Person person : sessionManager.getXboxFriends(true, true)) {
                        TimeUnit.SECONDS.sleep(1);
                        String xuid = person.xuid;
                        String gamertag = person.gamertag;
                        // Check if the person is already added
                        if (addedPersons.contains(xuid)) {
                            continue; // Skip if the person is already added
                        }
                        // Unfollow the person and remove them as a friend
                        if (config.friendSyncConfig.autoUnfollow && !person.isFollowingCaller && person.isFollowedByCaller) {
                            db.updateDate(xuid, currentDate);
                            sessionManager.removeXboxFriend(xuid);
                            addedPersons.remove(xuid);
                            logger.info("Removed " + gamertag + " (" + xuid + ") as a friend");
                            continue;
                        }
                        // If person is not in the database, add them as a friend and in the database
                        if (!db.isXuidExists(xuid)) {
                            db.addPerson(gamertag, xuid, currentDate, botName);
                            sessionManager.addXboxFriend(xuid);
                            logger.info("Added person: " + gamertag + " into database");
                        }
                        // Update gamertag.
                        if (!db.getGamertagFromXuid(xuid).equals(gamertag)) {
                            logger.info("Gamertag changed to " + gamertag);
                            db.updateGamertag(xuid, gamertag);
                        }
                        boolean isPremium = db.premium(xuid);
                        // If person is premium, allow them as a friend
                        if (isPremium) {
                            sessionManager.addXboxFriend(xuid);
                            addedPersons.add(xuid);
                            logger.info("Allow and add person: " + gamertag + " as a friend because they are a premium member!");
                        } else {
                            logger.info(gamertag + " has tried to add the bot but doesn't have a premium account.");
                        }
                    }
                } catch (XboxFriendsException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Schedule the task to run again after the loop completes
                    scheduledThreadPool.schedule(this, config.friendSyncConfig.updateInterval, TimeUnit.SECONDS);
                }
            }
        };

        scheduledThreadPool.schedule(friendSyncTask, 5, TimeUnit.SECONDS);
    }

    private static void updateSessionInfo(SessionInfo sessionInfo) {
        if (config.sessionConfig.queryServer) {
            BedrockClient client = null;
            try {
                InetSocketAddress bindAddress = new InetSocketAddress("0.0.0.0", 0);
                client = new BedrockClient(bindAddress);

                client.bind().join();

                InetSocketAddress addressToPing = new InetSocketAddress(sessionInfo.getIp(), sessionInfo.getPort());
                BedrockPong pong = client.ping(addressToPing, 1500, TimeUnit.MILLISECONDS).get();

                // Update the session information
                sessionInfo.setHostName(pong.getMotd());
                sessionInfo.setWorldName(pong.getSubMotd());
                sessionInfo.setVersion(pong.getVersion());
                sessionInfo.setProtocol(pong.getProtocolVersion());
                sessionInfo.setPlayers(pong.getPlayerCount());
                sessionInfo.setMaxPlayers(pong.getMaximumPlayerCount());
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Failed to ping server", e);
            } finally {
                if (client != null) {
                    client.close();
                }
            }
        }
    }
}

