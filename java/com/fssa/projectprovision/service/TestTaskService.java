package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.TaskDAO;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Task;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestTaskService {

    private TaskService taskService;
    private Task task;

    @BeforeEach
    void setUp() {
        TaskDAO taskDAO = new TaskDAO(); // Replace this with the actual instantiation of your TaskDAO
        taskService = new TaskService(taskDAO);

        // Create a sample Task with valid attributes
        task = new Task();
        task.setTaskName("Sample Task");
        task.setTaskDue(LocalDate.now().plusDays(1)); 
        task.setTaskDetails("Sample details");
        task.setTaskCategory("Sample category");
        task.setTaskAssignee("Sample assignee");
        task.setTaskStatus("Pending");
        task.setProjectName("Sample project");
        task.setTaskPriority("High");
        task.setTaskTags("Tag1, Tag2");

        // Set a valid todo ID format matching the regular expression
        task.setTodoId("abcdef0123456789ABCDEF0987654881");
    }

    @Test
    @Order(1)
    void testCreateTask_Success() {
        try {
            // Act: Attempt to create the task
            boolean result = taskService.createTask(task);

            // Assert: Check if the result is as expected
            assertTrue(result, "Task creation should succeed");
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(2)
    void testCreateTask_Failure() {
        Task invalidTask = new Task(); // Renamed to avoid shadowing the 'task' instance
        invalidTask.setTaskName("Sample Task");
        invalidTask.setTaskDue(LocalDate.now().plusDays(1));
        invalidTask.setTaskDetails("Sample details");
        invalidTask.setTaskCategory("Sample category");
        invalidTask.setTaskAssignee("Sample assignee");
        invalidTask.setTaskStatus(" ");
        invalidTask.setProjectName("Sample project");
        invalidTask.setTaskPriority("High");
        invalidTask.setTaskTags("Tag1, Tag2");
        invalidTask.setTodoId("abcgkf0193456789ABCDEF012356716");

        try {
            boolean result = taskService.createTask(invalidTask);
            assertFalse(result);
        } catch (ServiceException e) {
            assertEquals(e.getMessage(),"Failed to create first task");
        }
    }


    @Test
    @Order(3)
    void testGetTaskById() {
        try {
            Task retrievedTask = taskService.getTaskById(1);
            assertNotNull(retrievedTask);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(4)
    void testGetAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();
            assertNotNull(tasks);
            assertFalse(tasks.isEmpty());
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(5)
    void testUpdateTask() {
        // Create a new Task instance with updated attributes
        Task updatedTask = new Task();
        updatedTask.setId(1); // Set the same ID as the task you want to update
        updatedTask.setTaskName("Updated Task Name");
        updatedTask.setTaskDue(LocalDate.now().plusDays(2)); // Updated due date
        updatedTask.setTaskDetails("Updated details");
        updatedTask.setTaskCategory("Updated category");
        updatedTask.setTaskAssignee("Updated assignee");
        updatedTask.setTaskStatus("Updated status");
        updatedTask.setProjectName("Updated project");
        updatedTask.setTaskPriority("Updated priority");
        updatedTask.setTaskTags("Updated Tag1, Updated Tag2");
        updatedTask.setTodoId("abcdef0123456789ABCDEF0123456789"); // Set the same todoId as the task you want to update

        try {
            String result = taskService.updateTask(updatedTask);
            assertEquals("Task Updated Successfully", result);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(6)
    void testDeleteTaskById() {
        int taskIdToDelete = 1;

        try {
            String result = taskService.deleteTaskById(taskIdToDelete);
            assertEquals("Task Deleted Successfully", result);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }
}
