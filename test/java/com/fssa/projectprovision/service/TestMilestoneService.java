package com.fssa.projectprovision.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.*;


import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Milestone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(OrderAnnotation.class)
public class TestMilestoneService {

    private MilestoneService milestoneService;
    private FakeMilestoneDAO milestoneDAO;

    @BeforeEach
    void setUp() {
        milestoneDAO = new FakeMilestoneDAO();
        milestoneService = new MilestoneService(milestoneDAO);
    }
    
    @Order(1)
    @Test
    void testInsertMilestone() {
        Milestone milestone = new Milestone();
        milestone.setTasks_id(1);
        milestone.setTaskText("Sample Task");
        milestone.setTaskDate(LocalDate.of(2023, 8, 25));
        milestone.setTaskTime(LocalTime.of(10, 30));
        milestone.setIsRemainder(true);

       assertTrue(milestoneService.insertMilestone(milestone, 82, "jayaprakashj0@gmail.com"));
    }
    @Order(2)
    @Test
    void testUpdateMilestone() {
        Milestone milestone = new Milestone();
        milestone.setTasks_id(1);
        milestone.setTaskText("Updated Task");
        milestone.setTaskDate(LocalDate.of(2023, 8, 25));
        milestone.setTaskTime(LocalTime.of(10, 30));
        milestone.setIsRemainder(true);

        try {
            assertTrue(milestoneService.updateMilestone(milestone));
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }
    @Order(3)
    @Test
    void testGetMilestoneById() throws ServiceException {
        int milestoneId = 1;

        Milestone fetchedMilestone = milestoneService.getMilestoneById(milestoneId);

        assertNull(fetchedMilestone);
        // assertNotEquals(milestoneId, fetchedMilestone.gettasks_id());
    }
    @Order(4)
    @Test
    void testDeleteMilestone() {
        int milestoneId = 1;

        try {
            assertTrue(milestoneService.deleteMilestoneByTodoId(milestoneId));
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }

    private class FakeMilestoneDAO extends MilestoneDAO {
        private List<Milestone> milestones = new ArrayList<>();

        public boolean insertMilestone(Milestone milestone, long userId, String taskAssignee) {
            milestones.add(milestone);
            return true;
        }

        @Override
        public boolean updateMilestone(Milestone milestone) {
            return true;
        }

        @Override
        public Milestone getMilestoneById(int milestoneId) {
            return milestones.stream()
                    .filter(m -> m.getTasks_id() == milestoneId)
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public List<Milestone> getAllMilestones() {
            return milestones;
        }

        @Override
        public boolean deleteMilestoneByTodoId(int milestoneId) {
            milestones.removeIf(m -> m.getTasks_id() == milestoneId);
            return true;
        }
    }
}
