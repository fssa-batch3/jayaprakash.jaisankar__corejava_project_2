package jayaprakash.jaisankar_backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

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
        String insertQuery = "INSERT INTO user (username,email,  password,dob,phone,firstname,lastname) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(insertQuery);
        pst.setString(1, user.getemail());
        pst.setString(2, user.getUsername());
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

	public boolean deleteUser(String getemail) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User newUser) {
		// TODO Auto-generated method stub
		return false;
	}
}
