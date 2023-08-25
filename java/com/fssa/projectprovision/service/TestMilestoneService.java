package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Milestone;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMilestoneService {

    private MilestoneService milestoneService;
    private MilestoneDAO milestoneDAO; // You need to create this DAO or mock it

    @BeforeEach
    void setUp() {
        milestoneDAO = new MilestoneDAO(); // Instantiate your DAO here or mock it
        milestoneService = new MilestoneService(milestoneDAO); // Pass the MilestoneDAO instance
    }

    @Test
    @Order(1)
    void testInsertMilestone() {
        Milestone milestone = new Milestone();
        milestone.settasks_id(2); // Make sure this todoID exists in projecttask table
        milestone.setTaskText("Sample Task");
        milestone.setTaskDate(LocalDate.parse("2023-08-16"));
        milestone.setTaskTime(LocalTime.of(10, 30));
        milestone.setRemainder(true);

        try {
            assertTrue(milestoneService.insertMilestone(milestone));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(2)
    void testUpdateMilestone() {
        // Similar to testInsertMilestone, set the required fields
        Milestone milestone = new Milestone();
        milestone.settasks_id(1); // Make sure this todoID exists in projecttask table
        milestone.setTaskText("Updated Task");

        try {
            assertTrue(milestoneService.updateMilestone(milestone));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    // Other test methods...

    @Test
    @Order(6)
    void testGetMilestoneById() {
        int milestoneId = 1; // Provide an actual milestone ID
        try {
            Milestone fetchedMilestone = milestoneService.getMilestoneById(milestoneId);
            assertNotNull(fetchedMilestone);
            // You can add more assertions here to validate the fetched milestone
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }
}
