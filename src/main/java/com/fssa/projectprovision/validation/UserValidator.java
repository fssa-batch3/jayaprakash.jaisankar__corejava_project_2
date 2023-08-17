package com.fssa.projectprovision.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.User;

public class UserValidator {
    private User user;

    public UserValidator(User user) {
        this.user = user;
    }

    public UserValidator() {
    	
    }

    public boolean validateAll() throws ValidationException {
        return validateMobileNumber(user.getMobileNumber()) &&
                validatePassword(user.getPassword()) &&
                validateGender(user.getGender()) &&
                validateEmail(user.getEmail()) &&
                validateProfilePic(user.getProfilePic()) &&
                validateName(user.getName()) &&
                validateDateOfBirth(user.getDateOfBirth());
    }

   
	public boolean validateMobileNumber(String mobileNumber) throws ValidationException {
        if (mobileNumber == null || mobileNumber.isEmpty()) {
            throw new ValidationException("Mobile number cannot be empty");
        }
        // Add any additional validation rules for mobile number if needed
        return true;
    }

    public boolean validatePassword(String password) throws ValidationException {
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be empty");
        } else if (password.length() < 8) {
            throw new ValidationException("Password is less than the expected length of 8 characters");
        }
        // Add any additional validation rules for password if needed
        return true;
    }

    public boolean validateGender(String gender) throws ValidationException {
        if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
            throw new ValidationException("Invalid gender. Gender must be 'M' or 'F'.");
        }
        // Add any additional validation rules for gender if needed
        return true;
    }
    
    public static boolean validateEmail(String email) throws ValidationException {
        final String emailRegEx = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (email == null || email.isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }
        if (!Pattern.compile(emailRegEx).matcher(email).matches()) {
            throw new ValidationException("Invalid email format");
        }
        // Add any additional validation rules for email if needed
        return true;
    }

    public boolean validateProfilePic(String profilePic) throws ValidationException {
        if (profilePic == null || profilePic.isEmpty()) {
            throw new ValidationException("Profile pic URL cannot be empty");
        }
        // Add any additional validation rules for profile pic URL if needed
        return true;
    }

    public boolean validateName(String name) throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name cannot be empty");
        }
        // Add any additional validation rules for name if needed
        return true;
    }

    public boolean validateDateOfBirth(LocalDate validDateOfBirth) throws ValidationException {
        if (validDateOfBirth == null) {
            throw new ValidationException("Date of birth cannot be empty");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate minimumValidDob = currentDate.minusYears(10);
        if (validDateOfBirth.isAfter(currentDate) || validDateOfBirth.isAfter(minimumValidDob)) {
            throw new ValidationException("Invalid date of birth. Must be at least 10 years old.");
        }
        // Add any additional validation rules for date of birth if needed
        return true;
    }

    
    public boolean validateAddress(String address) throws ValidationException {
        if (address == null || address.isEmpty()) {
            throw new ValidationException("Address cannot be empty");
        }
        // Add any additional validation rules for address if needed
        return true;
    }

    public boolean validateAboutMe(String aboutMe) throws ValidationException {
        if (aboutMe == null || aboutMe.isEmpty()) {
            throw new ValidationException("About me cannot be empty");
        }
        // Add any additional validation rules for about me if needed
        return true;
    }

    public boolean validateMyTodos(String myTodos) throws ValidationException {
        // Implement validation logic for myTodos JSON here
        // You might want to parse the JSON and check its structure
        // Throw ValidationException if the JSON is invalid
        // Return true if the JSON is valid
        return true;
    }

    public boolean validateUserId(long userId) throws ValidationException {
        if (userId <= 0) {
            throw new ValidationException("Invalid user ID");
        }
        // Add any additional validation rules for user ID if needed
        return true;
    }

	public BooleanSupplier validateId(int validId) {
		// TODO Auto-generated method stub
		return null;
	}

}



