package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.TaskDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.validation.TaskValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class TestTaskService {

    private TaskService taskService;
    private TaskDAO taskDAO;

    @BeforeEach
    public void setUp() {
        taskDAO = new TaskDAO();
        taskService = new TaskService(taskDAO);
    }

    @Test
    @Order(1)
    void testValidCreateTask() {
        Task task = new Task();
        task.setTaskName("Sample Task");
        task.setTaskDue(Date.valueOf(LocalDate.now().plusDays(1)));
        task.setTaskDetails("Sample Task Details");
        // Set other properties...
        
        try {
            boolean result = taskService.createTask(task) != null;
            assertTrue(result);
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(2)
    void testInvalidCreateTask() {
        Task task = new Task();
        task.setTaskName(""); // Set an invalid task name
        task.setTaskDue(Date.valueOf(LocalDate.now().minusDays(1))); // Set an invalid due date
        task.setTaskDetails("Sample Task Details");
        // Set other properties...
        
        assertThrows(ServiceException.class, () -> taskService.createTask(task));
    }

    @Test
    @Order(3)
    void testGetAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();
            assertNotNull(tasks);
            assertFalse(tasks.isEmpty());
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(4)
    void testValidUpdateTask() {
        Task taskToUpdate = new Task();
        taskToUpdate.setId(1); // Set a valid task ID
        taskToUpdate.setTaskName("Updated Task Name");
        taskToUpdate.setTaskDetails("Updated Task Details");
        // Set other properties...
        
        try {
            boolean result = taskService.updateTask(taskToUpdate) != null;
            assertTrue(result);
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(5)
    void testInvalidUpdateTask() {
        Task invalidTask = new Task();
        invalidTask.setId(-1); // Set an invalid task ID
        invalidTask.setTaskName("Updated Task Name");
        invalidTask.setTaskDetails("Updated Task Details");
        // Set other invalid properties...

        assertThrows(ServiceException.class, () -> taskService.updateTask(invalidTask));
    }

    @Test 
    @Order(6)
    void testValidDeleteTask() {
        int taskIdToDelete = 1; // Set a valid task ID

       
            BooleanSupplier result = null;
			assertTrue(result);
       
    }

    @Test
    @Order(7)
    void testInvalidDeleteTask() {
        int invalidTaskId = -1; // Set an invalid task ID

        assertThrows(ServiceException.class, () -> taskService.deleteTask(invalidTaskId));
    }
}
