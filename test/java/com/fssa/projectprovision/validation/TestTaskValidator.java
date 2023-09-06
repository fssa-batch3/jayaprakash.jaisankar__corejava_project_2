package com.fssa.projectprovision.validation;





import static org.junit.jupiter.api.Assertions.*;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Task;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class TestTaskValidator {

    @Test
    public void testValidTask() {
        Task validTask = new Task(1, "Valid Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        
       // assertDoesNotThrow(() -> TaskValidator.validateTask(validTask));
    } 

    @Test
    public void testInvalidTaskName() {
        Task invalidTaskName = new Task(2, "", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskName));
    }
    
    @Test
    public void testInvalidTaskNameNull() {
        Task invalidTaskNameNull = new Task(21, null, "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskNameNull));
    }

    @Test
    public void testInvalidTaskNameSpecialCharacters() {
        Task invalidTaskNameSpecialChars = new Task(22, "Task$@", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskNameSpecialChars));
    }

    @Test
    public void testInvalidTaskNameNumbers() {
        Task invalidTaskNameNumbers = new Task(23, "Task123", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskNameNumbers));
    }


    @Test
    public void testInvalidTaskDue() {
        Task invalidTaskDue = new Task(3, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().minusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskDue));
    }

    @Test
    public void testInvalidTaskDetails() {
        Task invalidTaskDetails = new Task(4, "Task", "", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskDetails));
    }
    
    @Test
    public void testInvalidTaskDetailsSpecialCharacters() {
        Task invalidTaskDetailsSpecialChars = new Task(5, "Task", "Task$@", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskDetailsSpecialChars));
    }

    @Test
    public void testInvalidTaskDetailsNumbers() {
        Task invalidTaskDetailsNumbers = new Task(6, "Task", "Task123", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskDetailsNumbers));
    }

    @Test
    public void testInvalidTaskCategory() {
        Task invalidTaskCategory = new Task(5, "Task", "Task details", "",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskCategory));
    }

    @Test
    public void testInvalidTaskAssignee() {
        Task invalidTaskAssignee = new Task(6, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskAssignee));
    }

    @Test
    public void testInvalidTaskStatus() {
        Task invalidTaskStatus = new Task(7, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskStatus));
    }

    @Test
    public void testInvalidProjectName() {
        Task invalidProjectName = new Task(8, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidProjectName));
    }

    @Test
    public void testInvalidTaskPriority() {
        Task invalidTaskPriority = new Task(9, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskPriority));
    }

    @Test
    public void testInvalidTaskTags() {
        Task invalidTaskTags = new Task(10, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "", "0123456789abcdef0123456789abcdef");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskTags));
    }

    @Test
    public void testInvalidTodoId() {
        Task invalidTodoId = new Task(11, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "invalidTodoId");

        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTodoId));
    }


    @Test
    public void testInvalidTaskCategorySpecialCharacters() {
        Task invalidTaskCategorySpecialChars = new Task(9, "Task", "Task details", "Category@!",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskCategorySpecialChars));
    }

    @Test
    public void testInvalidTaskCategoryNumbers() {
        Task invalidTaskCategoryNumbers = new Task(10, "Task", "Task details", "Category123",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskCategoryNumbers));
    }

    @Test
    public void testInvalidTaskAssigneeNull() {
        Task invalidTaskAssigneeNull = new Task(11, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), null, "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskAssigneeNull));
    }

    @Test
    public void testInvalidTaskAssigneeSpecialCharacters() {
        Task invalidTaskAssigneeSpecialChars = new Task(12, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee@!", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskAssigneeSpecialChars));
    }

    @Test
    public void testInvalidTaskAssigneeNumbers() {
        Task invalidTaskAssigneeNumbers = new Task(13, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee123", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskAssigneeNumbers));
    }

    @Test
    public void testInvalidTaskStatusNull() {
        Task invalidTaskStatusNull = new Task(14, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", null,
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskStatusNull));
    }

    @Test
    public void testInvalidTaskStatusSpecialCharacters() {
        Task invalidTaskStatusSpecialChars = new Task(15, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status@!",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskStatusSpecialChars));
    }

    @Test
    public void testInvalidTaskStatusNumbers() {
        Task invalidTaskStatusNumbers = new Task(16, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status123",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskStatusNumbers));
    }

    @Test
    public void testInvalidProjectNameNull() {
        Task invalidProjectNameNull = new Task(17, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                null, "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidProjectNameNull));
    }

    @Test
    public void testInvalidProjectNameSpecialCharacters() {
        Task invalidProjectNameSpecialChars = new Task(18, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project@!", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidProjectNameSpecialChars));
    }

    @Test
    public void testInvalidProjectNameNumbers() {
        Task invalidProjectNameNumbers = new Task(19, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project123", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidProjectNameNumbers));
    }

    @Test
    public void testInvalidTaskPriorityNull() {
        Task invalidTaskPriorityNull = new Task(20, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", null, "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskPriorityNull));
    }

    @Test
    public void testInvalidTaskPrioritySpecialCharacters() {
        Task invalidTaskPrioritySpecialChars = new Task(21, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority@!", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskPrioritySpecialChars));
    }

    @Test
    public void testInvalidTaskPriorityNumbers() {
        Task invalidTaskPriorityNumbers = new Task(22, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority123", "Tag1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskPriorityNumbers));
    }
    
    
    @Test
    public void testInvalidTaskTagsNull() {
        Task invalidTaskTagsNull = new Task(34, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", null, "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskTagsNull));
    }

    @Test
    public void testInvalidTaskTagsSpecialCharacters() {
        Task invalidTaskTagsSpecialChars = new Task(35, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag@1, Tag2", "0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTaskTagsSpecialChars));
    }

    @Test
    public void testInvalidTodoIdNull() {
        Task invalidTodoIdNull = new Task(36, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", null);
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTodoIdNull));
    }

    @Test
    public void testInvalidTodoIdSpecialCharacters() {
        Task invalidTodoIdSpecialChars = new Task(37, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "todo@1");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTodoIdSpecialChars));
    }

    @Test
    public void testInvalidTodoIdTooShort() {
        Task invalidTodoIdTooShort = new Task(38, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "123");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTodoIdTooShort));
    }

    @Test
    public void testInvalidTodoIdTooLong() {
        Task invalidTodoIdTooLong = new Task(39, "Task", "Task details", "Category",
                Date.valueOf(LocalDate.now().plusDays(1)), "Assignee", "Status",
                "Project", "Priority", "Tag1, Tag2", "0123456789abcdef0123456789abcdef0123456789abcdef");
        assertThrows(ValidationException.class, () -> TaskValidator.validateTask(invalidTodoIdTooLong));
    }

}
