package com.fssa.projectprovision.validation;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Register;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class RegistrationValidator {

    public void validateAll(Register user) throws ValidationException {
        validateName(user.getName());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
        validateDateOfBirth(user.getDateOfBirth());
        validateGender(user.getGender());
        validateMobileNumber(user.getMobileNumber());
        validateAboutMe(user.getAboutMe());
        validateAddress(user.getAddress());
        validateProfilePic(user.getProfilePic());
    }

    private void validateName(String name) throws ValidationException {
        if (name == null || !Pattern.matches("^[A-Za-z\\s]+$", name)) {
            throw new ValidationException("Invalid Name");
        }
    }

    private void validateEmail(String email) throws ValidationException {
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            throw new ValidationException("Invalid Email");
        }
    }

    private void validatePassword(String password) throws ValidationException {
        if (password == null || !Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", password)) {
            throw new ValidationException("Invalid Password");
        }
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) throws ValidationException {
        if (dateOfBirth == null) {
            throw new ValidationException("Invalid Date of Birth");
        }
        // You can add more specific validation for date of birth if needed.
    }

    private void validateGender(String gender) throws ValidationException {
        if (gender == null || !Pattern.matches("^(Male|Female|Other)$", gender)) {
            throw new ValidationException("Invalid Gender");
        }
    }

    private void validateMobileNumber(String mobileNumber) throws ValidationException {
        if (mobileNumber == null || !Pattern.matches("^(\\+\\d{10,})?$", mobileNumber)) {
            throw new ValidationException("Invalid Mobile Number");
        }
    }

    private void validateAboutMe(String aboutMe) throws ValidationException {
        if (aboutMe == null || !Pattern.matches("^[A-Za-z0-9\\s,.!?]*$", aboutMe)) {
            throw new ValidationException("Invalid About Me");
        }
    }

    private void validateAddress(String address) throws ValidationException {
        if (address == null || !Pattern.matches("^[A-Za-z0-9\\s,.!?]*$", address)) {
            throw new ValidationException("Invalid Address");
        }
    }

    private void validateProfilePic(String profilePic) throws ValidationException {
        if (profilePic == null || !Pattern.matches("^[A-Za-z0-9\\s,.!?]*$", profilePic)) {
            throw new ValidationException("Invalid Profile Pic");
        }
    }
}
