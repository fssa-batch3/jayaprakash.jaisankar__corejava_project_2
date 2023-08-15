package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.TaskDAO;
import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Milestone;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.service.*;

import java.util.List;

public class MilestoneService {

    private TaskDAO projectTaskDAO;
    private MilestoneDAO milestoneDAO;
    

    public List<Milestone> getProjectTasksWithMilestones() throws ServiceException {
        return milestoneDAO.getProjectTasksWithMilestones();
    }

    public static boolean insertMilestone(Milestone milestone) throws ServiceException {
        return MilestoneDAO.insertMilestone(milestone);
    }

    public boolean updateMilestone(Milestone milestone) throws ServiceException, DAOException {
        return milestoneDAO.updateMilestone(milestone);
    }

    public boolean deleteMilestoneByTodoId1(int todoId) throws ServiceException, DAOException {
        return milestoneDAO.deleteMilestoneByTodoId(todoId);
    }

    // Add more methods for inserting, updating, deleting milestones
    
    public boolean insertMilestone1(Milestone milestone) throws ServiceException, DAOException {
        return milestoneDAO.insertMilestone(milestone);
    }

    public boolean updateMilestone1(Milestone milestone) throws ServiceException, DAOException {
        return milestoneDAO.updateMilestone(milestone);
    }

    public boolean deleteMilestoneByTodoId(int i) throws ServiceException, DAOException {
        return milestoneDAO.deleteMilestoneByTodoId(i);
    }

    // Method to get a milestone by its ID
    public MilestoneDAO getMilestoneById(int id) throws ServiceException, DAOException {
        return milestoneDAO.getMilestoneById(id);
    }

    // Method to get all milestones
    public List<MilestoneService> getAllMilestones() throws ServiceException, DAOException {
        return milestoneDAO.getAllMilestones();
    }

    // Add more methods as needed

    public void setProjectTaskDAO(TaskDAO projectTaskDAO) {
        this.projectTaskDAO = projectTaskDAO;
    }

    public void setMilestoneDAO(MilestoneDAO milestoneDAO) {
        this.milestoneDAO = milestoneDAO;
    }

}
