package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.model.Milestone;
import com.fssa.projectprovision.service.MilestoneService;
import com.fssa.projectprovision.utils.ConnectionUtil;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MilestoneDAO {

    public static List<Milestone> getProjectTasksWithMilestones() {
        List<Milestone> projectTasks = new ArrayList<>();
        String query = "SELECT pt.*, m.task_text, m.task_date, m.task_time, m.is_remainder " +
                       "FROM projecttask pt " +
                       "INNER JOIN milestone m ON pt.todoID = m.todoID";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Milestone milestone = buildMilestoneFromResultSet(rs);
                projectTasks.add(milestone);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return projectTasks;
    }

    public static boolean insertMilestone(Milestone milestone) {
        String query = "INSERT INTO milestone (todoID, task_text, task_date, task_time, is_remainder) " +
                       "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, milestone.getTodoId());
            pst.setString(2, milestone.getTaskText());
            pst.setDate(3, milestone.getTaskDate());
            pst.setTime(4, Time.valueOf(milestone.getTaskTime()));
            pst.setBoolean(5, milestone.isRemainder());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public static boolean updateMilestone(Milestone milestone) {
        String query = "UPDATE milestone SET task_text = ?, task_date = ?, task_time = ?, is_remainder = ? " +
                       "WHERE todoID = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, milestone.getTaskText());
            pst.setDate(2, milestone.getTaskDate());
            pst.setTime(3, Time.valueOf(milestone.getTaskTime()));
            pst.setBoolean(4, milestone.isRemainder());
            pst.setInt(5, milestone.getTodoId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public static boolean deleteMilestoneByTodoId(int todoId) {
        String query = "DELETE FROM milestone WHERE todoID = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, todoId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    // Add more methods as needed

    private static Milestone buildMilestoneFromResultSet(ResultSet rs) throws SQLException {
        Milestone milestone = new Milestone();
        milestone.setTodoId(rs.getInt("id"));
        milestone.setUserId(rs.getInt("user_id"));
        milestone.setTaskText(rs.getString("taskname"));
        milestone.setTaskDetails(rs.getString("taskdetails"));
        milestone.setTaskDate(rs.getDate("task_date"));
        milestone.setTaskTime(rs.getTime("task_time").toLocalTime());
        milestone.setRemainder(rs.getBoolean("is_remainder"));
        return milestone;
    }

    private static void handleSQLException(SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("An error occurred while accessing the database.", e);
    }


	

	public List<MilestoneService> getAllMilestones() {
		// TODO Auto-generated method stub
		return null;
	}

	public MilestoneDAO getMilestoneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

    // Add more methods as needed
}
