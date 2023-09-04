package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.exception.DAOException;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The TaskDAO class provides methods for accessing and manipulating task data in the database.
 * This class is responsible for creating, retrieving, updating, and deleting tasks.
 *
 * Usage:
 * TaskDAO taskDAO = new TaskDAO();
 * List<Task> allTasks = taskDAO.getAllTasks();
 * Task task = taskDAO.getTaskById(taskId);
 * // Use the methods to interact with the database and manipulate Task records
 *
 * @author JayaprakashJaisankar
 *
 */
public class TaskDAO {

	
	/**
	 * The TaskDAO class provides methods for accessing and manipulating task data in the database.
	 * This class is responsible for creating, retrieving, updating, and deleting tasks.
	 *
	 */
    public TaskDAO() {
    }
 
    
    /**
     * Creates a new task in the database.
     *
     * @param task The Task object containing the task information to be created.
     * @return True if the task creation was successful, false otherwise.
     * @throws DAOException If there's an issue with the database operation.
     */
    public boolean createTask(Task task) throws DAOException {
        String query = "INSERT INTO tasks (taskname, taskdetails, taskcategory, taskdue, taskassignee, taskstatus,projectname, taskpriority, tasktags, todoID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, task.getTaskName());
            pst.setString(2, task.getTaskDetails());
            pst.setString(3, task.getTaskCategory());
            pst.setDate(4, Date.valueOf(task.getTaskDue()));
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
  
    
    /**
     * Retrieves a list of all tasks from the database.
     *
     * @return A List of Task objects representing all tasks in the database.
     * @throws DAOException If there's an issue with the database operation.
     */
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
    
    
    /**
     * Retrieves a task from the database based on the provided task ID.
     *
     * @param taskId The ID of the task to be retrieved.
     * @return A Task object representing the retrieved task.
     * @throws DAOException If there's an issue with the database operation.
     */
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

   

 
    
    /**
     * Updates an existing task in the database.
     *
     * @param task The Task object containing the updated task information.
     * @return True if the task update was successful, false otherwise.
     * @throws DAOException If there's an issue with the database operation.
     */
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
            pst.setDate(4, Date.valueOf(task.getTaskDue()));
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
   
    /**
     * Deletes a task from the database based on the provided task ID.
     *
     * @param taskId The ID of the task to be deleted.
     * @return True if the task deletion was successful, false otherwise.
     * @throws DAOException If there's an issue with the database operation.
     */

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
 
    
    /**
     * Constructs a Task object from the ResultSet containing task information.
     *
     * @param rs The ResultSet containing task information retrieved from the database.
     * @return A Task object with information extracted from the ResultSet.
     * @throws SQLException If there's an issue with retrieving data from the ResultSet.
     */
    
    private static Task buildTaskFromResultSet(ResultSet rs) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setTaskName(rs.getString("taskname"));
        task.setTaskDetails(rs.getString("taskdetails"));
        task.setTaskCategory(rs.getString("taskcategory"));
        task.setTaskDue(rs.getDate("taskdue").toLocalDate());
        task.setTaskAssignee(rs.getString("taskassignee"));
        task.setTaskStatus(rs.getString("taskstatus"));
        task.setProjectName(rs.getString("projectname"));
        task.setTaskPriority(rs.getString("taskpriority"));
        task.setTaskTags(rs.getString("tasktags"));
        task.setTodoId(rs.getString("todoID"));
        return task;
    }

}
