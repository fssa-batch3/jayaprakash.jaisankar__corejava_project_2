
package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidateName {

    @Test
    public void testNameWithValidCharacters() {
        assertTrue(UserValidator.validatename("Vasanthapriyan"));
    }

    @Test
    public void testNameWithNumbers() {
        assertFalse(UserValidator.validatename("Vasanthapriyan123"));
    }

    @Test
    public void testNameWithSpecialCharacters() {
        assertFalse(UserValidator.validatename("Vasanthapriyan@Sachin"));
    }

    @Test
    public void testNameWithEmptyString() {
        assertFalse(UserValidator.validatename(""));
    }
}
