package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.dao.UserDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserDAO {

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void testCreateUser() throws DAOException {
        User user = new User("Jayaprakash", "M", "1234567890", LocalDate.parse("2002-06-28"),
                "Sample Address", "About Me", "sachinj1ztp@example.com", "password123",
                "http://www.example.com/index.html", "{}", 1, false);

        assertTrue(UserDAO.createUser(user));
    }

    @Test
    void testGetUserByEmail() throws DAOException {
        User user = UserDAO.getUserByEmail("vinit@gmail.com");
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void testGetUserByEmail_NotFound() throws DAOException {
        User user = UserDAO.getUserByEmail("nonexistent@example.com");
        assertNull(user);
    }

    @Test
    void testGetAllUsers() throws DAOException {
        assertTrue(UserDAO.getAllUsers().size() > 0);
    }

    @Test
    void testUpdateUser() throws DAOException {
        User user = UserDAO.getUserByEmail("vinit@gmail.com");
        assertNotNull(user);

        user.setName("Updated Name");
        assertTrue(UserDAO.updateUser(user));

        User updatedUser = UserDAO.getUserByEmail("vinit@gmail.com");
        assertNotNull(updatedUser);
        assertEquals("Updated Name", updatedUser.getName());
    }

    @Test
    void testDeleteUserByEmail() throws DAOException {
        boolean result = UserDAO.deleteUserByEmail("jSachin@gmail.com");
        assertTrue(result);

        User user = UserDAO.getUserByEmail("Sachin@gmail.com");
        assertNull(user);
    }

    @Test
    void testGetUserById() throws DAOException {
        User user = UserDAO.getUserById(1694058279766L);
        assertNotNull(user);
        assertEquals("Updated Name", user.getName());
    }

    @Test
    void testLoginUser() throws DAOException {
        boolean loggedIn = UserDAO.loginUser("jpja@gmail.com", "Sachin@241215");
        assertTrue(loggedIn);
    }

    @Test
    void testLoginUser_InvalidCredentials() throws DAOException {
        boolean loggedIn = UserDAO.loginUser("jpja@gmail.com", "wrongpassword");
        assertFalse(loggedIn);
    }

    @Test
    void testGetTaskAssigneeByEmail() throws DAOException {
        String taskAssignee = UserDAO.getTaskAssigneeByEmail("ndjd@gmail.com");
        assertNotNull(taskAssignee);
        assertEquals("ndjd@gmail.com", taskAssignee);
    }

    @Test
    void testDeleteUserById() throws DAOException {
        boolean result = UserDAO.deleteUserById(5L);
        assertTrue(result);

        User user = UserDAO.getUserById(5L);
        assertNull(user);
    } 
}

