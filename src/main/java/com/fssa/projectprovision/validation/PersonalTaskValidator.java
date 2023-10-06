package com.fssa.projectprovision.validation;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.PersonalTask;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

public class PersonalTaskValidator {

    private static final String VALID_TASK_NAME_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String VALID_DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
    private static final String VALID_TIME_PATTERN = "\\d{2}:\\d{2}";

    /**
     * Validates a PersonalTask object.
     *
     * @param task The PersonalTask object to validate.
     * @throws ValidationException If any validation checks fail.
     */
    public static void validatePersonalTask(PersonalTask task) throws ValidationException {
        validateTaskName(task.getTaskName());
        validateRemainder(task.isRemainder());
        validateTaskDate(task.getTaskDate());
        validateTaskTime(task.getTaskTime());
    }

    /**
     * Validates the task name.
     *
     * @param taskName The task name to validate.
     * @throws ValidationException If the task name is empty or has invalid format.
     */
    private static void validateTaskName(String taskName) throws ValidationException {
        if (taskName == null || taskName.trim().isEmpty()) {
            throw new ValidationException("Task name cannot be empty");
        }
        if (!Pattern.matches(VALID_TASK_NAME_PATTERN, taskName)) {
            throw new ValidationException("Invalid task name format");
        }
    }

    /**
     * Validates the remainder.
     *
     * @param remainder The remainder flag to validate.
     * @throws ValidationException If the remainder is null.
     */
    private static void validateRemainder(Boolean remainder) throws ValidationException {
        if (remainder == null) {
            throw new ValidationException("Remainder cannot be null");
        }
    }

    /**
     * Validates the task date.
     *
     * @param taskDate The task date to validate.
     * @throws ValidationException If the task date is null or has an invalid format.
     */
    private static void validateTaskDate(LocalDate taskDate) throws ValidationException {
        if (taskDate == null || taskDate.isBefore(LocalDate.now())) {
            throw new ValidationException("Task date must be in the future");
        }
    }


    /**
     * Validates the task time.
     *
     * @param taskTime The task time to validate.
     * @throws ValidationException If the task time is null or has an invalid format.
     */
    private static void validateTaskTime(LocalTime taskTime) throws ValidationException {
        if (taskTime == null) {
            throw new ValidationException("Task time cannot be null");
        }
    }

}
