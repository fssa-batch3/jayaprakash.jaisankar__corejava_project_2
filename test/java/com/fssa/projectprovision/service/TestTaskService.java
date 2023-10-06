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
        TaskDAO taskDAO = new TaskDAO();
        taskService = new TaskService(taskDAO);

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
        task.setTodoId("abcdef0123456789ABCDEF8087658888");
    }

    @Test
    @Order(1)
    void testCreateTask_Success() {
        try {
            boolean result = taskService.createTask(task,1695193559760L);
            assertTrue(result, "Task creation should succeed");
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(2)
    void testCreateTask_Failure() {
        Task invalidTask = new Task();
        invalidTask.setTaskName("Sample Task");
        invalidTask.setTaskDue(LocalDate.now().plusDays(1));
        invalidTask.setTaskDetails("Sample details");
        invalidTask.setTaskCategory("Sample category");
        invalidTask.setTaskAssignee("Sample assignee");
        invalidTask.setTaskStatus(" "); 
        invalidTask.setProjectName("Sample project");
        invalidTask.setTaskPriority("High");
        invalidTask.setTaskTags("Tag1, Tag2");
        invalidTask.setTodoId("abcgkf4193456789ABCDEF0334356716");

        try {
            boolean result = taskService.createTask(invalidTask, 1695193559760L);
            assertFalse(result);
        } catch (ServiceException e) {
            assertEquals("Failed to create first task", e.getMessage());
        }
    }


    @Test
    @Order(3)
    void testGetTaskById() {
        try {
            Task retrievedTask = taskService.getTaskById(71);
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
        Task updatedTask = new Task();
        updatedTask.setId(71); 
        updatedTask.setTaskName("Updated Task Name");
        updatedTask.setTaskDue(LocalDate.now().plusDays(2));
        updatedTask.setTaskDetails("Updated details");
        updatedTask.setTaskCategory("Updated category");
        updatedTask.setTaskAssignee("Updated assignee");
        updatedTask.setTaskStatus("Updated status");
        updatedTask.setProjectName("Updated project");
        updatedTask.setTaskPriority("Updated priority");
        updatedTask.setTaskTags("Updated Tag1, Updated Tag2");
        updatedTask.setTodoId("abcdef0123456789ABCDEF0987658888");
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
        int taskIdToDelete = 83;

        try {
            String result = taskService.deleteTaskById(taskIdToDelete);
            assertEquals("Task Deleted Successfully", result);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }
}
