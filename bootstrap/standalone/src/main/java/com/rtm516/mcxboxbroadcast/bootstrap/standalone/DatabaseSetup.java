package com.rtm516.mcxboxbroadcast.bootstrap.standalone;

import com.rtm516.mcxboxbroadcast.core.Logger;

import java.sql.*;
import java.util.Properties;

public class DatabaseSetup {

    private static Connection connection = null;
    public static String mcxb;

    public void mysqlSetup(StandaloneConfig config, Logger logger) {
        String host = config.database.host;
        int port = config.database.port;
        String database = "gcbots";
        String username = config.database.username;
        String password = config.database.password;
        mcxb = "mcxb";

        logger.info("Connecting to MySQL database...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("autoReconnect", "true");
            properties.setProperty("verifyServerCertificate", "false");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, properties);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + DatabaseSetup.mcxb + "(NAME varchar(16), XUID char(36), DATE varchar(500), EMAIL varchar(500), PREMIUM boolean, ADMIN boolean, BOTNAME char(36), DISCORDID char(36))");
            statement.closeOnCompletion();
            logger.info("MYSQL Connected");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}