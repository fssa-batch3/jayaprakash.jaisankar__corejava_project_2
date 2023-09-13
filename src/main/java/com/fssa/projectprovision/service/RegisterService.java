package com.fssa.projectprovision.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.fssa.projectprovision.dao.RegisterDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Register;
import com.fssa.projectprovision.validation.RegistrationValidator;

/**
 * A service class that provides methods for managing user-related operations in the system.
 * This class interacts with the RegisterDAO and RegistrationValidator to perform operations on users.
 * It handles user registration, login, retrieval, update, and deletion.
 * Additionally, it provides methods for getting user information by email.
 * 
 * @author JayaprakashJaisankar
 */
public class RegisterService {
    private RegisterDAO registerDAO;

    public RegisterService(Connection connection) {
        this.registerDAO = (RegisterDAO) connection;
    }

    /**
     * Registers a new user in the system.
     * 
     * @param user The user to be registered.
     * @return A message indicating the success or failure of the registration.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public String registerUser(Register user) throws ServiceException {
        try {
            RegistrationValidator registrationValidator = new RegistrationValidator();
            registrationValidator.validateAll(user);

            if (registerDAO.insertUser(user)) {
                return "Registration Successful";
            } else {
                throw new ServiceException("Registration Failed");
            }
        } catch (ValidationException e) {
            throw new ServiceException("Invalid User", e);
        }
    }

    /**
     * Logs in a user with the provided credentials.
     * 
     * @param email The user's email.
     * @param password The user's password.
     * @return The logged-in user, or null if login fails.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public Register loginUser(String email, String password) throws ServiceException {
        try {
            Register user = registerDAO.loginUser(email, password);
            if (user != null) {
                return user;
            } else {
                throw new ServiceException("User Not Found");
            }
        } catch (ServiceException e) {
            throw new ServiceException("Database Error", e);
        }
    }

    /**
     * Retrieves a list of all users in the system.
     * 
     * @return A list of all users in the system.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public List<Register> getAllUsers() throws ServiceException {
        try {
            return registerDAO.getAllUsers();
        } 
        catch (SQLException e) {
            e.printStackTrace(); 
        }
		return null;
    }

    /**
     * Updates an existing user in the system.
     * 
     * @param user The user to be updated.
     * @return The updated user, or null if update fails.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public Register updateUser(Register user) throws ServiceException {
        try {
            if (registerDAO.updateUser(user)) {
                return registerDAO.getUserByEmail(user.getEmail());
            } else {
                throw new ServiceException("User Update Failed");
            }
        } catch (ServiceException e) {
            throw new ServiceException("Database Error", e);
        }
    }

    /**
     * Deletes a user by email.
     * 
     * @param email The email of the user to delete.
     * @return True if the deletion is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public boolean deleteUser(String email) throws ServiceException, DAOException {
        return registerDAO.deleteUser(email);
    }

    /**
     * Retrieves a user by email.
     * 
     * @param email The email of the user to retrieve.
     * @return The retrieved user, or null if not found.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public Register getUserByEmail(String email) throws ServiceException, DAOException {
        return registerDAO.getUserByEmail(email);
    }
}
