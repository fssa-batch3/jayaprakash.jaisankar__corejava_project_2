package jayaprakash.jaisankar_backend.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import java.sql.SQLException;
import org.junit.Test;
import jayaprakash.jaisankar_backend.App;
import jayaprakash.jaisankar_backend.User;

public class AppTest {
    private App app = new App();

    @Test
    public void testLogin() {
        assertTrue(app.login("jane123", "Jane")); // Assuming this user exists
        assertFalse(app.login("invalid@example.com", "invalid123")); // Assuming this user doesn't exist
    }

    @Test
    public void testRegister() {
        User user = new User("jayaprakash@gmail.com", "jp123", "Jaya", "prakash", "2004-09-30", "9876543210", "Jaya", "prakash");

        // Use assertThrows to handle the SQLException and ensure that the method throws the exception
        assertThrows(SQLException.class, () -> {
            app.register(user);
        });
    }
}
