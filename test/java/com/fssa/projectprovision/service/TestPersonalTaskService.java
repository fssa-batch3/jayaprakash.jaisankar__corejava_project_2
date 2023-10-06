package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.PersonalTaskDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.PersonalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonalTaskService {

    private PersonalTaskService personalTaskService;
    private PersonalTaskDAO personalTaskDAO;

    @BeforeEach
    void setUp() {
        personalTaskDAO = new PersonalTaskDAO(); 
        personalTaskService = new PersonalTaskService(personalTaskDAO);
    }

    @Test
    void testCreatePersonalTask_Success() throws DAOException, ServiceException {
        PersonalTask task = new PersonalTask();
        boolean result = personalTaskService.createPersonalTask(task);
        assertTrue(result, "Personal task creation should succeed");
    }

    @Test
    void testCreatePersonalTask_Failure() throws DAOException {
        PersonalTask task = new PersonalTask();
        PersonalTaskDAOMock.setCreatePersonalTaskReturnValue(false); // Set the desired return value for the mock
        assertThrows(ServiceException.class, () -> personalTaskService.createPersonalTask(task));
    }

    @Test
    void testGetAllPersonalTasks() throws DAOException, ServiceException {
        List<PersonalTask> taskList = new ArrayList<>();
        PersonalTaskDAOMock.setGetAllPersonalTasksReturnValue(taskList); // Set the desired return value for the mock
        List<PersonalTask> result = personalTaskService.getAllPersonalTasks();
        assertNotNull(result);
        assertEquals(taskList, result);
    }

    @Test
    void testGetPersonalTaskById() throws DAOException, ServiceException {
        long userId = 1L;
        PersonalTask task = new PersonalTask();
        when(personalTaskDAO.getPersonalTaskById(userId)).thenReturn(task); 
        PersonalTask result = personalTaskService.getPersonalTaskById(userId);
        assertNotNull(result);
        assertEquals(task, result);
    }

    @Test
    void testUpdatePersonalTask() throws DAOException, ServiceException {
        PersonalTask task = new PersonalTask();
        boolean result = personalTaskService.updatePersonalTask(task);
        assertTrue(result, "Personal task update should succeed");
    }

    @Test
    void testDeletePersonalTask() throws DAOException, ServiceException {
        int taskId = 1;
        boolean result = personalTaskService.deletePersonalTask(taskId);
        assertTrue(result, "Personal task deletion should succeed");
    }
}

class PersonalTaskDAO implements PersonalTaskDAO {
    private static boolean createPersonalTaskReturnValue = true;
    private static List<PersonalTask> getAllPersonalTasksReturnValue = new ArrayList<>();

    public boolean createPersonalTask(PersonalTask task) throws DAOException {
        return createPersonalTaskReturnValue;
    }

    public List<PersonalTask> getAllPersonalTasks() throws DAOException {
        return getAllPersonalTasksReturnValue;
    }

    public PersonalTask getPersonalTaskById(long userId) throws DAOException {
        return null; 
    }

    public boolean updatePersonalTask(PersonalTask task) throws DAOException {
        return true; 
    }

    public boolean deletePersonalTask(int taskId) throws DAOException {
        return true; 
    }

    public static void setCreatePersonalTaskReturnValue(boolean value) {
        createPersonalTaskReturnValue = value;
    }

    public static void setGetAllPersonalTasksReturnValue(List<PersonalTask> value) {
        getAllPersonalTasksReturnValue = value;
    }

}
