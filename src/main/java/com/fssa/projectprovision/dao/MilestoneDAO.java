package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.model.Milestone;




import com.fssa.projectprovision.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 *  A data access object for managing Milestone data in the database.
 * Provides methods to interact with and manipulate Milestone records.
 *
 * Usage:
 * MilestoneDAO milestoneDAO = new MilestoneDAO();
 * List<Milestone> projectTasks = milestoneDAO.getProjectTasksWithMilestones();
 * // Use the methods to interact with the database and manipulate Milestone records
 * 
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */


/**
 * A data access object for managing Milestone data in the database.
 * Provides methods to interact with and manipulate Milestone records.
 *
 */
public class MilestoneDAO {  
    /**
     * Retrieves a list of Project Tasks with associated Milestones from the database.
     *
     * @return A list of Milestone objects representing Project Tasks with Milestones.
     */ 

    public static List<Milestone> getProjectTasksWithMilestones() {
        List<Milestone> projectTasks = new ArrayList<>();
        String query = "SELECT pt.*, t.task_text, t.task_date, t.task_time, t.is_remainder " +
        	    "FROM tasks pt " +
        	    "INNER JOIN milestone t ON pt.id = t.tasks_id";


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
    
    
    
    public static List<Milestone> getProjectTasksWithMilestones(int task_id) {
        List<Milestone> projectTasks = new ArrayList<>();
        String query = "SELECT pt.*, t.task_text, t.task_date, t.task_time, t.is_remainder " +
        	    "FROM tasks pt " +
        	    "INNER JOIN milestone t ON pt.id = t.tasks_id WHERE task_id=?";


        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);){
        	pst.setInt(1,task_id);
             ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Milestone milestone = buildMilestoneFromResultSet(rs);
                projectTasks.add(milestone);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return projectTasks;
    }

    
    public long getCreatorId(Long milestoneId) {
        String query = "SELECT user_id FROM milestone WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, milestoneId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("user_id"); 
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
         return milestoneId; 
    }

    /**
     * Retrieves a list of Milestone records where two IDs are equal.
     *
     * @return A list of Milestone objects if found, or an empty list if not found.
     */
    public List<Milestone> getMilestonesWithEqualIds() {
        List<Milestone> milestones = new ArrayList<>();
        String query = "SELECT pt.*, t.id AS milestoneid, t.* " +
                       "FROM tasks pt " +
                       "INNER JOIN milestone t ON pt.id = t.tasks_id " +
                       "WHERE pt.id = t.tasks_id"; 

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Milestone milestone = buildMilestoneFromResultSet(rs);
                milestones.add(milestone);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return milestones;
    }

    
  

    /**
     * Inserts a new Milestone record into the database.
     *
     * @param milestone The Milestone object to be inserted.
     * @return True if the insertion was successful, false otherwise.
     */
    public boolean insertMilestone(Milestone milestone, long userId, String taskAssignee) {
        String query = "INSERT INTO milestone (task_text, task_date, task_time, is_remainder, tasks_id, user_id, taskassignee) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, milestone.getTaskText());
            pst.setDate(2, Date.valueOf(milestone.getTaskDate()));
            pst.setTime(3, Time.valueOf(milestone.getTaskTime()));
            pst.setBoolean(4, milestone.getIsRemainder());
            pst.setInt(5, milestone.gettasks_id());
            pst.setLong(6, userId); 
            pst.setString(7, taskAssignee); 

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    /**
     * Retrieves a list of Project Tasks with associated Milestones from the database.
     *
     * @return A list of Milestone objects representing Project Tasks with Milestones.
     */
    public static List<Milestone> getProjectTasksWithMilestones(long userId) {
        List<Milestone> projectTasks = new ArrayList<>();
//        String query = "SELECT pt.*, t.task_text, t.task_date, t.task_time, t.is_remainder " +
//                "FROM tasks pt " +
//                "INNER JOIN milestone t ON pt.id = t.tasks_id " +
//                "WHERE pt.user_id = ? AND t.taskassignee = ?"; 
        String query = "SELECT * FROM milestone WHERE user_id = ? "; 

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, userId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Milestone milestone = buildMilestoneFromResultSet(rs);
                    projectTasks.add(milestone);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return projectTasks;
    }

    
    /**
     * Updates an existing Milestone record in the database.
     *
     * @param milestone The updated Milestone object.
     * @return True if the update was successful, false otherwise.
     */

    public boolean updateMilestone(Milestone milestone) {
        String query = "UPDATE milestone SET task_text = ?, task_date = ?, task_time = ?, is_remainder = ? WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, milestone.getTaskText());
            pst.setDate(2, Date.valueOf(milestone.getTaskDate()));
            pst.setTime(3, Time.valueOf(milestone.getTaskTime()));
            pst.setBoolean(4, milestone.getIsRemainder());
            pst.setInt(5, milestone.getId()); 

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    

    /**
     * Deletes Milestone records associated with a given ID from the database.
     *
     * @param tasks_id The ID for which Milestone records should be deleted.
     * @return True if the deletion was successful, false otherwise.
     */

    public boolean deleteMilestoneByTodoId(int id) {
        String query = "DELETE FROM milestone WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    /**
     * Retrieves a list of Milestone objects by taskText from the database.
     *
     * @param taskText The taskText to search for.
     * @return A list of Milestone objects matching the taskText.
     */
    public List<Milestone> getMilestonesByTaskText(String taskText) {
        List<Milestone> milestones = new ArrayList<>();
        String query = "SELECT * FROM milestone WHERE task_text = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, taskText);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Milestone milestone = buildMilestoneFromResultSet(rs);
                    milestones.add(milestone);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return milestones;
    }

    
    public List<Milestone> getMilestonesByTaskId(int taskId) {
        List<Milestone> milestones = new ArrayList<>();
        String query = "SELECT * FROM milestone WHERE tasks_id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, taskId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Milestone milestone = buildMilestoneFromResultSet(rs);
                    milestones.add(milestone);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return milestones;
    }


    /**
     * Builds a Milestone object from a ResultSet.
     *
     * @param rs The ResultSet containing Milestone data.
     * @return A Milestone object built from the ResultSet data.
     * @throws SQLException If a database error occurs.
     */
    private static Milestone buildMilestoneFromResultSet(ResultSet rs) throws SQLException {
        Milestone milestone = new Milestone();
      
        milestone.setCreatorId(rs.getLong("user_id"));
        milestone.setTaskText(rs.getString("task_text"));
        milestone.setTaskDate(rs.getDate("task_date").toLocalDate());
        milestone.setTaskTime(rs.getTime("task_time").toLocalTime());
        milestone.setIsRemainder(rs.getBoolean("is_remainder"));
        milestone.setId(rs.getInt("id")); 	
       // milestone.settasks_id(rs.getInt("tasks_id"));
        return milestone;
    }
  
    /**
     * Handles SQLException by printing the stack trace and throwing a RuntimeException.
     *
     * @param e The SQLException that occurred.
     */
    private static void handleSQLException(SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("An error occurred while accessing the database.", e);
    }


	

		public List<Milestone> getAllMilestones() {
			return null;
		}


	////	public Milestone getMilestoneById(Milestone id) {
		//	return id;
		   
	//	}

	
	public Milestone getMilestoneById1(Milestone taskId) {
		return taskId;
	}
	public Milestone getMilestoneById(int milestoneId) {
		Milestone milestone = null;
        String query = "SELECT * FROM milestone WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, milestoneId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                   milestone = buildMilestoneFromResultSet(rs);
                }
            }
       } catch (SQLException e) {
           handleSQLException(e);
        }
        return milestone;
	}
	public Milestone getMilestoneByTaskText(String taskText) {
		return null;
	}

    
}