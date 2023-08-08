package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
import registration.model.User;

public class UserDAO {

	// Connect to the database
	public Connection getConnection() throws SQLException {
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
		
		
		/*
		 * DB_URL,DB_USER,DB_PASSWORD
		 */		
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root", "123456");
		return connection;
	}

	// Get user from DB - Login
	public boolean login(User user) throws SQLException {
		boolean match = false;
		Connection connection = getConnection();

		String selectQuery = "SELECT * FROM data WHERE email = ?";
		PreparedStatement pst = connection.prepareStatement(selectQuery);
		pst.setString(1, user.getEmail());
		ResultSet resultSet = pst.executeQuery();

		while (resultSet.next()) {
			String emailID = resultSet.getString("email");
			String password = resultSet.getString("password");

			if (user.getEmail().equals(emailID) && user.getPassword().equals(password)) {
				match = true;
				break; // No need to continue the loop once a match is found.
			}
		}
		// Close resources
		resultSet.close();
		pst.close();
		connection.close();

		return match;
	}

	// Add new user to DB - Register
	public boolean register(User user) throws SQLException {
		
		// Get Connection
		Connection connection = getConnection();

		// Prepare SQL Statement
		String insertQuery = "INSERT INTO data (name, middlename, lastname, phone, age, email, role, password,id) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		pst.setString(1, user.getname());
		pst.setString(2, user.getmiddlename());
		pst.setString(3, user.getlastname());
		pst.setString(4, user.getphone());
		pst.setInt(5, user.getage());
		pst.setString(6, user.getEmail());
		pst.setString(7, user.getRole());
		pst.setString(8, user.getPassword());
		pst.setInt(9, user.getid());

		// Execute query
		int rows = pst.executeUpdate();

		// Close resources
		pst.close();
		connection.close();

		// Return Successful or not
		return (rows == 1);
	}

	public boolean isUserRegistered(String email) {
		
		return false;
	}
	 //Email Not Exist
	   public boolean EmailExist(User user) throws SQLException {
			
		   
		   Connection connection = getConnection();
		   
		   String selectQuery = "SELECT * FROM data WHERE email = ?";
		   PreparedStatement pst = connection.prepareStatement(selectQuery);
		   pst.setString(1, user.email);
		   ResultSet resultSet = pst.executeQuery();
		   
		   boolean match = false;
		while (resultSet.next()) {
			   String emailID = resultSet.getString("email");
			   String Password = resultSet.getString("password");
			   
			   System.out.println("Email: " + emailID + " Password: " + Password);
			   
			   if(user.getEmail().equals(emailID)) {
				   match = true;
			   }
		   }
		   return match;
		}
	   
	   
	   
	   // update
	   public boolean updateUserById(User user) throws SQLException {
		    Connection connection = getConnection();

		    String updateQuery = "UPDATE data SET name=?, middlename=?, lastname=?, phone=?, age=?, role=?, password=? WHERE id=?";
		    PreparedStatement pst = connection.prepareStatement(updateQuery);
		    pst.setString(1, user.getname());
		    pst.setString(2, user.getmiddlename());
		    pst.setString(3, user.getlastname());
		    pst.setString(4, user.getphone());
		    pst.setInt(5, user.getage());
		    pst.setString(6, user.getRole());
		    pst.setString(7, user.getPassword());
		    pst.setInt(8, user.getid());

		    // Execute query
		    int rows = pst.executeUpdate();

		    // Close resources
		    pst.close();
		    connection.close();

		    // Return Successful or not
		    return rows > 0;
		}

	

	public int executeUpdate(User user) throws SQLException {
	
		return 0;
	}

	   
	   
	   
	
//	  public boolean isEmailRegistered(String email) throws SQLException {
//	        Connection connection = getConnection();
//
//	        String selectQuery = "SELECT COUNT(*) FROM user WHERE email = ?";
//	        PreparedStatement pst = connection.prepareStatement(selectQuery);
//	        pst.setString(1, email);
//	        ResultSet resultSet = pst.executeQuery();
//
//	        resultSet.next();
//	        int count = resultSet.getInt(1);
//	        return count > 0;
//	    }
	
}
