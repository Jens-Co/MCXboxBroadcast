package com.rtm516.mcxboxbroadcast.bootstrap.standalone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtm516.mcxboxbroadcast.core.SessionInfo;

public class StandaloneConfig {
    @JsonProperty("session")
    public SessionConfig sessionConfig;
    @JsonProperty("friend-sync")
    public FriendSyncConfig friendSyncConfig;
    @JsonProperty("debug-log")
    public boolean debugLog;
    @JsonProperty("database")
    public Database database;

    public static class SessionConfig {
        @JsonProperty("update-interval")
        public int updateInterval;
        @JsonProperty("query-server")
        public boolean queryServer;
        @JsonProperty("session-info")
        public SessionInfo sessionInfo;
        @JsonProperty("xbl-api")
        public String xblapi;

        @JsonProperty("botname")
        public String botName;
    }

    public static class FriendSyncConfig {
        @JsonProperty("update-interval")
        public int updateInterval;
        @JsonProperty("auto-follow")
        public boolean autoFollow;
        @JsonProperty("auto-unfollow")
        public boolean autoUnfollow;
    }

    public static class Database {
        @JsonProperty("enableDatabase")
        public boolean enableDB;
        @JsonProperty("host")
        public String host;
        @JsonProperty("port")
        public int port;
        @JsonProperty("username")
        public String username;
        @JsonProperty("password")
        public String password;
        @JsonProperty("max-date")
        public long maxDate;
    }
}
