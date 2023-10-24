package com.fssa.projectprovision.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.model.Milestone;

public class TestMilestoneDAO {

    @Test
    public void testGetProjectTasksWithMilestones() {
        MilestoneDAO milestoneDAO = new MilestoneDAO();
        List<Milestone> projectTasks = milestoneDAO.getProjectTasksWithMilestones();
        assertNotNull(projectTasks);
        assertFalse(projectTasks.isEmpty());
    }

    @Test
    public void testGetProjectTasksWithMilestonesByTaskId() {
        MilestoneDAO milestoneDAO = new MilestoneDAO();
        int taskId = 4; 
        List<Milestone> projectTasks = milestoneDAO.getProjectTasksWithMilestones(taskId);
        assertNotNull(projectTasks);
        assertFalse(projectTasks.isEmpty());
    }

    @Test
    public void testGetMilestoneById() {
        MilestoneDAO milestoneDAO = new MilestoneDAO();
        int milestoneId = 4; 
        Milestone milestone = milestoneDAO.getMilestoneById(milestoneId);
        assertNotNull(milestone);
        assertEquals(milestoneId, milestone.getId());
    }

    @Test
    public void testInsertMilestone() {
        MilestoneDAO milestoneDAO = new MilestoneDAO();
        Milestone milestone = new Milestone();
        milestone.setTaskText("Test Milestone");
       
        long userId = 4; 
        String taskAssignee = "Test Assignee";
        boolean result = milestoneDAO.insertMilestone(milestone, userId, taskAssignee);
        assertTrue(result);
    }


}
