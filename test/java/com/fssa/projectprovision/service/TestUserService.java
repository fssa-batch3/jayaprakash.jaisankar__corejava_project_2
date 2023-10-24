package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.UserDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;



import com.fssa.projectprovision.model.User;
import com.fssa.projectprovision.utils.*;


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
                        "Sample Address", "About Me", "sachiny1@example.com", "password123",
                        "http://www.example.com/index.html", "{}", 1, false);
    }
 
    @Order(1)
    @Test
    void testValidRegisterUser() {
        try {
            String originalPassword = user.getPassword();
            String hashedPassword = Passwordutil.hashPassword(originalPassword);
            user.setPassword(hashedPassword);

            String result = userService.registerUser(user);
            assertEquals("Registration Successful", result);

            User retrievedUser = UserDAO.getUserByEmail(user.getEmail());
            assertNotNull(retrievedUser);
            assertTrue(Passwordutil.checkPassword(originalPassword, retrievedUser.getPassword()));

        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        } catch (DAOException e) {
			e.printStackTrace();
		}
    }


    @Order(2)
    @Test
    void testValidLogin() {
        try {
            String originalPassword = user.getPassword();
            String hashedPassword = Passwordutil.hashPassword(originalPassword);
            user.setPassword(hashedPassword);
            userService.registerUser(user);

            User loggedInUser = userService.loginUser(user);

            assertNotNull(loggedInUser);

            assertEquals(user.getEmail(), loggedInUser.getEmail());
            assertEquals(user.getName(), loggedInUser.getName());

            assertTrue(Passwordutil.checkPassword(originalPassword, loggedInUser.getPassword()));

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
            userService.registerUser(user);
         //   Long userIdToDelete = user.getId();
            Long userIdToDelete = 1695375277170L;
            boolean isDeleted = userService.deleteUser(userIdToDelete);
            assertTrue(isDeleted);

            User deletedUser = userService.getUserById(userIdToDelete);
            assertNull(deletedUser);
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
