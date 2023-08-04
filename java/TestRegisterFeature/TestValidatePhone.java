
package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidatePhone {

    @Test
    public void testValidPhone() {
        assertTrue(UserValidator.validatePhone("9876543210"));
    }

    @Test
    public void testPhoneWithAlphabets() {
        assertFalse(UserValidator.validatePhone("12345abcde"));
    }

    @Test
    public void testPhoneWithSpecialCharacters() {
        assertFalse(UserValidator.validatePhone("123-456-7890"));
    }

    @Test
    public void testPhoneWithInvalidLength() {
        assertFalse(UserValidator.validatePhone("12345"));
    }
}
