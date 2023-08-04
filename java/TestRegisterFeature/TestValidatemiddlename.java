package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import registration.validation.UserValidator;

public class TestValidatemiddlename {

    @Test
    public void testValidMiddlename() {
        assertTrue(UserValidator.validateMiddlename("Priyan"));
    }

    @Test
    public void testMiddlenameWithNumbers() {
        assertFalse(UserValidator.validateMiddlename("Priyan123"));
    }

    @Test
    public void testMiddlenameWithSpecialCharacters() {
        assertFalse(UserValidator.validateMiddlename("Vasanth@Priyan"));
    }

 
    
    @Test
    public void testNameWithEmptyString() {
        assertFalse(UserValidator.validateMiddlename(""));
    }
}
