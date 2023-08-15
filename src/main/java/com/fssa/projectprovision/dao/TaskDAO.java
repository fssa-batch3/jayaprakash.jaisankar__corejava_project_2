package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public TaskDAO() {
    }

    public static boolean createTask(Task task) throws DAOException {
        String query = "INSERT INTO tasks (taskname, taskdetails, taskcategory, taskdue, taskassignee, taskstatus, " +
                "projectname, taskpriority, tasktags, todoID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, task.getTaskName());
            pst.setString(2, task.getTaskDetails());
            pst.setString(3, task.getTaskCategory());
            pst.setDate(4, task.getTaskDue());
            pst.setString(5, task.getTaskAssignee());
            pst.setString(6, task.getTaskStatus());
            pst.setString(7, task.getProjectName());
            pst.setString(8, task.getTaskPriority());
            pst.setString(9, task.getTaskTags());
            pst.setString(10, task.getTodoId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Task> getAllTasks() throws DAOException {
        List<Task> taskList = new ArrayList<>();
        String query = "SELECT * FROM tasks";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
 
            while (rs.next()) {
                Task task = buildTaskFromResultSet(rs);
                taskList.add(task);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return taskList;
    }

    public static Task getTaskById(int taskId) throws DAOException {
        Task task = null;
        String query = "SELECT * FROM tasks WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, taskId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    task = buildTaskFromResultSet(rs);
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return task;
    }

    // Implement update and delete methods as needed

    private static Task buildTaskFromResultSet(ResultSet rs) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setTaskName(rs.getString("taskname"));
        task.setTaskDetails(rs.getString("taskdetails"));
        task.setTaskCategory(rs.getString("taskcategory"));
        task.setTaskDue(rs.getDate("taskdue"));
        task.setTaskAssignee(rs.getString("taskassignee"));
        task.setTaskStatus(rs.getString("taskstatus"));
        task.setProjectName(rs.getString("projectname"));
        task.setTaskPriority(rs.getString("taskpriority"));
        task.setTaskTags(rs.getString("tasktags"));
        task.setTodoId(rs.getString("todoID"));
        return task;
    }
    
    
    public static boolean updateTask(Task task) throws DAOException {
        String query = "UPDATE tasks SET " +
                "taskname = ?, taskdetails = ?, taskcategory = ?, taskdue = ?, taskassignee = ?, " +
                "taskstatus = ?, projectname = ?, taskpriority = ?, tasktags = ?, todoID = ? " +
                "WHERE id = ?";
        
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, task.getTaskName());
            pst.setString(2, task.getTaskDetails());
            pst.setString(3, task.getTaskCategory());
            pst.setDate(4, task.getTaskDue());
            pst.setString(5, task.getTaskAssignee());
            pst.setString(6, task.getTaskStatus());
            pst.setString(7, task.getProjectName());
            pst.setString(8, task.getTaskPriority());
            pst.setString(9, task.getTaskTags());
            pst.setString(10, task.getTodoId());
            pst.setInt(11, task.getId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static boolean deleteTask(int taskId) throws DAOException {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, taskId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
