package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidateAge {

    @Test
    public void testValidAge() {
        assertTrue(UserValidator.validateAge(25));
    }

    @Test
    public void testNegativeAge() {
        assertFalse(UserValidator.validateAge(-5));
    }

    @Test
    public void testExcessiveAge() {
        assertFalse(UserValidator.validateAge(150));
    }
}
