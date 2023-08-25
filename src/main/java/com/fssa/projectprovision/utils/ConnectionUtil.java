package com.fssa.projectprovision.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private ConnectionUtil() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        final String dbUrl = System.getenv("DB_URL");
        final String dbUser = System.getenv("DB_USER");
        final String dbPassword = System.getenv("DB_PASSWORD");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Database Driver class Not found", e);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to Connect to Database", e);
        }
    }
}
