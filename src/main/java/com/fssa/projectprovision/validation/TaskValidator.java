package com.fssa.projectprovision.validation;


import com.fssa.projectprovision.exception.ValidationException;

import com.fssa.projectprovision.model.Task;

import java.time.LocalDate;
import java.util.regex.Pattern;


/**
 * 
 * A utility class for validating Task objects.
 * This class provides methods to validate various attributes of a Task object.
 * 
 * Usage:
 * Task task = ...; // Get a Task object to validate
 * TaskValidator.validateTask(task);
 * // Validation checks will be performed for various attributes
 * 
 * @author JayaprakashJaisankar
 *
 */
public class TaskValidator {

    private static final String VALID_TASK_NAME_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String VALID_PROJECT_NAME_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String VALID_CATEGORY_PATTERN = "^[a-zA-Z\\s]+$"; 
    private static final String VALID_TASK_STATUS_PATTERN = "^[a-zA-Z\\s]+$";
    private static final String VALID_PRIORITY_PATTERN = "^[a-zA-Z\\s]+$"; 
    private static final String VALID_TAGS_PATTERN = "^[a-zA-Z0-9,\\s]+$"; 
    private static final String VALID_TODO_ID_PATTERN = "^[a-fA-F0-9]{32}$"; 

    

    /**
     * Validates a Task object.
     * 
     * @param task The Task object to validate.
     * @throws ValidationException If any validation checks fail.
     */
    public static void validateTask(Task task) throws ValidationException {
        validateTaskName(task.getTaskName());
        validateTaskDue(task.getTaskDue());
        validateTaskDetails(task.getTaskDetails());
        validateTaskCategory(task.getTaskCategory());
        validateTaskAssignee(task.getTaskAssignee());
        validateTaskStatus(task.getTaskStatus());
        validateProjectName(task.getProjectName());
        validateTaskPriority(task.getTaskPriority());
        validateTaskTags(task.getTaskTags());
        validateTodoId(task.getTodoId());
        
    }
/**TODO 
 * callALL the  methods where it want 
 * in service call the validator 
 */
     
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
     * Validates the task due date.
     * 
     * @param localDate The task due date to validate.
     * @throws ValidationException If the task due date is in the past.
     */

    private static void validateTaskDue(LocalDate localDate) throws ValidationException {
        if (localDate == null || localDate.isBefore(LocalDate.now())) {
            throw new ValidationException("Task due date must be in the future");
        }
    }
    

    /**
     * Validates the task details.
     * 
     * @param taskDetails The task details to validate.
     * @throws ValidationException If the task details are empty.
     */

    private static void validateTaskDetails(String taskDetails) throws ValidationException {
        if (taskDetails == null || taskDetails.trim().isEmpty()) {
            throw new ValidationException("Task details cannot be empty");
        }
    }

    
    /**
     * Validates the task category.
     * 
     * @param taskCategory The task category to validate.
     * @throws ValidationException If the task category is empty or has invalid format.
     */
    
    private static void validateTaskCategory(String taskCategory) throws ValidationException {
        if (taskCategory == null || taskCategory.trim().isEmpty()) {
            throw new ValidationException("Task category cannot be empty");
        }
        if (!Pattern.matches(VALID_CATEGORY_PATTERN, taskCategory)) {
            throw new ValidationException("Invalid task category format");
        }
    }

    /**
     * Validates the task assignee.
     * 
     * @param taskAssignee The task assignee to validate.
     * @throws ValidationException If the task assignee is empty.
     * @throws ValidationException If additional validation checks for task assignee fail.
     */
    
    private static void validateTaskAssignee(String taskAssignee) throws ValidationException {
        if (taskAssignee == null || taskAssignee.trim().isEmpty()) {
            throw new ValidationException("Task assignee cannot be empty");
        }
      
    }

    
    /**
     * Validates the task status.
     * 
     * @param taskStatus The task status to validate.
     * @throws ValidationException If the task status is empty or has an invalid format.
     */
    
    
    private static void validateTaskStatus(String taskStatus) throws ValidationException {
        if (taskStatus == null || taskStatus.trim().isEmpty()) {
            throw new ValidationException("Task status cannot be empty");
        }
        if (!Pattern.matches(VALID_TASK_STATUS_PATTERN, taskStatus)) {
            throw new ValidationException("Invalid task status format");
        }
    }

    
    /**
     * Validates the project name.
     * 
     * @param projectName The project name to validate.
     * @throws ValidationException If the project name is empty or has an invalid format.
     */
    
    
    private static void validateProjectName(String projectName) throws ValidationException {
        if (projectName == null || projectName.trim().isEmpty()) {
            throw new ValidationException("Project name cannot be empty");
        }
        if (!Pattern.matches(VALID_PROJECT_NAME_PATTERN, projectName)) {
            throw new ValidationException("Invalid project name format");
        }
    }

    
    /**
     * Validates the task priority.
     * 
     * @param taskPriority The task priority to validate.
     * @throws ValidationException If the task priority is empty or has an invalid format.
     */
    
    private static void validateTaskPriority(String taskPriority) throws ValidationException {
        if (taskPriority == null || taskPriority.trim().isEmpty()) {
            throw new ValidationException("Task priority cannot be empty");
        }
        if (!Pattern.matches(VALID_PRIORITY_PATTERN, taskPriority)) {
            throw new ValidationException("Invalid task priority format");
        }
    }
    
    /**
     * Validates the task tags.
     * 
     * @param taskTags The task tags to validate.
     * @throws ValidationException If the task tags are empty or have an invalid format.
     */

    private static void validateTaskTags(String taskTags) throws ValidationException {
        if (taskTags == null || taskTags.trim().isEmpty()) {
            throw new ValidationException("Task tags cannot be empty");
        }
        if (!Pattern.matches(VALID_TAGS_PATTERN, taskTags)) {
            throw new ValidationException("Invalid task tags format");
        }
    } 

     
    /**
     * Validates the  ID.
     * 
     * @param  The  ID to validate.
     * @throws ValidationException If the ID is empty or has invalid format.
     */
    private static void validateTodoId(String todoId) throws ValidationException {
        if (todoId == null || todoId.trim().isEmpty()) {
            throw new ValidationException("Todo ID cannot be empty");
        }
        if (!Pattern.matches(VALID_TODO_ID_PATTERN, todoId)) {
            throw new ValidationException("Invalid todo ID format");
        }
    }

   
}

