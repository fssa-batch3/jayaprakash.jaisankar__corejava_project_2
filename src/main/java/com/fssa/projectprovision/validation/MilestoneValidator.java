package com.fssa.projectprovision.validation;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class MilestoneValidator {

    private Milestone milestone;

    public MilestoneValidator(Milestone milestone) {
        this.milestone = milestone;
    }

    public MilestoneValidator() {

    }

    public boolean validateTaskText(String taskText) throws ValidationException {
        if (taskText == null || taskText.trim().isEmpty()) {
            throw new ValidationException("Task text cannot be empty");
        }
        return true;
    }

    public boolean validateTaskDate(LocalDate taskDate) throws ValidationException {
        if (taskDate == null) {
            throw new ValidationException("Task date cannot be empty");
        }
        
        return true;
    }

    public boolean validateTaskTime(LocalTime taskTime) throws ValidationException {
        if (taskTime == null) {
            throw new ValidationException("Task time cannot be empty");
        }
        
        return true;
    }

    public boolean validateIsRemainder(boolean isRemainder) throws ValidationException {
        
        return true;
    }

 

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }
}
