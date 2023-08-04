package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.google.protobuf.ServiceException;


import registration.model.User;
import registration.service.UserService;
import registration.validation.exception.InvalidUserException;
import registration.dao.UserDAO;

public class TestRegister {
	
    @Test
    @DisplayName("Test Successful Registration")
    public void testRegistrationSuccess() throws jayaprakash.jaisankar_backend.UserManagementCRUD.InvalidUserException {
        // Create a mock UserDAO for testing purposes (you may need to use a real one in your implementation)
        UserDAO mockUserDAO = new UserDAO();

        // Create an instance of UserService and pass the mock UserDAO to it
        UserService userService = new UserService();

        // Create a test user object
        User user1 = new User("sachin", "vasanth", "priyan", "9876543210", 18, "jayaprakashJP@gmail.com", "user", "Vasanth@123", 2);

        try {
            // Perform the registration process
            boolean registrationSuccess = false;
            	
			registrationSuccess = userService.registerUser(user1);

            // Assert that the registration process is successful
            assertTrue(registrationSuccess);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
