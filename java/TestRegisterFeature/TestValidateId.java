package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidateId {

    @Test
    public void testValidId() {
        assertTrue(UserValidator.validateId("123"));
    }

    @Test
    public void testInvalidIdWithSpecialCharacters() {
        assertFalse(UserValidator.validateId("user@123"));
    }
    @Test
    public void testInvalidIdWithAlphate() {
        assertFalse(UserValidator.validateId("user123"));
    }

    @Test
    public void testEmptyId() {
        assertFalse(UserValidator.validateId(""));
    }
}
