package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Milestone;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMilestoneService {

    private MilestoneService milestoneService;
    private Milestone milestone;

    @BeforeEach
    void setUp() {
        milestoneService = new MilestoneService();
        milestone = new Milestone();
        milestone.setTodoId(1);
        milestone.setTaskText("Sample Task");
        milestone.setTaskDate(Date.valueOf("2023-08-16"));
        milestone.setTaskTime(LocalTime.of(10, 30));
        milestone.setRemainder(true);
    }

    @Order(1)
    @Test
    void testInsertMilestone() {
        try {
            assertTrue(milestoneService.insertMilestone(milestone));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    } 

    @Order(2)
    @Test
    void testUpdateMilestone() {
        milestone.setTaskText("Updated Task");
        try {
            assertTrue(milestoneService.updateMilestone(milestone));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        } catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Order(3)
    @Test
    void testGetProjectTasksWithMilestones() {
        try {
            List<Milestone> milestones = milestoneService.getProjectTasksWithMilestones();
            assertNotNull(milestones);
            assertFalse(milestones.isEmpty());
            // You can add more assertions here to validate the retrieved milestones
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Order(4)
    @Test
    void testDeleteMilestoneByTodoId() {
        try {
            assertTrue(milestoneService.deleteMilestoneByTodoId(milestone.getTodoId()));
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }

    @Test
    @Order(5)
    void testGetAllMilestones() {
        try {
            List<MilestoneService> milestones = milestoneService.getAllMilestones();
            assertNotNull(milestones);
            assertFalse(milestones.isEmpty());
            // You can add more assertions here to validate the retrieved milestones
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        } catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    @Order(6)
    void testGetMilestoneById() {
        int milestoneId = 1; // Provide an actual milestone ID
        try {
            MilestoneDAO fetchedMilestone = milestoneService.getMilestoneById(milestoneId);
            assertNotNull(fetchedMilestone);
            // You can add more assertions here to validate the fetched milestone
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }
}
