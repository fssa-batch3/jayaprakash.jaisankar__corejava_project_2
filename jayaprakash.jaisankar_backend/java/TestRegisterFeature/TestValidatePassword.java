package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidatePassword {

    @Test
    public void testValidPassword() {
        // A valid password with all requirements
        assertTrue(UserValidator.validatePassword("Vasanth@123"));
    }

    @Test
    public void testInvalidPasswordWithoutSpecialCharacters() {
        // Missing special character
        assertFalse(UserValidator.validatePassword("Vasanth123"));
    }

    @Test
    public void testInvalidPasswordWithoutNumbers() {
        // Missing numbers
        assertFalse(UserValidator.validatePassword("Vasanth@abc"));
    }

    @Test
    public void testInvalidPasswordWithoutSpecialAlphabets() {
        // Missing special character
        assertFalse(UserValidator.validatePassword("@12312345"));
    }

    @Test
    public void testInvalidPasswordLengthLessThan8() {
        // Password length less than 8 characters
        assertFalse(UserValidator.validatePassword("Vas@123"));
    }

    @Test
    public void testInvalidPasswordWithoutUppercase() {
        // Password without uppercase character
        assertFalse(UserValidator.validatePassword("vasanth@123"));
    }
}
