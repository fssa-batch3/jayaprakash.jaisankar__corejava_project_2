package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.MilestoneDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.Milestone;

import java.util.List;

/**
 * A service class that provides methods for managing milestones in the system.
 * This class interacts with the MilestoneDAO to perform CRUD operations on milestones.
 * 
 * @author JayaprakashJaisankar
 *
 */
public class MilestoneService {

    private MilestoneDAO milestoneDAO;

    /**
     * Constructs a MilestoneService with the provided MilestoneDAO.
     * 
     * @param milestoneDAO The data access object for milestones.
     */
    public MilestoneService(MilestoneDAO milestoneDAO) {
        this.milestoneDAO = milestoneDAO;
    }

    
    /**
     * Inserts a new milestone into the system.
     * 
     * @param milestone The milestone to be inserted.
     * @return True if the insertion is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public boolean insertMilestone(Milestone milestone) throws ServiceException {
        return milestoneDAO.insertMilestone(milestone);
    }

    
    /**
     * Updates an existing milestone in the system.
     * 
     * @param milestone The milestone to be updated.
     * @return True if the update is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     * @throws DAOException If there's an issue with the data access operation.
     */
    
    
    public boolean updateMilestone(Milestone milestone) throws ServiceException, DAOException {
        return milestoneDAO.updateMilestone(milestone);
    }

    
    /**
     * Deletes milestones associated with a specific todo by its ID.
     * 
     * @param todoId The ID of the todo whose associated milestones will be deleted.
     * @return True if the deletion is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     * @throws DAOException If there's an issue with the data access operation.
     */
    public boolean deleteMilestoneByTodoId(int todoId) throws ServiceException, DAOException {
        return milestoneDAO.deleteMilestoneByTodoId(todoId);
    }
 

    
    /**
     * Retrieves a list of all milestones in the system.
     * 
     * @return A list of all milestones in the system.
     * @throws ServiceException If there's an issue with the service operation.
     * @throws DAOException If there's an issue with the data access operation.
     */

    public List<Milestone> getAllMilestones() throws ServiceException, DAOException {
        return milestoneDAO.getAllMilestones();
    }

    /**
     * Sets the MilestoneDAO for the service.
     * 
     * @param milestoneDAO The MilestoneDAO to be set.
     */

    public void setMilestoneDAO(MilestoneDAO milestoneDAO) {
        this.milestoneDAO = milestoneDAO;
    }


    /**
     * Retrieves a milestone by its ID.
     * 
     * @param milestoneId The ID of the milestone to retrieve.
     * @return The retrieved milestone, or null if not found.
     */

	public Milestone getMilestoneById(int milestoneId) {

		return null;
	}
}
