package com.fssa.projectprovision.validation;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.*;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * 
 * 
 *  * A utility class for validating Milestone objects.
 * This class provides methods to validate various attributes of a Milestone object.
 * 
 *
 * Usage:
 * Milestone milestone = ...; // Get a Milestone object to validate
 * MilestoneValidator validator = new MilestoneValidator(milestone);
 * boolean isValid = validator.validateTaskText(milestone.getTaskText());
 * // Perform similar validation for other attributes
 * 
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */
public class MilestoneValidator {

    private Milestone milestone;

    
    /**
     * Constructs a MilestoneValidator with the provided Milestone object.
     * 
     * @param milestone The Milestone object to be validated.
     */
    
    
    public MilestoneValidator(Milestone milestone) {
        this.milestone = milestone;
    }

    
    /**
     * Default constructor.
     */
    
    public MilestoneValidator() {

    }

    
    /**
     * Validates the task text of a Milestone.
     * 
     * @param taskText The task text to validate.
     * @return True if the task text is valid.
     * @throws ValidationException If the task text is empty or null.
     */
    
    public boolean validateTaskText(String taskText) throws ValidationException {
        if (taskText == null || taskText.trim().isEmpty()) {
            throw new ValidationException("Task text cannot be empty");
        }
        return true;
    }

    
    /**
     * Validates the task date of a Milestone.
     * 
     * @param taskDate The task date to validate.
     * @return True if the task date is valid.
     * @throws ValidationException If the task date is empty or null.
     */
    
    
    public boolean validateTaskDate(LocalDate taskDate) throws ValidationException {
        if (taskDate == null) {
            throw new ValidationException("Task date cannot be empty");
        }
        
        return true;
    }
    
    /**
     * Validates the task time of a Milestone.
     * 
     * @param taskTime The task time to validate.
     * @return True if the task time is valid.
     * @throws ValidationException If the task time is empty or null.
     */
    

    public boolean validateTaskTime(LocalTime taskTime) throws ValidationException {
        if (taskTime == null) {
            throw new ValidationException("Task time cannot be empty");
        }
        
        return true;
    }
    
    /**
     * Validates the "is remainder" attribute of a Milestone.
     * 
     * @param isRemainder The "is remainder" attribute to validate.
     * @return True if the attribute is valid.
     * @throws ValidationException If there's an issue with validation.
     */
    

    public boolean validateIsRemainder(boolean isRemainder) throws ValidationException {
        
        return true;
    }

    /**
     * Sets the Milestone object for validation.
     * 
     * @param milestone The Milestone object to be set.
     */
  

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }
}
