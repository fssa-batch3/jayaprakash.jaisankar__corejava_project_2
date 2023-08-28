package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Milestone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMilestoneService {

    private MilestoneService milestoneService;
    private FakeMilestoneDAO milestoneDAO;

    @BeforeEach
    void setUp() {
        milestoneDAO = new FakeMilestoneDAO();
        milestoneService = new MilestoneService(milestoneDAO);
    }

    @Test
    void testInsertMilestone() {
        Milestone milestone = new Milestone();
        milestone.settasks_id(1); 
        milestone.setTaskText("Sample Task");
        milestone.setTaskDate(LocalDate.of(2023, 8, 25));
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
    void testUpdateMilestone() {
        Milestone milestone = new Milestone();
        milestone.settasks_id(1);
        milestone.setTaskText("Updated Task");
        milestone.setTaskDate(LocalDate.of(2023, 8, 25));
        milestone.setTaskTime(LocalTime.of(10, 30));
        milestone.setRemainder(true);

        try {
            assertTrue(milestoneService.updateMilestone(milestone));
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }

    @Test
    void testGetMilestoneById() throws ServiceException {
        int milestoneId = 1;

        Milestone fetchedMilestone = milestoneService.getMilestoneById(milestoneId);
        
        assertNull(fetchedMilestone);
//        assertNotEquals(milestoneId, fetchedMilestone.gettasks_id());
    }

    @Test
    void testGetAllMilestones() {
        try {
            List<Milestone> fetchedMilestones = milestoneService.getAllMilestones();
            assertNotNull(fetchedMilestones);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail("Should not throw ServiceException or DAOException");
        }
    }

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

        @Override
        public boolean insertMilestone(Milestone milestone) {
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
                    .filter(m -> Integer.parseInt(m.gettasks_id()) == milestoneId)
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public List<Milestone> getAllMilestones() {
            return milestones;
        }

        @Override
        public boolean deleteMilestoneByTodoId(int milestoneId) {
            milestones.removeIf(m -> Integer.parseInt(m.gettasks_id()) == milestoneId);
            return true;
        }
    }
}
