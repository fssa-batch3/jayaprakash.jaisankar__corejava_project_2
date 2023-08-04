package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidateRole {

    @Test
    public void testValidRole() {
        assertTrue(UserValidator.validateRole("user"));
    }

    @Test
    public void testInvalidRole() {
        assertFalse(UserValidator.validateRole("total"));
    }
}
