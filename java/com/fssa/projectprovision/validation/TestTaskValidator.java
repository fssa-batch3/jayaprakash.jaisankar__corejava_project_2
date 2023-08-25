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


}
