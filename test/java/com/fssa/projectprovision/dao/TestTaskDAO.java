package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.dao.TaskDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestTaskDAO {

    @BeforeEach
    void setUp() {
       
    }

    @Test
    void testCreateTask() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        Task task = new Task(3, "Test Task", "Task details", "Category", LocalDate.now(),
                "Assignee", "Not Started", "Project X", "High", "Tag1, Tag2", "TODO-");

        assertTrue(taskDAO.createTask(task, 1L));
    }

    @Test
    void testGetAllTasks() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        List<Task> allTasks = taskDAO.getAllTasks();
        assertTrue(allTasks.size() > 0);
    }

    @Test
    void testGetTaskById() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getTaskById(53);
        assertNotNull(task);
        assertEquals("Updated Task Name", task.getTaskName());
    }

    @Test
    void testGetTaskById_NotFound() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getTaskById(120); 
        assertNull(task);
    }

    @Test
    void testGetTasksByAssigneeEmail() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksByAssigneeEmail("Assignee");
        assertTrue(tasks.size() > 0);
    }

    @Test
    void testUpdateTask() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getTaskById(53);
        assertNotNull(task);

        task.setTaskName("Updated Task Name");
        assertTrue(taskDAO.updateTask(task));

        Task updatedTask = taskDAO.getTaskById(53);
        assertNotNull(updatedTask);
        assertEquals("Updated Task Name", updatedTask.getTaskName());
    }

    @Test
    void testDeleteTask() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        boolean result = taskDAO.deleteTask(51);
        assertTrue(result);

        Task task = taskDAO.getTaskById(1);
        assertNull(task);
    }

    @Test
    void testGetTasksForUser() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksForUser(1L, "Assignee");
        assertTrue(tasks.size() > 0);
    }

    @Test
    void testMarkTaskAsCompleted() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        assertTrue(taskDAO.markTaskAsCompleted(53));

        Task task = taskDAO.getTaskById(53);
        assertNotNull(task);
        assertEquals("Completed", task.getTaskStatus());
    }

    @Test
    void testGetTasksByPriority() throws DAOException {
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksByPriority("High");
        assertTrue(tasks.size() > 0);
    }
}
