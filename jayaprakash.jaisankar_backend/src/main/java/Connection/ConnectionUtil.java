package Connection;

import java.sql.*;

public class ConnectionUtil {
    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/backend";
    private static final String username = "root";
    private static final String password = "123456";

    private Connection connection;

    public ConnectionUtil() throws DAOException {
        try {
            // Create the connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DAOException("Error connecting to the database.", e);
        }
    }

    // Method to close the database connection
    public void closeConnection() throws DAOException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException("Error closing the database connection.", e);
            } 
            finally {
                connection = null; // Set connection to null after closing
            }
        }
    }

    // Example DAO method for fetching data from the backend database
    public void fetchDataFromBackendDatabase() throws DAOException {
        String query = "SELECT * FROM user";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Process the results
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                // Example: Printing the data
                System.out.println("User ID: " + id);
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            throw new DAOException("Error executing SQL query.", e);
        }
    }

    
    // Example of basic validation
    public boolean isValid() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            ConnectionUtil dao = new ConnectionUtil();
            if (dao.isValid()) {
                dao.fetchDataFromBackendDatabase();
                dao.closeConnection();
            } else {
                System.out.println("Database connection is not valid.");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
