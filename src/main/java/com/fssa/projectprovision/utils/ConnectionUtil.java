package com.fssa.projectprovision.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * * A utility class for managing database connections.
 * This class provides a method to establish a connection to the database using environment variables.
 * It uses the MySQL JDBC driver for database connectivity.
 * 
 * 
 *  * Usage:
 * Connection connection = ConnectionUtil.getConnection();
 * // Use the connection for database operations
 * connection.close(); // Remember to close the connection when done
 * 
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */
public class ConnectionUtil {

	
	   /**
     * Private constructor to prevent instantiation of the utility class.
     */
	
    private ConnectionUtil() {
        // Private constructor to prevent instantiation
    }
 
    
    /**
     * Establishes a database connection using environment variables for database configuration.
     * 
     * @return A connection to the database.
     * @throws RuntimeException If there's an issue with database driver loading or connection.
     */
    
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
