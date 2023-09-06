package com.fssa.projectprovision.utils;



import com.fssa.projectprovision.model.User;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.model.Milestone;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 
 *  A utility class for building model objects from ResultSet data.
 * This class provides methods to construct User, Task, and Milestone objects from ResultSet rows.
 * 
 * 
 * Usage:
 * ResultSet resultSet = ...; // Get a ResultSet from database query
 * User user = ResultSetUtil.buildUserFromResultSet(resultSet);
 * Task task = ResultSetUtil.buildTaskFromResultSet(resultSet);
 * Milestone milestone = ResultSetUtil.buildMilestoneFromResultSet(resultSet);
 * // Use the constructed objects as needed
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */
public class ResultSetUtil {

	
	 /**
     * Builds a User object from the data in the ResultSet.
     * 
     * @param rs The ResultSet containing user data.
     * @return A User object constructed from the ResultSet data.
     * @throws SQLException If there's an issue with accessing ResultSet data.
     */
	
    public static User buildUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setGender(rs.getString("gender"));
        user.setMobileNumber(rs.getString("mobile_number"));
        user.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        user.setAddress(rs.getString("address"));
        user.setAboutMe(rs.getString("about_me"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setProfilePic(rs.getString("profile_pic"));
        user.setMyTodos(rs.getString("mytodos"));
        user.setUserId(rs.getLong("user_id"));
        return user;
    }
    
    /**
     * Builds a Task object from the data in the ResultSet.
     * 
     * @param rs The ResultSet containing task data.
     * @return A Task object constructed from the ResultSet data.
     * @throws SQLException If there's an issue with accessing ResultSet data.
     */
    
    
    public static Task buildTaskFromResultSet(ResultSet rs) throws SQLException {
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
    
    /**
     * Builds a Milestone object from the data in the ResultSet.
     * 
     * @param rs The ResultSet containing milestone data.
     * @return A Milestone object constructed from the ResultSet data.
     * @throws SQLException If there's an issue with accessing ResultSet data.
     */
    
    
    public static Milestone buildMilestoneFromResultSet(ResultSet rs) throws SQLException {
        Milestone milestone = new Milestone();
        milestone.setTasks_id(rs.getInt(1));
        milestone.setTaskText(rs.getString("task_text"));
        milestone.setTaskDate(rs.getDate("task_date").toLocalDate());
        milestone.setTaskTime(rs.getTime("task_time").toLocalTime());
        milestone.setIsRemainder(rs.getBoolean("is_remainder"));
        return milestone;
    }
}
