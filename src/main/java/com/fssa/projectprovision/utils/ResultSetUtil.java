package com.fssa.projectprovision.utils;



import com.fssa.projectprovision.model.User;
import com.fssa.projectprovision.model.Task;
import com.fssa.projectprovision.model.Milestone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetUtil {

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
    public static Milestone buildMilestoneFromResultSet(ResultSet rs) throws SQLException {
        Milestone milestone = new Milestone();
        milestone.settasks_id(rs.getInt(1));
        milestone.setTaskText(rs.getString("task_text"));
        milestone.setTaskDate(rs.getDate("task_date").toLocalDate());
        milestone.setTaskTime(rs.getTime("task_time").toLocalTime());
        milestone.setRemainder(rs.getBoolean("is_remainder"));
        return milestone;
    }
}
