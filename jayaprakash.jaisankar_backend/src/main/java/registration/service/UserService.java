package registration.service;

import registration.dao.UserDAO;
import registration.model.User;
import registration.service.exception.serviceException;
import registration.validation.UserValidator;

import java.sql.SQLException;

import com.google.protobuf.ServiceException;

import jayaprakash.jaisankar_backend.UserManagementCRUD.InvalidUserException;

public class UserService {

    public boolean registerUser(User user) throws ServiceException, InvalidUserException {
        UserDAO userDAO = new UserDAO();
        User user1 = new User(user.getEmail(), user.getPassword());
        try {
            if (UserValidator.validateUser(user) && userDAO.EmailExist(user1) == false) {
                if (userDAO.register(user)) {
                    System.out.println(user.getname() + " Successfully Registered!");
                    return true;
                } else {
                    System.out.println("Registration not successful! \n Validation Failed Or User Already Exist");
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    public boolean loginUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            if (userDAO.login(user)) {
                System.out.println("\n" + user.getEmail() + " Login Successful!");
                return true;
            } else {
                System.out.println("\n" + " Login Not Successful! ReCheck Your Credentials");
                return false;
            }
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }
    
    
    //update
//    
//    
//    public boolean updateUser(User user) throws ServiceException {
//        UserDAO userDAO = new UserDAO();
//        try {
//            if (userDAO.updateUserById(user)) {
//                System.out.println("User with ID " + user.getid() + " Successfully Updated!");
//                return true;
//            } else {
//                System.out.println("User Update Not Successful!");
//                return false;
//            }
//        } catch (SQLException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    
    
}
