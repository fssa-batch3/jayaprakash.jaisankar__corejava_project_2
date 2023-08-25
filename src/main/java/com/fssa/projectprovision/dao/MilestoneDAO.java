package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.model.Milestone;

import com.fssa.projectprovision.service.MilestoneService;
import com.fssa.projectprovision.utils.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MilestoneDAO {

    public static List<Milestone> getProjectTasksWithMilestones() {
        List<Milestone> projectTasks = new ArrayList<>();
        String query = "SELECT pt.*, t.task_text, t.task_date, t.task_time, t.is_remainder"+
        		"FROM tasks pt"+
        		"INNER JOIN milestone t ON pt.id= t.tasks_id";

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
        String query = "INSERT INTO milestone (task_text, task_date, task_time, is_remainder,tasks_id) " +
                       "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

          
            pst.setString(1, milestone.getTaskText());
            pst.setDate(2, Date.valueOf(milestone.getTaskDate()));
            pst.setTime(3, Time.valueOf(milestone.getTaskTime()));
            pst.setBoolean(4, milestone.isRemainder());
            pst.setString(5, milestone.gettasks_id());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }


    public static boolean updateMilestone(Milestone milestone) {
        String query = "UPDATE milestone SET task_text = ?, task_date = ?, task_time = ?, is_remainder = ? " +
                       "WHERE tasks_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, milestone.getTaskText());
            pst.setDate(2, Date.valueOf(milestone.getTaskDate()));
            pst.setTime(3, Time.valueOf(milestone.getTaskTime()));
            pst.setBoolean(4, milestone.isRemainder());
            pst.setString(5, milestone.gettasks_id());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public static boolean deleteMilestoneByTodoId(int todoId) {
        String query = "DELETE FROM milestone WHERE tasks_id = ?";
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


    private static Milestone buildMilestoneFromResultSet(ResultSet rs) throws SQLException {
        Milestone milestone = new Milestone();
      
        milestone.setUserId(rs.getInt("user_id"));
        milestone.setTaskText(rs.getString("taskname"));
        milestone.setTaskDetails(rs.getString("taskdetails"));
        milestone.setTaskDate(rs.getDate("task_date").toLocalDate());
        milestone.setTaskTime(rs.getTime("task_time").toLocalTime());
        milestone.setRemainder(rs.getBoolean("is_remainder"));
        milestone.settasks_id(rs.getInt("tasks_id"));
        return milestone;
    }

    private static void handleSQLException(SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("An error occurred while accessing the database.", e);
    }


	

	public List<Milestone> getAllMilestones() {
		return null;
	}

	public Milestone getMilestoneById(int id) {
		return null;
	}

	public void setTodoId(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTaskText(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTaskDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}

	public void setTaskTime(LocalTime now) {
		// TODO Auto-generated method stub
		
	}

	public void setRemainder(boolean b) {
		// TODO Auto-generated method stub
		
	}

    
}
