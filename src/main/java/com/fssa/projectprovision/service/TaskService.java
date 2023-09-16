package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.TaskDAO;


import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.validation.TaskValidator;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

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


	public Task getId(long taskId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Retrieves a list of tasks by the assignee's email.
	 *
	 * @param assigneeEmail The assignee's email to search for.
	 * @return A list of tasks assigned to the specified email.
	 * @throws ServiceException If there's an issue with the service operation.
	 */
	public List<Task> getTasksByAssigneeEmail(String assigneeEmail) throws ServiceException {
	    try {
	        return taskDAO.getTasksByAssigneeEmail(assigneeEmail);
	    } catch (DAOException e) {
	        throw new ServiceException("Failed to retrieve tasks by assignee's email", e);
	    }
	}


	public List<Task> getFilteredAndSortedTasks(String sortCriteria, String filterCriteria, String searchKeyword) throws ServiceException {
	    try {
	        List<Task> filteredAndSortedTasks = new ArrayList<>();
	        List<Task> allTasks = taskDAO.getAllTasks();

	        if ("Based On Category".equals(filterCriteria)) {
	            for (Task task : allTasks) {
	                if (task.getTaskCategory().equalsIgnoreCase(searchKeyword)) {
	                    filteredAndSortedTasks.add(task);
	                }
	            }
	        } else if ("Based On Assignee".equals(filterCriteria)) {
	            for (Task task : allTasks) {
	                if (task.getTaskAssignee().equalsIgnoreCase(searchKeyword)) {
	                    filteredAndSortedTasks.add(task);
	                }
	            }
	        } else if ("Based On Status".equals(filterCriteria)) {
	            for (Task task : allTasks) {
	                if (task.getTaskStatus().equalsIgnoreCase(searchKeyword)) {
	                    filteredAndSortedTasks.add(task);
	                }
	            }
	        } else if ("Based On Priority".equals(filterCriteria)) {
	            for (Task task : allTasks) {
	                if (task.getTaskPriority().equalsIgnoreCase(searchKeyword)) {
	                    filteredAndSortedTasks.add(task);
	                }
	            }
	        } else if ("Based On Tags".equals(filterCriteria)) {
	            for (Task task : allTasks) {
	                if (task.getTaskTags().equalsIgnoreCase(searchKeyword)) {
	                    filteredAndSortedTasks.add(task);
	                }
	            }
	        } else {
	            filteredAndSortedTasks.addAll(allTasks);
	        }

	        if ("Based On Due date".equals(sortCriteria)) {
	            Collections.sort(filteredAndSortedTasks, Comparator.comparing(Task::getTaskDue));
	        } else if ("A-Z (Ascending Order)".equals(sortCriteria)) {
	            Collections.sort(filteredAndSortedTasks, Comparator.comparing(Task::getTaskName));
	        } else if ("Z-A (Descending Order)".equals(sortCriteria)) {
	            Collections.sort(filteredAndSortedTasks, Comparator.comparing(Task::getTaskName).reversed());
	        }

	        return filteredAndSortedTasks;
	    } catch (DAOException e) {
	        throw new ServiceException("Failed to retrieve filtered and sorted tasks", e);
	    }
	

//	        if ("Based On Due date".equals(sortCriteria)) {
//	            Collections.sort(filteredAndSortedTasks, Comparator.comparing(Task::getDueDate));
//	        }


	      
	}





}