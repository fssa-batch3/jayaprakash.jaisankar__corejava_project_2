package com.fssa.projectprovision.service;



import com.fssa.projectprovision.dao.PersonalTaskDAO;

import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.model.PersonalTask;


import java.util.List;

public class PersonalTaskService {

    private final PersonalTaskDAO personalTaskDAO;

    public PersonalTaskService(PersonalTaskDAO personalTaskDAO) {
        this.personalTaskDAO = personalTaskDAO;
    } 

    public boolean createPersonalTask(PersonalTask task) throws ServiceException {
        try {
            return personalTaskDAO.createPersonalTask(task);
        } catch (DAOException e) {
            throw new ServiceException("Failed to create personal task", e);
        }
    }

    public List<PersonalTask> getAllPersonalTasks() throws ServiceException {
        try {
            return personalTaskDAO.getAllPersonalTasks();
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve personal tasks", e);
        }
    }

    public PersonalTask getPersonalTaskById(long userId) throws ServiceException {
        try {
            return personalTaskDAO.getPersonalTaskById(userId);
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve personal task", e);
        }
    }

    public boolean updatePersonalTask(PersonalTask task) throws ServiceException {
        try {
            return personalTaskDAO.updatePersonalTask(task);
        } catch (DAOException e) {
            throw new ServiceException("Failed to update personal task", e);
        }
    }

    public boolean deletePersonalTask(int taskId) throws ServiceException {
        try {
            return personalTaskDAO.deletePersonalTask(taskId);
        } catch (DAOException e) {
            throw new ServiceException("Failed to delete personal task", e);
        }
    }
}

