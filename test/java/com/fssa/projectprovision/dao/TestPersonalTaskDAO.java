package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.dao.PersonalTaskDAO;

import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.model.PersonalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonalTaskDAO {

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void testCreatePersonalTask() throws DAOException {
        PersonalTaskDAO personalTaskDAO = new PersonalTaskDAO();
        PersonalTask task = new PersonalTask(1, 1L, "Test Task", true, LocalDate.now(), LocalTime.now());

        assertTrue(personalTaskDAO.createPersonalTask(task));
    }

    @Test
    void testGetAllPersonalTasks() throws DAOException {
        PersonalTaskDAO personalTaskDAO = new PersonalTaskDAO();
        List<PersonalTask> allPersonalTasks = personalTaskDAO.getAllPersonalTasks();
        assertTrue(allPersonalTasks.size() > 0);
    }

    @Test
    void testGetPersonalTaskById() throws DAOException {
        PersonalTaskDAO personalTaskDAO = new PersonalTaskDAO();
        PersonalTask task = personalTaskDAO.getPersonalTaskById(8);
        assertNotNull(task);
    }

    @Test
    void testUpdatePersonalTask() throws DAOException {
        PersonalTaskDAO personalTaskDAO = new PersonalTaskDAO();
        PersonalTask task = personalTaskDAO.getPersonalTaskById(1695029147846L);
        assertNotNull(task);
        task.setTaskName("Updated Task Name");
        task.setUserId(1695029147846L);
        task.setRemainder(true);
        task.setTaskDate(LocalDate.now());
        task.setTaskTime(LocalTime.now());
        assertTrue(personalTaskDAO.updatePersonalTask(task));

        PersonalTask updatedTask = personalTaskDAO.getPersonalTaskById(8);
        assertNotNull(updatedTask);
        assertEquals("Updated Task Name", updatedTask.getTaskName());
    }

    @Test
    void testDeletePersonalTask() throws DAOException {
        PersonalTaskDAO personalTaskDAO = new PersonalTaskDAO();
        boolean result = personalTaskDAO.deletePersonalTask(3);
        assertTrue(result);

        PersonalTask task = personalTaskDAO.getPersonalTaskById(8);
        assertNull(task);
    }

    @Test
    void testGetPersonalTasksByUserId() throws DAOException {
        PersonalTaskDAO personalTaskDAO = new PersonalTaskDAO();
        List<PersonalTask> tasks = personalTaskDAO.getPersonalTasksByUserId(1695029147846L);
        assertTrue(tasks.size() > 0);
    }
}
