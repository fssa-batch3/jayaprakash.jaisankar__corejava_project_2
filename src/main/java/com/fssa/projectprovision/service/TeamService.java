package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.TeamDAO;
import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.exception.ServiceException;
import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Team;
import com.fssa.projectprovision.validation.TeamValidator;

import java.util.List;

/**
 * A service class that provides methods for managing teams in the system.
 * This class interacts with the TeamDAO to perform CRUD operations on teams.
 * It also uses TeamValidator for team validation.
 *
 * @author YourName
 */
public class TeamService {

    private final TeamDAO teamDAO;

    /**
     * Constructs a TeamService with the provided TeamDAO.
     *
     * @param teamDAO The data access object for teams.
     */
    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    /**
     * Creates a new team in the system.
     *
     * @param team The team to be created.
     * @return True if the creation is successful, false otherwise.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public boolean createTeam(Team team) throws ServiceException {
        boolean result = false;
        try {
            TeamValidator.validateTeam(team);
            result = teamDAO.createTeam(team);
        } catch (DAOException | ValidationException e) {
            throw new ServiceException("Failed to create a team", e);
        }
        return result;
    }

    /**
     * Retrieves a list of all teams in the system.
     *
     * @return A list of all teams in the system.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public List<Team> getAllTeams() throws ServiceException {
        try {
            return teamDAO.getAllTeams();
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve teams", e);
        }
    }

    /**
     * Retrieves a team by its ID.
     *
     * @param teamId The ID of the team to retrieve.
     * @return The retrieved team, or null if not found.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public Team getTeamById(int teamId) throws ServiceException {
        try {
            return teamDAO.getTeamById(teamId);
        } catch (DAOException e) {
            throw new ServiceException("Failed to retrieve a team", e);
        }
    }

    /**
     * Updates an existing team in the system.
     *
     * @param team The team to be updated.
     * @return A message indicating the success or failure of the update.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public String updateTeam(Team team) throws ServiceException {
        try {
            TeamValidator.validateTeam(team);
            boolean result = teamDAO.updateTeam(team);
            if (result) {
                return "Team Updated Successfully";
            } else {
                return "Failed to Update Team";
            }
        } catch (DAOException | ValidationException e) {
            throw new ServiceException("Failed to update a team", e);
        }
    }

    /**
     * Deletes a team by its ID.
     *
     * @param teamId The ID of the team to delete.
     * @return A message indicating the success or failure of the deletion.
     * @throws ServiceException If there's an issue with the service operation.
     */
    public String deleteTeamById(int teamId) throws ServiceException {
        try {
            boolean result = teamDAO.deleteTeam(teamId);
            if (result) {
                return "Team Deleted Successfully";
            } else {
                return "Failed to Delete Team";
            }
        } catch (DAOException e) {
            throw new ServiceException("Failed to delete a team", e);
        }
    }
}
