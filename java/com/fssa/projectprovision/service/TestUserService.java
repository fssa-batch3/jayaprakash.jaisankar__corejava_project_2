package com.fssa.projectprovision.service;


import com.fssa.projectprovision.dao.*;
import com.fssa.projectprovision.exception.*;
import com.fssa.projectprovision.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class TestUserService {

    private UserService userService;
    private User user;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
        user = new User();
        user.setName("Jayaprakashj");
        user.setEmail("jayaprakashsachink@example.com");
        user.setMobileNumber("1234567890");
        user.setDateOfBirth(Date.valueOf(LocalDate.parse("2002-06-28")));
        user.setAddress("Sample Address");
        user.setAboutMe("About me");
        user.setPassword("password123");
        user.setGender("M");
        user.setProfilePic("http://www.example.com/index.html");
        user.setMyTodos("[]");
        user.setUserId(1L);
    }

    @Order(1)
    @Test 
    void testValidRegisterUser() {
        try {
            User existingUser = UserDAO.getUserByEmail(user.getEmail());
            assertNull(existingUser, "User with email " + user.getEmail() + " should not exist");
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
        User nonExistentUser = new User();
        nonExistentUser.setEmail("kishor@example.com");
        nonExistentUser.setPassword("invalid password");
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
        User nonExistentUser = new User();
        nonExistentUser.setEmail("nonexistent@example.com");
        nonExistentUser.setPassword("invalid password");
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
            user.setName("Vasanthapriyan");
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
        User nonExistentUser = new User();
        nonExistentUser.setEmail("example@example.com");
        nonExistentUser.setName("Invalid Update Name");
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
        User nonExistentUser = new User();
        nonExistentUser.setEmail("example@example.com");
        assertThrows(ServiceException.class, () -> userService.deleteUser(nonExistentUser.getEmail()));
    }
}
