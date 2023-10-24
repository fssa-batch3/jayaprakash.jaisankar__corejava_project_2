package com.fssa.projectprovision.dao;



import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.model.PersonalTask;
import com.fssa.projectprovision.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PersonalTaskDAO {

    public PersonalTaskDAO() {
    }

    public boolean createPersonalTask(PersonalTask task) throws DAOException {
        String query = "INSERT INTO personaltask (user_id, task_name, remainder, task_date, task_time) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, task.getUserId()); 
            pst.setString(2, task.getTaskName());
            pst.setBoolean(3, task.isRemainder());
            pst.setDate(4, Date.valueOf(task.getTaskDate()));
            pst.setTime(5, Time.valueOf(task.getTaskTime()));

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
 
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    } 

    public List<PersonalTask> getAllPersonalTasks() throws DAOException {
        List<PersonalTask> taskList = new ArrayList<>();
        String query = "SELECT * FROM personaltask";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                PersonalTask task = buildPersonalTaskFromResultSet(rs);
                taskList.add(task);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return taskList;
    }

    public List<PersonalTask> getPersonalTaskById(long userId) throws DAOException {
    	 List<PersonalTask> taskList = new ArrayList<>();
        String query = "SELECT * FROM personaltask WHERE user_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, userId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                	 PersonalTask task = buildPersonalTaskFromResultSet(rs);
                     taskList.add(task);
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return taskList;
    }
    public PersonalTask getPersonalTaskById1(long taskId) throws DAOException {
        String query = "SELECT * FROM personaltask WHERE task_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, taskId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return buildPersonalTaskFromResultSet(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    
    public boolean updatePersonalTask(PersonalTask task) throws DAOException {
        String query = "UPDATE personaltask SET " +
                "user_id = ?, task_name = ?, remainder = ?, task_date = ?, task_time = ? " +
                "WHERE task_id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, task.getUserId());
            pst.setString(2, task.getTaskName());
            pst.setBoolean(3, task.isRemainder());
            pst.setDate(4, Date.valueOf(task.getTaskDate()));
            pst.setTime(5, Time.valueOf(task.getTaskTime()));
            pst.setInt(6, task.getTaskId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public boolean deletePersonalTask(int taskId) throws DAOException {
        String query = "DELETE FROM personaltask WHERE task_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, taskId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public List<PersonalTask> getPersonalTasksByUserId(long userId) throws DAOException {
        List<PersonalTask> taskList = new ArrayList<>();
        String query = "SELECT * FROM personaltask WHERE user_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, userId);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    PersonalTask task = buildPersonalTaskFromResultSet(rs);
                    taskList.add(task);
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return taskList;
    }


    private PersonalTask buildPersonalTaskFromResultSet(ResultSet rs) throws SQLException {
        PersonalTask task = new PersonalTask();
        task.setTaskId(rs.getInt("task_id"));
        task.setUserId(rs.getLong("user_id"));
        task.setTaskName(rs.getString("task_name"));
        task.setRemainder(rs.getBoolean("remainder"));
        task.setTaskDate(rs.getDate("task_date").toLocalDate());
        task.setTaskTime(rs.getTime("task_time").toLocalTime());
        return task;
    }
}
