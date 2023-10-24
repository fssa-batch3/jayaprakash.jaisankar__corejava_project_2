package com.fssa.projectprovision.validation;

import com.fssa.projectprovision.exception.ValidationException;
import com.fssa.projectprovision.model.Team;

public class TeamValidator {

    /**
     * Validates a Team object.
     *
     * @param team The Team object to be validated.
     * @throws ValidationException If validation fails.
     */
    public static void validateTeam(Team team) throws ValidationException {
        if (team == null) {
            throw new ValidationException("Team cannot be null");
        }

        if (team.getUrl() == null || team.getUrl().isEmpty()) {
            throw new ValidationException("Team URL is required");
        }

        if (team.getTeam() == null || team.getTeam().isEmpty()) {
            throw new ValidationException("Team name is required");
        }

        if (team.getRoles() == null || team.getRoles().isEmpty()) {
            throw new ValidationException("Team roles are required");
        }

        if (team.getMembers() < 0) {
            throw new ValidationException("Team members count cannot be negative");
        }

    }
}
