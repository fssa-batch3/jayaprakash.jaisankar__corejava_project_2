package jayaprakash.jaisankar_backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    // Connect to the database
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root", "123456");
        return connection;
    }

    // Get user from DB - Login
    public boolean login(String email, String password) {
        try {
            // Get Connection
            Connection connection = getConnection();

            // Prepare SQL statement
            String selectQuery = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement pst = connection.prepareStatement(selectQuery);
            pst.setString(1, email);
            pst.setString(2, password);

            // Execute the query on the database
            ResultSet rs = pst.executeQuery();

            // Check if the user exists
            if (rs.next()) {
                // User exists, login successful
                return true;
            } else {
                // User does not exist or incorrect credentials
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Add new user to DB - Register
    public boolean register(User user) throws SQLException {
        // Get Connection
        Connection connection = getConnection();

        // Prepare SQL statement
        String insertQuery = "INSERT INTO user (username, email, password, dob, phone, firstname, lastname) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(insertQuery);
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getemail());
        pst.setString(3, user.getPassword());
        pst.setString(4, user.getdob());
        pst.setString(5, user.getphone());
        pst.setString(6, user.getfirstname());
        pst.setString(7, user.getlastname());

        // Execute the query on the database
        int rows = pst.executeUpdate();

        // Return successful or not
        return (rows == 1);
    }

    // Update an existing user in DB
    public boolean updateUser(User user) throws SQLException {
        // Get Connection
        Connection connection = getConnection();

        // Prepare SQL statement
        String updateQuery = "UPDATE user SET username = ?, email = ?, password = ?, dob = ?, phone = ?, firstname = ?, lastname = ? WHERE email = ?";
        PreparedStatement pst = connection.prepareStatement(updateQuery);
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getemail());
        pst.setString(3, user.getPassword());
        pst.setString(4, user.getdob());
        pst.setString(5, user.getphone());
        pst.setString(6, user.getfirstname());
        pst.setString(7, user.getlastname());
        pst.setString(8, user.getemail()); // Use email as a unique identifier for the update

        // Execute the query on the database
        int rows = pst.executeUpdate();

        // Return successful or not
        return (rows > 0); // If rows > 0, it means at least one row was updated
    }

    // Delete an existing user from DB
    public boolean deleteUser(String email) throws SQLException {
        // Get Connection
        Connection connection = getConnection();

        // Prepare SQL statement
        String deleteQuery = "DELETE FROM user WHERE email = ?";
        PreparedStatement pst = connection.prepareStatement(deleteQuery);
        pst.setString(1, email);

        // Execute the query on the database
        int rows = pst.executeUpdate();

        // Return successful or not
        return (rows > 0); // If rows > 0, it means at least one row was deleted
    }

    // Main method for example usage
    public static void main(String[] args) {
        try {
            // Create a new user
            User newUser = new User("jayaprakash@gmail.com", "jayaprakash", "123456", "1890-10-12", "9876543210", "Jayaprakash", "yazhan");

            App app = new App();

            // Register the new user
            boolean isInserted = app.register(newUser);
            if (isInserted) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("Failed to insert user.");
            }

            // Update the user's phone number
            newUser.setphone("9876543210");
            boolean isUpdated = app.updateUser(newUser);
            if (isUpdated) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("Failed to update user.");
            }

            // Delete the user
            boolean isDeleted = app.deleteUser(newUser.getemail());
            if (isDeleted) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Failed to delete user.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

