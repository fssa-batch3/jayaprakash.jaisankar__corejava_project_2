package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.TaskDAO;

import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.validation.TaskValidator;

import java.util.List;

/**
 * A service class that provides methods for managing tasks in the system.
 * This class interacts with the TaskDAO to perform CRUD operations on tasks.
 * It also uses TaskValidator for task validation.
 * 
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */

public class TaskService {


    private final TaskDAO taskDAO;

    /**
     * Constructs a TaskService with the provided TaskDAO.
     * 
     * @param taskDAO The data access object for tasks.
     */
    
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    
    /**
     * Creates a new task in the system.
     * 
     * @param task The task to be created.
     * @return True if the creation is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     */
    
    
    public boolean createTask(Task task) throws ServiceException {
    	boolean result = false;
    	try {
            TaskValidator.validateTask(task);
            result = taskDAO.createTask(task);
        } catch (DAOException | ValidationException e) {
            throw new ServiceException("Failed to create first task", e);
        }
        return result;
    }


    
    /**
     * Retrieves a task by its ID.
     * 
     * @param taskId The ID of the task to retrieve.
     * @return The retrieved task, or null if not found.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public Task getTaskById(int taskId) throws ServiceException {
        try {
            return TaskDAO.getTaskById(taskId);
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve task", e);
        }
    }
    

    /**
     * Retrieves a list of all tasks in the system.
     * 
     * @return A list of all tasks in the system.
     * @throws ServiceException If there's an issue with the service operation.
     */

    public List<Task> getAllTasks() throws ServiceException {
        try {
            return TaskDAO.getAllTasks();
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve tasks", e);
        }
    }
    

    /**
     * Updates an existing task in the system.
     * 
     * @param task The task to be updated.
     * @return A message indicating the success or failure of the update.
     * @throws ServiceException If there's an issue with the service operation.
     */
    

    public String updateTask(Task task) throws ServiceException {
        try {
            TaskValidator.validateTask(task);
            boolean result = taskDAO.updateTask(task);
            if (result) {
                return "Task Updated Successfully";
            } else {
                return "Failed to Update Task";
            }
        } catch (DAOException | ValidationException e) {
            throw new ServiceException("Failed to update task", e);
        }
    }
    
    /**
     * Deletes a task by its ID.
     * 
     * @param taskId The ID of the task to delete.
     * @return A message indicating the success or failure of the deletion.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public String deleteTaskById(int taskId) throws ServiceException {
        try {
            boolean result = TaskDAO.getTaskById(taskId) != null;
            if (result) {
                return "Task Deleted Successfully";
            } else {
                return "Failed to Delete Task";
            }
        } catch (DAOException e) {
            throw new ServiceException("Failed to delete task", e);
        }
    }

    
    /**
     * Deletes a task by its ID.
     * 
     * @param taskIdToDelete The ID of the task to delete.
     * @return True if the deletion is successful, false otherwise.
     */
	public boolean deleteTask(int taskIdToDelete) {

		return false;
	}
}