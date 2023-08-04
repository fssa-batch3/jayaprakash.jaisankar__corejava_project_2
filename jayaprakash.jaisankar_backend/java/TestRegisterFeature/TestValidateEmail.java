package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidateEmail {

    @Test
    public void testValidEmail() {
        assertTrue(UserValidator.validateEmail("Vasanthpriyan@gmail.com"));
    }

    @Test
    public void testInvalidEmailWithoutAtSymbol() {
        assertFalse(UserValidator.validateEmail("Vasanthpriyangmail.com"));
    }

    @Test
    public void testInvalidEmailWithSpecialCharacters() {
        assertFalse(UserValidator.validateEmail("Vasanthpriyan@gma$il.com"));
    }

    @Test
    public void testInvalidEmailWithoutDomain() {
        assertFalse(UserValidator.validateEmail("Vasanthpriyan@.com"));
    }
}
