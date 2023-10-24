package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.model.Team;
import com.fssa.projectprovision.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    public TeamDAO() {
       
    }

    public boolean createTeam(Team team) throws DAOException {
        String query = "INSERT INTO team (url, team, roles, members,mail) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, team.getUrl()); 
            pst.setString(2, team.getTeam());
            pst.setString(3, team.getRoles());
            pst.setInt(4, team.getMembers());
            pst.setString(5, team.getMail());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<Team> getAllTeams() throws DAOException {
        List<Team> teamList = new ArrayList<>();
        String query = "SELECT * FROM team";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Team team = buildTeamFromResultSet(rs);
                teamList.add(team);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return teamList;
    }

    public Team getTeamById(int teamId) throws DAOException {
        Team team = null;
        String query = "SELECT * FROM team WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, teamId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    team = buildTeamFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return team;
    }

    public boolean updateTeam(Team team) throws DAOException {
        String query = "UPDATE team SET url = ?, team = ?, roles = ?, members = ?, mail=?WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, team.getUrl()); 
            pst.setString(2, team.getTeam());
            pst.setString(3, team.getRoles());
            pst.setInt(4, team.getMembers());
            pst.setString(5, team.getMail());
            pst.setInt(6, team.getId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public boolean deleteTeam(int teamId) throws DAOException {
        String query = "DELETE FROM team WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, teamId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Team buildTeamFromResultSet(ResultSet rs) throws SQLException {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setUrl(rs.getString("url")); 
        team.setTeam(rs.getString("team"));
        team.setRoles(rs.getString("roles"));
        team.setMembers(rs.getInt("members"));
        team.setMail(rs.getString("mail"));
        return team;
    }
}
