package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.PersonalTaskDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.PersonalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@TestMethodOrder(OrderAnnotation.class)
public class TestPersonalTaskService {

    private PersonalTaskService personalTaskService;
    private PersonalTaskDAO personalTaskDAO;

    @BeforeEach
    void setUp() {
        personalTaskDAO = new PersonalTaskDAO(); 
        personalTaskService = new PersonalTaskService(personalTaskDAO);
    }
    int taskId = 5;
 
    
    @Order(1)
    @Test
    void testCreatePersonalTask() {
        PersonalTask task = new PersonalTask();
        task.setUserId(1695029147846L);
        task.setTaskName("Sample Task");
        task.setRemainder(true);
        task.setTaskDate(LocalDate.of(2023, 8, 25));
        task.setTaskTime(LocalTime.of(10, 30));

        try {
            assertTrue(personalTaskService.createPersonalTask(task));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Order(2)
    @Test
    void testUpdatePersonalTask() {
        PersonalTask task = new PersonalTask();
        task.setTaskId(5);
        task.setUserId(1695029147846L);
        task.setTaskName("Updated Task");
        task.setRemainder(false);
        task.setTaskDate(LocalDate.of(2023, 8, 25));
        task.setTaskTime(LocalTime.of(10, 30));

        try {
            assertTrue(personalTaskService.updatePersonalTask(task));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Order(3)
    @Test
    void testGetPersonalTaskById() {
        long userId = 1695029147846L;

        try {
            List<PersonalTask> fetchedTasks = personalTaskService.getPersonalTasksByUserId(userId);
            assertNotNull(fetchedTasks);            
            if (!fetchedTasks.isEmpty()) {
                PersonalTask fetchedTask = fetchedTasks.get(0); 
                assertEquals(userId, fetchedTask.getUserId());
            } else {
                fail("No tasks found for the given user");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException: " + e.getMessage());
        }
    }


    @Order(4)
    @Test
    void testDeletePersonalTask() {
       
    	 taskId++;

        try {
            assertTrue(personalTaskService.deletePersonalTask(taskId));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }
    
}
