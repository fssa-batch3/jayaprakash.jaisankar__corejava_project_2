package TestUpdateFeature;

import static org.junit.Assert.*;

import org.junit.Test;
import registration.dao.UserDAO;
import registration.model.User;

import java.sql.SQLException;

public class TestUpdate {

    private UserDAO createUserDAOMock(final int executeUpdateReturnValue) {
        return new UserDAO() {
            @Override
            public int executeUpdate(User user) throws SQLException {
                return executeUpdateReturnValue;
            }
        };
    }

    @Test
    public void testUpdateUserById_Success() throws SQLException {
        UserDAO userDAO = createUserDAOMock(1);

        User user = new User("sachin", "vasanth", "priyanJAYAPRAKASH", "9876543210", 18, "jayaprakashj@gmail.com", "user", "Vasanth@123", 1);

        boolean result = userDAO.updateUserById(user);

        assertTrue(result);
    }

    @Test
    public void testUpdateUserById_Failure() throws SQLException {
        UserDAO userDAO = createUserDAOMock(0);

        User user = new User("sachin", "vasanth", "priyan", "9876543210", 18, "jayaprakashj@gmail.com", "user", "Vasanth@123", 1);

        boolean result = userDAO.updateUserById(user);

        assertFalse(result);
    }
}
