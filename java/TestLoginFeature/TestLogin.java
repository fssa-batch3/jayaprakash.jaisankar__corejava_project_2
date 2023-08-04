package TestLoginFeature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import registration.model.User;
import registration.service.UserService;

public class TestLogin {

	  @Test
	    public void testValidUser() {
	        UserService userService = new UserService();
	        User user1 = new User("jayaprakash@gmail.com", "Vasanth@123");
	        try {
	            assertTrue(userService.loginUser(user1));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }

    @Test
    public void testInvalidUser() throws ServiceException {
        UserService userService = new UserService();
        // Use incorrect password for the invalid test case
        User user1 = new User("jayaprakash@gmail.com", "InvalidPassword");
        assertFalse(userService.loginUser(user1));
    }
}
