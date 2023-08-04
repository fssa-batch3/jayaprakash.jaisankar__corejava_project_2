

package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidatelastname {

    @Test
    public void testValidLastname() {
        assertTrue(UserValidator.validateLastname("Doe"));
    }

    @Test
    public void testLastnameWithNumbers() {
        assertFalse(UserValidator.validateLastname("Doe123"));
    }

    @Test
    public void testLastnameWithSpecialCharacters() {
        assertFalse(UserValidator.validateLastname("Doe@Name"));
    }

    @Test
    public void testEmptyLastname() {
        assertFalse(UserValidator.validateLastname(""));
    }
}
