
package jayaprakash.jaisankar_backend.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jayaprakash.jaisankar_backend.UserManagementCRUD.*;
import jayaprakash.jaisankar_backend.UserManagementCRUD.InvalidUserException;

public class UserManagementCRUDTest {

    private UserManagementService userManagementService;

    @BeforeEach
    public void setUp() {
        // Create an instance of UserManagementService before each test
        userManagementService = new UserManagementService();
    }

    @Test
    public void testRegisterUserValidUser() throws Throwable {
        // Test registering a valid user
        User newUser = new User("jairjj", "jaijj@gmail.com", "98765432", "1390-09-11", "0987654321", "kanna", "kumar");
        boolean isInserted = userManagementService.registerUser(newUser);
        assertTrue(isInserted);
    }

    @Test
    public void testRegisterUserDuplicateEmail() throws Throwable {
        // Test registering a user with a duplicate email
        User existingUser = new User("ajaijjj", "jayaprakashjj@gmail.com", "98765432", "1390-09-11", "0987654321", "ajai", "kumar");
        User duplicateUser = new User("jayajj", "jayaprakashjj@gmail.com", "98765432", "1390-09-11", "0987654321", "ajai", "kumar");
        // Register the existing user first
        userManagementService.registerUser(existingUser);

        // Try to register the duplicate user (with the same email)
        assertThrows(InvalidUserException.class, () -> userManagementService.registerUser(duplicateUser));
    }

    @Test
    public void testRegisterUserNullUser() throws Throwable {
        // Test registering a null user
        assertThrows(InvalidUserException.class, () -> userManagementService.registerUser(null));
    }

    @Test
    public void testRegisterUserEmptyFields() throws Throwable {
        // Test registering a user with empty fields
        User userWithEmptyFields = new User("", "", "", "", "", "", "");
        assertThrows(InvalidUserException.class, () -> userManagementService.registerUser(userWithEmptyFields));
    }

    @Test
    public void testRegisterUserNullFields() throws Throwable {
        // Test registering a user with null fields
        User userWithNullFields = new User(null, null, null, null, null, null, null);
        assertThrows(InvalidUserException.class, () -> userManagementService.registerUser(userWithNullFields));
    }
}
