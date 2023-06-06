package com.rtm516.mcxboxbroadcast.bootstrap.standalone;

import java.sql.*;

public class Database {

    public void addPerson(String name, String xuid, Date date, String botName) {
        try (PreparedStatement insert = DatabaseSetup.getConnection().prepareStatement("INSERT INTO " + DatabaseSetup.mcxb + "(NAME,XUID,DATE,EMAIL,PREMIUM,ADMIN, BOTNAME, DISCORDID) VALUES (?,?,?,?,?,?,?,?)")) {
            insert.setString(1, name);
            insert.setString(2, xuid);
            insert.setDate(3, date);
            insert.setString(4, "");
            insert.setBoolean(5, false);
            insert.setBoolean(6, false);
            insert.setString(7, botName);
            insert.setString(8,"");
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isXuidExists(String xuid) {
        try (PreparedStatement statement = DatabaseSetup.getConnection().prepareStatement("SELECT COUNT(*) FROM " + DatabaseSetup.mcxb + " WHERE XUID=?")) {
            statement.setString(1, xuid);
            ResultSet results = statement.executeQuery();
            results.next();
            int count = results.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean premium(String xuid) {
        try (PreparedStatement statement = DatabaseSetup.getConnection().prepareStatement("SELECT * FROM " + DatabaseSetup.mcxb + " WHERE XUID=?")) {
            statement.setString(1, xuid);
            try (ResultSet results = statement.executeQuery()) {
                if (results.next()) {
                    return results.getBoolean(5);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void updateDate(String xuid, Date date) {
        try (PreparedStatement insert = DatabaseSetup.getConnection().prepareStatement("UPDATE " + DatabaseSetup.mcxb + " SET DATE = ? WHERE XUID = ?")) {
            insert.setDate(1, date);
            insert.setString(2, xuid);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateGamertag(String xuid, String newGamertag) {
        try (PreparedStatement update = DatabaseSetup.getConnection().prepareStatement("UPDATE " + DatabaseSetup.mcxb + " SET NAME = ? WHERE XUID = ?")) {
            update.setString(1, newGamertag);
            update.setString(2, xuid);
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getGamertagFromXuid(String xuid) {
        try (PreparedStatement statement = DatabaseSetup.getConnection().prepareStatement("SELECT NAME FROM " + DatabaseSetup.mcxb + " WHERE XUID=?")) {
            statement.setString(1, xuid);
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                return results.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
