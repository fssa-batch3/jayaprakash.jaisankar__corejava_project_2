package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Milestone;

import java.util.List;

public class MilestoneService {

    private MilestoneDAO milestoneDAO;

    public MilestoneService(MilestoneDAO milestoneDAO) {
        this.milestoneDAO = milestoneDAO;
    }

    public boolean insertMilestone(Milestone milestone) throws ServiceException {
        return milestoneDAO.insertMilestone(milestone);
    }

    public boolean updateMilestone(Milestone milestone) throws ServiceException, DAOException {
        return milestoneDAO.updateMilestone(milestone);
    }

    public boolean deleteMilestoneByTodoId(int todoId) throws ServiceException, DAOException {
        return milestoneDAO.deleteMilestoneByTodoId(todoId);
    }



    public List<Milestone> getAllMilestones() throws ServiceException, DAOException {
        return milestoneDAO.getAllMilestones();
    }

    // Add more methods as needed

    public void setMilestoneDAO(MilestoneDAO milestoneDAO) {
        this.milestoneDAO = milestoneDAO;
    }


	public Milestone getMilestoneById(int milestoneId) {
		// TODO Auto-generated method stub
		return null;
	}
}
