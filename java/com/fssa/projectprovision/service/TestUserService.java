package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.UserDAO;
import com.fssa.projectprovision.exception.DAOException;
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
                        "Sample Address", "About Me", "jayaprakash@example.com", "password123",
                        "http://www.example.com/index.html", "{}", 1);
    }

    @Order(1)
    @Test
    void testValidRegisterUser() {
        try {
            User existingUser = UserDAO.getUserByEmail(user.getEmail());
            //assertNull(existingUser, "User with email " + user.getEmail() + " should not exist");
            String result = userService.registerUser(user);
            assertEquals("Registration Successful", result);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }

    @Order(2)
    @Test
    void testInvalidRegisterUser() {
        User nonExistentUser = new User("Invalid", "F", "9876543210", LocalDate.now(),
                                        "Invalid Address", "Invalid About Me",
                                        "invalid@example.com", "pass", "", "{}", 2);
        assertThrows(ServiceException.class, () -> userService.registerUser(nonExistentUser));
    }


    @Test
    @Order(3)
    void testValidLogin() {
        try {
            User loggedInUser = userService.loginUser(user);
            assertNotNull(loggedInUser);
            assertEquals(user.getEmail(), loggedInUser.getEmail());
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(4)
    void testInvalidLogin() {
        User nonExistentUser = new User("Nonexistent", "M", "9876543210", LocalDate.now(),
                                        "Nonexistent Address", "Nonexistent About Me",
                                        "nonexistent@example.com", "invalidpass",
                                        "", "{}", 3);
        assertThrows(ServiceException.class, () -> userService.loginUser(nonExistentUser));
    }

    @Test
    @Order(5)
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
    @Order(6)
    void testValidUpdateUser() {
        try {
            user.setName("Updated Name");
            User updatedUser = userService.updateUser(user);
            assertNotEquals(user, updatedUser);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(7)
    void testInvalidUpdateUser() {
        User nonExistentUser = new User("Invalid Update Name", "F", "9876543210",
                                        LocalDate.now(), "Invalid Address",
                                        "Invalid About Me", "invalidupdate@example.com",
                                        "invalidpass", "", "{}", 4);
        assertThrows(ServiceException.class, () -> userService.updateUser(nonExistentUser));
    }

    @Test
    @Order(8)
    void testValidDeleteUser() {
        try {
            boolean isDeleted = userService.deleteUser(user.getEmail());
            assertTrue(isDeleted);
            User deletedUser = UserDAO.getUserByEmail(user.getEmail());
            assertNull(deletedUser);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(9)
    void testInvalidDeleteUser() {
        User nonExistentUser = new User("Invalid Delete Name", "M", "9876543210",
                                        LocalDate.now(), "Invalid Address",
                                        "Invalid About Me", "invaliddelete@example.com",
                                        "invalidpass", "", "{}", 5);
        assertThrows(ServiceException.class, () -> userService.deleteUser(nonExistentUser.getEmail()));
    }

}
