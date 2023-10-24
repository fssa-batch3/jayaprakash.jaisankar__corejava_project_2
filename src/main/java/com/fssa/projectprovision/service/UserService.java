package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.*;

import com.fssa.projectprovision.exception.*;
import com.fssa.projectprovision.model.*;
import com.fssa.projectprovision.utils.Passwordutil;
import com.fssa.projectprovision.validation.*;

import java.util.List;


/**
 * 
 * A service class that provides methods for managing user-related operations in the system.
 * This class interacts with the UserDAO and UserValidator to perform operations on users.
 * It handles user registration, login, retrieval, update, and deletion.
 * Additionally, it provides methods for getting user information by email.
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */
public class UserService {
    private static final String USER_WITH_EMAIL = "User with email ";

    
    /**
     * Registers a new user in the system.
     * 
     * @param user The user to be registered.
     * @return A message indicating the success or failure of the registration.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public String registerUser(User user) throws ServiceException {
        try {
            UserValidator userValidator = new UserValidator(user);
            userValidator.validateAll();

            User existingUser = UserDAO.getUserByEmail(user.getEmail());
            if (existingUser != null && existingUser.isActive()) {
                throw new ServiceException("Email id " + user.getEmail() + " is already registered");
            }

            // Hash the user's password before storing it
            String hashedPassword = Passwordutil.hashPassword(user.getPassword());
            user.setPassword(hashedPassword);

            if (UserDAO.createUser(user)) {
                return "Registration Successful";
            } else {
                throw new ServiceException("Registration Failed");
            }
        } catch (ValidationException e) {
            throw new ServiceException("Invalid User", e);
        } catch (DAOException e) {
            throw new ServiceException("Database Error", e);
        }
    }
    

    /**
     * Logs in a user with the provided credentials.
     * 
     * @param user The user with login credentials.
     * @return The logged-in user, or null if login fails.
     * @throws ServiceException If there's an issue with the service operation.
     */

    public User loginUser(User user) throws ServiceException {
        try {
            if (user.getEmail() == null || user.getPassword() == null) {
                throw new ServiceException("Invalid User Credentials");
            }
            if (!UserValidator.validateEmail(user.getEmail())) {
                throw new ValidationException("Invalid Email");
            }
            User fromDb = UserDAO.getUserByEmail(user.getEmail());
            if (fromDb != null && Passwordutil.checkPassword(user.getPassword(), fromDb.getPassword())) {
                String taskAssignee = UserDAO.getTaskAssigneeByEmail(user.getEmail());
                fromDb.setTaskAssignee(taskAssignee);
                return fromDb;
            } else {
                throw new ServiceException("User Not Found");
            }
        } catch (ValidationException e) {
            throw new ServiceException(e);
        } catch (DAOException e) {
            throw new ServiceException("Database Error", e);
        }
    }

    
    /**
     * Retrieves a list of all users in the system.
     * 
     * @return A list of all users in the system.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public List<User> getAllUsers() throws ServiceException {
        try {
            return UserDAO.getAllUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    
    /**
     * Updates an existing user in the system.
     * 
     * @param user The user to be updated.
     * @return The updated user, or null if update fails.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public User updateUser(User user) throws ServiceException {
        try {
            User existingUser = UserDAO.getUserByEmail(user.getEmail());
            if (existingUser == null) {
                throw new ServiceException(USER_WITH_EMAIL + user.getEmail() + " does not exist.");
            }
            
            if (existingUser.isDeleted()) {
                throw new ServiceException(USER_WITH_EMAIL + user.getEmail() + " has been deleted.");
            }
            
            if (!UserDAO.updateUser(user)) {
                throw new ServiceException("User Update Failed");
            }

            return UserDAO.getUserByEmail(user.getEmail());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    
    
    
    /**
     * Deletes a user by email.
     * 
     * @param email The email of the user to delete.
     * @return True if the deletion is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     */

    public boolean deleteUser(String email) throws ServiceException {
        try {
            User existingUser = UserDAO.getUserByEmail(email);
            if (existingUser == null) {
                throw new ServiceException(USER_WITH_EMAIL + email + " does not exist.");
            }
            
            if (existingUser.isDeleted()) {
                throw new ServiceException(USER_WITH_EMAIL + email + " has already been deleted.");
            }
            
            if (!existingUser.isActive()) {
                throw new ServiceException(USER_WITH_EMAIL + email + " is already inactive.");
            }
            
            return UserDAO.deleteUserByEmail(email);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    

    public boolean deleteUser(long userId) {
        try {
            return UserDAO.deleteUserById(userId);
        } catch (DAOException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    /**
     * Retrieves a user by their user ID.
     *
     * @param userId The user's ID as a Long.
     * @return The retrieved user, or null if not found.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public User getUserById(Long userId) throws ServiceException {
        try {
            return UserDAO.getUserById(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    /**
     * Retrieves a user by email.
     * 
     * @param email The email of the user to retrieve.
     * @return The retrieved user, or null if not found.
     */

	public User getUserByEmail1(String email) {
		return null;
	}

	 /**
     * Retrieves a user by email, including deleted users.
     * 
     * @param emailToDelete The email of the user to retrieve.
     * @return The retrieved user, or null if not found.
     */


	
	  /**
     * Retrieves a user by email.
     * 
     * @param email The email of the user to retrieve.
     * @return The retrieved user, or null if not found.
     */




	public int getId(int userId) {
		return userId;
	}



	public int getUserById(int userId) {
		return userId;
	}



	public User getUserByEmailIncludingDeleted(String emailToDelete) {
		
		return null;
	}




}
