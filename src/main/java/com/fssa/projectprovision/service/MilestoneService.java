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

    
    public List<Milestone> getMilestonesByTaskId(int taskId) throws ServiceException {
        return milestoneDAO.getMilestonesByTaskId(taskId);
    }


    
    /**
     * Inserts a new milestone into the system.
     * 
     * @param milestone The milestone to be inserted.
     * @return True if the insertion is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public boolean insertMilestone(Milestone milestone, long userId, String taskAssignee) {
        return milestoneDAO.insertMilestone(milestone, userId, taskAssignee);
    }
    /**
     * Retrieves a list of Project Tasks with associated Milestones for a specific user and task assignee.
     *
     * @param userId      The ID of the user.
     * @param taskAssignee The task assignee to filter by.
     * @return A list of Milestone objects representing Project Tasks with Milestones.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public List<Milestone> getProjectTasksWithMilestones(long userId) throws ServiceException {
        return milestoneDAO.getProjectTasksWithMilestones(userId);
    }
    
    public List<Milestone> getCreatorIdForMilestone(long userId) throws ServiceException {
        return milestoneDAO.getProjectTasksWithMilestones(userId);
    }
    /**
     * Retrieves the creator ID of a milestone based on its ID.
     *
     * @param milestoneId The ID of the milestone.
     * @return The creator ID of the milestone, or -1 if the milestone doesn't exist.
     * @throws ServiceException If there's an issue with the service operation.
     */				
    public long getCreatorId(Long milestoneId) throws ServiceException {
        return milestoneDAO.getCreatorId(milestoneId);
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
     * @throws DAO Exception If there's an issue with the data access operation.
     */



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
     * @throws ServiceException If there's an issue with the service operation.
     */
//    public Milestone getMilestoneById1(int milestoneId) throws ServiceException {
//        return milestoneDAO.getMilestoneById(milestoneId);
//    }

    /**
     * Retrieves a list of Milestone records where two IDs are equal.
     *
     * @return A list of Milestone objects if found, or an empty list if not found.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public List<Milestone> getMilestonesWithEqualIds() throws ServiceException {
        return milestoneDAO.getMilestonesWithEqualIds();
    }
    
    /**
     * Retrieves a list of all milestones in the system.
     * 
     * @return A list of all milestones in the system.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public List<Milestone> getAllMilestones1() throws ServiceException {
        return milestoneDAO.getAllMilestones();
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


	public List<Milestone> getAllMilestones() {
		return null;
	}
}
