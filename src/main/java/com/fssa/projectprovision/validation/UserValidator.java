package com.fssa.projectprovision.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.User;


/**
 * 
 * 
 * A utility class for validating User objects.
 * This class provides methods to validate various attributes of a User object.
 * 
 * 
 * Usage:
 * User user = ...; // Get a User object to validate
 * UserValidator userValidator = new UserValidator(user);
 * userValidator.validateAll();
 * // Validation checks will be performed for various attributes
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */
public class UserValidator {
    private User user;

    
    /**
     * Constructs a UserValidator with the specified User object.
     * 
     * @param user The User object to validate.
     */
    public UserValidator(User user) {
        this.user = user;
    }

    
    /**
     * Constructs an empty UserValidator.
     */
    public UserValidator() {
    	
    }

    
    /**
     * Validates all attributes of the User object.
     * 
     * @return True if all attributes are valid, otherwise throws ValidationException.
     * @throws ValidationException If any validation checks fail.
     */
    public boolean validateAll() throws ValidationException {
        return validateMobileNumber(user.getMobileNumber()) &&
                validatePassword(user.getPassword()) &&
                validateGender(user.getGender()) &&
                validateEmail(user.getEmail()) &&
                validateProfilePic(user.getProfilePic()) &&
                validateName(user.getName()) &&
                validateDateOfBirth(user.getDateOfBirth());
    }

    
    /**
     * Validates the mobile number.
     * 
     * @param mobileNumber The mobile number to validate.
     * @return True if the mobile number is valid.
     * @throws ValidationException If the mobile number is empty or fails validation rules.
     */
   
	public boolean validateMobileNumber(String mobileNumber) throws ValidationException {
        if (mobileNumber == null || mobileNumber.isEmpty()) {
            throw new ValidationException("Mobile number cannot be empty");
        }
        return true;
    }
	
   /**
     * Validates the password.
     * 
     * @param password The password to validate.
     * @return True if the password is valid.
     * @throws ValidationException If the password is empty or fails validation rules.
     */

    public boolean validatePassword(String password) throws ValidationException {
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be empty");
        } else if (password.length() < 8) {
            throw new ValidationException("Password is less than the expected length of 8 characters");
        }
        return true;
    }
    
    /**
     * Validates the user's gender.
     * 
     * @param gender The user's gender to validate.
     * @return True if the gender is valid.
     * @throws ValidationException If the gender is not 'M' or 'F'.
     */

    public boolean validateGender(String gender) throws ValidationException {
        if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
            throw new ValidationException("Invalid gender. Gender must be 'M' or 'F'.");
        }
        return true;
    }
    
    /**
     * Validates the user's email.
     * 
     * @param email The user's email to validate.
     * @return True if the email is valid.
     * @throws ValidationException If the email is empty or has an invalid format.
     */
    
    public static boolean validateEmail(String email) throws ValidationException {
        final String emailRegEx = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (email == null || email.isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }
        if (!Pattern.compile(emailRegEx).matcher(email).matches()) {
            throw new ValidationException("Invalid email format");
        }

        return true;
    }
    
    /**
     * Validates the user's profile picture URL.
     * 
     * @param profilePic The URL of the user's profile picture to validate.
     * @return True if the profile picture URL is valid.
     * @throws ValidationException If the profile picture URL is empty.
     */

    public boolean validateProfilePic(String profilePic) throws ValidationException {
        if (profilePic == null || profilePic.isEmpty()) {
            throw new ValidationException("Profile pic URL cannot be empty");
        }
        return true;
    }
    
    /**
     * Validates the user's name.
     * 
     * @param name The user's name to validate.
     * @return True if the name is valid.
     * @throws ValidationException If the name is empty.
     */
    

    public boolean validateName(String name) throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name cannot be empty");
        }
        return true;
    }

    
    /**
     * Validates the user's date of birth.
     * 
     * @param validDateOfBirth The user's date of birth to validate.
     * @return True if the date of birth is valid.
     * @throws ValidationException If the date of birth is empty or fails validation rules.
     */
    public boolean validateDateOfBirth(LocalDate validDateOfBirth) throws ValidationException {
        if (validDateOfBirth == null) {
            throw new ValidationException("Date of birth cannot be empty");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate minimumValidDob = currentDate.minusYears(10);
        if (validDateOfBirth.isAfter(currentDate) || validDateOfBirth.isAfter(minimumValidDob)) {
            throw new ValidationException("Invalid date of birth. Must be at least 10 years old.");
        }
        return true;
    }


    /**
     * Validates the user's address.
     * 
     * @param address The user's address to validate.
     * @return True if the address is valid.
     * @throws ValidationException If the address is empty.
     */
    
    public boolean validateAddress(String address) throws ValidationException {
        if (address == null || address.isEmpty()) {
            throw new ValidationException("Address cannot be empty");
        }

        return true;
    }
    
    /**
     * Validates the user's "About Me" section.
     * 
     * @param aboutMe The user's "About Me" section to validate.
     * @return True if the "About Me" section is valid.
     * @throws ValidationException If the "About Me" section is empty.
     */

    public boolean validateAboutMe(String aboutMe) throws ValidationException {
        if (aboutMe == null || aboutMe.isEmpty()) {
            throw new ValidationException("About me cannot be empty");
        }
        return true;
    }
    

    /**
     * Validates the user's TODOs.
     * 
     * @param myTodos The user's TODOs to validate.
     * @return True if the TODOs are valid.
     * @throws ValidationException If the TODOs are invalid.
     */


    public boolean validateMyTodos(String myTodos) throws ValidationException {
   
        return true;
    } 

    
    /**
     * Validates the user ID.
     * 
     * @param userId The user ID to validate.
     * @return True if the user ID is valid.
     * @throws ValidationException If the user ID is invalid.
     */
    public boolean validateUserId(long userId) throws ValidationException {
        if (userId <= 0) {
            throw new ValidationException("Invalid user ID");
        }
        return true;
    }
    

    /**
     * Placeholder method for validating an ID.
     * 
     * @param validId The ID to validate.
     * @return A BooleanSupplier object (implementation not provided).
     */

	public BooleanSupplier validateId(int validId) {
		return null;
	}

}



