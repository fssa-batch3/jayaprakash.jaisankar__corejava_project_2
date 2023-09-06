package com.fssa.projectprovision.service;

import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(OrderAnnotation.class)
class TestUserService {

    private UserService userService;
    private User user;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
        user = new User("Jayaprakash", "M", "1234567890", LocalDate.parse("2002-06-28"),
                        "Sample Address", "About Me", "sachinjp@example.com", "password123",
                        "http://www.example.com/index.html", "{}", 1, false);
    }

    @Order(1)
    @Test
    void testValidRegisterUser() {
        try {
            String result = userService.registerUser(user);
            assertEquals("Registration Successful", result);
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

   

    @Order(2)
    @Test
    void testValidLogin() {
        try {
            User loggedInUser = userService.loginUser(user);
            assertNotNull(loggedInUser);
            assertEquals(user.getEmail(), loggedInUser.getEmail());
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(3)
    void testInvalidLogin() {
        User nonExistentUser = new User("Nonexistent", "M", "9876543210", LocalDate.now(),
                                        "Nonexistent Address", "Nonexistent About Me",
                                        "nonexistent@example.com", "invalidpass",
                                        "", "{}", 3, false);
        assertThrows(ServiceException.class, () -> userService.loginUser(nonExistentUser));
    }



    @Test
    @Order(4)
    void testGetAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            assertNotNull(users);
            assertFalse(users.isEmpty());
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(5)
    void testValidUpdateUser() {
        try {
            user.setName("Updated Name");
            User updatedUser = userService.updateUser(user);
            assertNotNull(updatedUser);
            assertEquals("Updated Name", updatedUser.getName());
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(6)
    void testInvalidUpdateUser() {
        User nonExistentUser = new User("Invalid Update Name", "F", "9876543210",
                                        LocalDate.now(), "Invalid Address",
                                        "Invalid About Me", "invalidupdate@example.com",
                                        "invalidpass", "", "{}", 4, false);
        assertThrows(ServiceException.class, () -> userService.updateUser(nonExistentUser));
    }

    @Test
    @Order(7)
    void testValidDeleteUser() {
        try {
            String emailToDelete = user.getEmail(); // Use the email of the previously created user
            boolean isDeleted = userService.deleteUser(emailToDelete);
            assertTrue(isDeleted);

            // Retrieving the user again should indicate that the user is marked as deleted
            User deletedUser = userService.getUserByEmailIncludingDeleted(emailToDelete);
            assertNotNull(deletedUser);
            assertTrue(deletedUser.isDeleted());
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(8)
    void testInvalidDeleteUser() {
        User nonExistentUser = new User("Invalid Delete Name", "M", "9876543210",
                                        LocalDate.now(), "Invalid Address",
                                        "Invalid About Me", "invaliddelete@example.com",
                                        "invalidpass", "", "{}", 5, false);
        assertThrows(ServiceException.class, () -> userService.deleteUser(nonExistentUser.getEmail()));
    }


}
