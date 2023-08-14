package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.TaskDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.validation.TaskValidator;

import java.util.List;

public class TaskService {

    public TaskService(TaskDAO taskDAO) {

	}

	public String createTask(Task task) throws ServiceException {
        try {
            TaskValidator.validateTask(task); // Validate task fields before creating
            boolean result = TaskDAO.createTask(task);
            if (result) {
                return "Task Created Successfully";
            } else {
                return "Failed to Create Task";
            }
        } catch (DAOException | ValidationException e) {
            throw new ServiceException("Failed to create task", e);
        }
    }

    public Task getTaskById(int taskId) throws ServiceException {
        try {
            return TaskDAO.getTaskById(taskId);
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve task", e);
        }
    }

    public List<Task> getAllTasks() throws ServiceException {
        try {
            return TaskDAO.getAllTasks();
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve tasks", e);
        }
    }

    public String updateTask(Task task) throws ServiceException {
        try {
            TaskValidator.validateTask(task); // Validate task fields before updating
            boolean result = TaskDAO.updateTask(task);
            if (result) {
                return "Task Updated Successfully";
            } else {
                return "Failed to Update Task";
            }
        } catch (DAOException | ValidationException e) {
            throw new ServiceException("Failed to update task", e);
        }
    }

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

	public boolean deleteTask(int taskIdToDelete) {

		return false;
	}
}
