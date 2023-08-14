package com.fssa.projectprovision.validation;


import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Task;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class TaskValidator {

    private static final String VALID_TASK_NAME_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String VALID_PROJECT_NAME_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String VALID_CATEGORY_PATTERN = "^[a-zA-Z\\s]+$"; 
    private static final String VALID_TASK_STATUS_PATTERN = "^[a-zA-Z\\s]+$";
    private static final String VALID_PRIORITY_PATTERN = "^[a-zA-Z\\s]+$"; 
    private static final String VALID_TAGS_PATTERN = "^[a-zA-Z0-9,\\s]+$"; 
    private static final String VALID_TODO_ID_PATTERN = "^[a-fA-F0-9]{32}$"; 

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

    private static void validateTaskName(String taskName) throws ValidationException {
        if (taskName == null || taskName.trim().isEmpty()) {
            throw new ValidationException("Task name cannot be empty");
        }
        if (!Pattern.matches(VALID_TASK_NAME_PATTERN, taskName)) {
            throw new ValidationException("Invalid task name format");
        }
    }

    private static void validateTaskDue(Date taskDue) throws ValidationException {
        if (taskDue == null || taskDue.toLocalDate().isBefore(LocalDate.now())) {
            throw new ValidationException("Task due date must be in the future");
        }
        // Add more validation checks for task due date
    }

    private static void validateTaskDetails(String taskDetails) throws ValidationException {
        if (taskDetails == null || taskDetails.trim().isEmpty()) {
            throw new ValidationException("Task details cannot be empty");
        }
        // Add more validation checks for task details
    }

    private static void validateTaskCategory(String taskCategory) throws ValidationException {
        if (taskCategory == null || taskCategory.trim().isEmpty()) {
            throw new ValidationException("Task category cannot be empty");
        }
        if (!Pattern.matches(VALID_CATEGORY_PATTERN, taskCategory)) {
            throw new ValidationException("Invalid task category format");
        }
    }

    private static void validateTaskAssignee(String taskAssignee) throws ValidationException {
        if (taskAssignee == null || taskAssignee.trim().isEmpty()) {
            throw new ValidationException("Task assignee cannot be empty");
        }
        // Add more validation checks for task assignee
    }

    private static void validateTaskStatus(String taskStatus) throws ValidationException {
        if (taskStatus == null || taskStatus.trim().isEmpty()) {
            throw new ValidationException("Task status cannot be empty");
        }
        if (!Pattern.matches(VALID_TASK_STATUS_PATTERN, taskStatus)) {
            throw new ValidationException("Invalid task status format");
        }
    }

    private static void validateProjectName(String projectName) throws ValidationException {
        if (projectName == null || projectName.trim().isEmpty()) {
            throw new ValidationException("Project name cannot be empty");
        }
        if (!Pattern.matches(VALID_PROJECT_NAME_PATTERN, projectName)) {
            throw new ValidationException("Invalid project name format");
        }
    }

    private static void validateTaskPriority(String taskPriority) throws ValidationException {
        if (taskPriority == null || taskPriority.trim().isEmpty()) {
            throw new ValidationException("Task priority cannot be empty");
        }
        if (!Pattern.matches(VALID_PRIORITY_PATTERN, taskPriority)) {
            throw new ValidationException("Invalid task priority format");
        }
    }

    private static void validateTaskTags(String taskTags) throws ValidationException {
        if (taskTags == null || taskTags.trim().isEmpty()) {
            throw new ValidationException("Task tags cannot be empty");
        }
        if (!Pattern.matches(VALID_TAGS_PATTERN, taskTags)) {
            throw new ValidationException("Invalid task tags format");
        }
    }

    private static void validateTodoId(String todoId) throws ValidationException {
        if (todoId == null || todoId.trim().isEmpty()) {
            throw new ValidationException("Todo ID cannot be empty");
        }
        if (!Pattern.matches(VALID_TODO_ID_PATTERN, todoId)) {
            throw new ValidationException("Invalid todo ID format");
        }
    }

   
}

