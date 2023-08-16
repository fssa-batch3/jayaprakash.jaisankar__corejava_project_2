package com.fssa.projectprovision.validation;


import com.fssa.projectprovision.validation.UserValidator;


import com.fssa.projectprovision.exception.ValidationException;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserValidator {

    private final UserValidator userValidator = new UserValidator();

//    @Test
//    void testValidId() {
//        int validId = 123;
//       
//            assertTrue(userValidator.validateId(validId));
//        
//    }
//
//    @Test
//    void testInvalidId() {
//        int invalidId = -1;
//        assertThrows(ValidationException.class, () -> userValidator.validateId(invalidId));
//    }

    @Test
    void testValidName() {
        String validName = "Jayaprakash";
        try {
            assertTrue(userValidator.validateName(validName));
        } catch (ValidationException e) {
            fail("Validation exception not expected for valid name.");
        }
    }

    @Test
    void testInValidName_EmptyName() {
        String emptyName = "";
        assertThrows(ValidationException.class, () -> userValidator.validateName(emptyName));
    }

    @Test
    void testValidGender() {
        String validGender = "M";
        try {
            assertTrue(userValidator.validateGender(validGender));
        } catch (ValidationException e) {
            fail("Validation exception not expected for valid gender.");
        }
    }

    @Test
    void testInvalidGender() {
        String invalidGender = "invalid";
        assertThrows(ValidationException.class, () -> userValidator.validateGender(invalidGender));
    }

    @Test
    void testValidMobileNumber() {
        String validMobileNumber = "1234567890";
        try {
            assertTrue(userValidator.validateMobileNumber(validMobileNumber));
        } catch (ValidationException e) {
            fail("Validation exception not expected for valid mobile number.");
        }
    }

//    @Test
//   void testInvalidMobileNumber() {
//        String invalidMobileNumber = "invalid";
//        assertThrows(ValidationException.class,
//            () -> userValidator.validateMobileNumber(invalidMobileNumber),
//            "Expected ValidationException for invalid mobile number"
//        );
//    }


    @Test
    void testValidDateOfBirth() {
        LocalDate validDateOfBirth = LocalDate.of(1990, 1, 1);
        try {
            assertTrue(userValidator.validateDateOfBirth(validDateOfBirth));
        } catch (ValidationException e) {
            fail("Validation exception not expected for valid date of birth.");
        }
    }

    @Test
    void testInvalidDateOfBirth_Future() {
        LocalDate futureDateOfBirth = LocalDate.now().plusYears(1);
        assertThrows(ValidationException.class, () -> userValidator.validateDateOfBirth(futureDateOfBirth));
    }

  
    @Test
    void testValidAddress() {
        String validAddress = "123 Main St, City";
      
            try {
				assertTrue(userValidator.validateAddress(validAddress));
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }

    @Test
    void testInvalidAddress_Empty() {
        String emptyAddress = "";
        assertThrows(ValidationException.class, () -> userValidator.validateAddress(emptyAddress));
    }

    @Test
    void testValidAboutMe() {
        String validAboutMe = "Hello, I'm Jp!";
       
            try {
				assertTrue(userValidator.validateAboutMe(validAboutMe));
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
    }

    @Test
    void testInvalidAboutMe_Empty() {
        String emptyAboutMe = "";
        assertThrows(ValidationException.class, () -> userValidator.validateAboutMe(emptyAboutMe));
    }

    @Test
    void testValidEmail() {
        String validEmail = "jayaprakash@example.com";
        try {
            assertTrue(userValidator.validateEmail(validEmail));
        } catch (ValidationException e) {
            fail("Validation exception not expected for valid email.");
        }
    }

    @Test
    void testInvalidEmail_InvalidFormat() {
        String invalidEmail = "invalid_email";
        assertThrows(ValidationException.class, () -> userValidator.validateEmail(invalidEmail));
    }

    @Test
    void testValidPassword() {
        String validPassword = "SecurePass123";
        try {
            assertTrue(userValidator.validatePassword(validPassword));
        } catch (ValidationException e) {
            fail("Validation exception not expected for valid password.");
        }
    }

    @Test
    void testInvalidPassword_Short() {
        String shortPassword = "short";
        assertThrows(ValidationException.class, () -> userValidator.validatePassword(shortPassword));
    }

    @Test
    void testValidProfilePic() {
        String validProfilePic = "https://example.com/profile.jpg";
        try {
            assertTrue(userValidator.validateProfilePic(validProfilePic));
        } catch (ValidationException e) {
            fail("Validation exception not expected for valid profile pic.");
        }
    }

    @Test
    void testInvalidProfilePic_Empty() {
        String emptyProfilePic = ""; 
        assertThrows(ValidationException.class, () -> userValidator.validateProfilePic(emptyProfilePic));
    }

    @Test
    void testValidMyTodos() throws ValidationException {
        String validMyTodos = "[{\"task\":\"Buy groceries\",\"status\":\"pending\"}]";
        assertTrue(userValidator.validateMyTodos(validMyTodos));
    }

//    @Test
//    void testInvalidMyTodos() {
//        String invalidMyTodos = "invalidJSON";
//        assertThrows(ValidationException.class, () -> userValidator.validateMyTodos(invalidMyTodos));
//    }

    @Test
    void testValidUserId() throws ValidationException {
        long validUserId = 12345;
        assertTrue(userValidator.validateUserId(validUserId));
    }

    @Test
    void testInvalidUserId() {
        long invalidUserId = 0;
        assertThrows(ValidationException.class, () -> userValidator.validateUserId(invalidUserId));
    }
   
}
