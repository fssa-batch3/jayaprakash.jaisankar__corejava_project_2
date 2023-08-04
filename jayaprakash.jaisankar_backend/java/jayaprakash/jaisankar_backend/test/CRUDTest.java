package jayaprakash.jaisankar_backend.test;



import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jayaprakash.jaisankar_backend.App;
import jayaprakash.jaisankar_backend.User;

public class CRUDTest {

    private static final String url = "jdbc:mysql://localhost:3306/backend";
    private static final String username = "root";
    private static final String password = "123456";

    private App app;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        app = new App();
        connection = DriverManager.getConnection(url, username, password);
    }

    @After
    public void tearDown() throws SQLException {
        // Close the connection after each test
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testRegister() throws SQLException {
        // Prepare test data
        User testUser = new User("jaya@gmail.com", "ajai", "pass", "1390-03-09", "9876543210", "ajai", "susi");

        // Perform the registration
        boolean isRegistered = app.register(testUser);

        // Check if registration is successful
        assertTrue(isRegistered);
    }

    @Test
    public void testUpdateUser() throws SQLException {
        // Prepare test data
        User testUser = new User("jaya@gmail.com", "ajai", "pass", "1390-03-09", "9876543210", "ajai", "susi");

        // Register the user first
        app.register(testUser);

        // Update the user's phone number
        testUser.setphone("9876543210");
        boolean isUpdated = app.updateUser(testUser);

        // Check if update is successful
        assertTrue(isUpdated);
    }

    @Test
    public void testDeleteUser() throws SQLException {
        // Prepare test data
        User testUser = new User("jaya@gmail.com", "ajai", "pass", "1390-03-09", "9876543210", "ajai", "susi");

        // Register the user first
        app.register(testUser);

        // Delete the user
        boolean isDeleted = app.deleteUser(testUser.getemail());

        // Check if deletion is successful
        assertTrue(isDeleted);
    }
}
