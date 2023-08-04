package jayaprakash.jaisankar_backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserManagementCRUD {
    // User MODEL
    public static class User {
        private String username;
        private String email;
        private String password;
        private String dob;
        private String phone;
        private String firstname;
        private String lastname;

        public User(String username, String email, String password, String dob, String phone, String firstname, String lastname) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.dob = dob;
            this.phone = phone;
            this.firstname = firstname;
            this.lastname = lastname;
        }

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getDob() {
            return dob;
        }

        public String getPhone() {
            return phone;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", dob='" + dob + '\'' +
                    ", phone='" + phone + '\'' +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(email);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            User user = (User) obj;
            return Objects.equals(email, user.email);
        }
    }

    // Custom Checked Exception
    public static class InvalidUserException extends Exception {
        public InvalidUserException(String message) {
            super(message);
        }
    }

    // Validator
    private static class Validator {
        public void validateUser(User user) throws InvalidUserException {
            if (user == null || user.getUsername() == null || user.getEmail() == null || user.getPassword() == null
                    || user.getDob() == null || user.getPhone() == null || user.getFirstname() == null || user.getLastname() == null) {
                throw new InvalidUserException("User object, username, email, password, dob, phone, firstname, and lastname must not be null.");
            }

            if (user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()
                    || user.getDob().isEmpty() || user.getPhone().isEmpty() || user.getFirstname().isEmpty() || user.getLastname().isEmpty()) {
                throw new InvalidUserException("Username, email, password, dob, phone, firstname, and lastname must not be empty.");
            }
        }
    }

    // User DAO
    private static class UserDAO {
        // Connect to the database
        public Connection getConnection() throws SQLException {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root", "123456");
            return connection;
        }

        // Check if the email already exists
        public boolean checkEmailExists(String email) throws SQLException {
            Connection connection = getConnection();
            String query = "SELECT * FROM user WHERE email = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                return rs.next();
            }
        }

        // Create a new user in the database
        public boolean createUser(User user) throws SQLException {
            Connection connection = getConnection();
            String query = "INSERT INTO user (username, email, password, dob, phone, firstname, lastname) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getPassword());
                pst.setString(4, user.getDob());
                pst.setString(5, user.getPhone());
                pst.setString(6, user.getFirstname());
                pst.setString(7, user.getLastname());
                int rows = pst.executeUpdate();
                return (rows == 1);
            }
        }
    }

    // UserManagementService
    public static class UserManagementService {
        private UserDAO userDAO;
        private Validator validator;

        public UserManagementService() {
            // Create instances of DAO and Validator
            userDAO = new UserDAO();
            validator = new Validator();
        }

        // Validate user data and register a new user
        public boolean registerUser(User user) throws InvalidUserException, Throwable {
            // Perform validation
            validator.validateUser(user);

            // Check if the email already exists
            if (userDAO.checkEmailExists(user.getEmail())) {
                throw new InvalidUserException("Email Already Exists.");
            }

            // Register the new user
            try {
                return userDAO.createUser(user);
            } catch (SQLException e) {
                // Handle any database-related errors
                e.printStackTrace();
                return false;
            }
        }
    }

    // Main method for example usage
    public static void main(String[] args) throws Throwable {
        try {
            // Create a new user
            User newUser = new User("jayaprakashjai", "jayaprakashjai@gmail.com", "123456", "1990-01-01", "1234567890", "Jayaprakash", "Jaisankar");

            UserManagementService userManagementService = new UserManagementService();

            // Register the new user
            boolean isInserted = userManagementService.registerUser(newUser);
            if (isInserted) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("Failed to insert user.");
            }

        } catch (InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
