package com.fssa.projectprovision.model;

import java.sql.Date;
import java.time.LocalDate;


/**
 * Represents a Task associated with a project.
 * 
 * This class stores information about tasks, including their details, due date,
 * assignee, status, and more.
 *
 * @author JayaprakashJaisankar
 */
public class Task {
    private int id;
    private String taskName;
    private String taskDetails;
    private String taskCategory;
    private LocalDate taskDue;
    private String taskAssignee;
    private String taskStatus;
    private String projectName;
    private String taskPriority;
    private String taskTags;
    private String todoId;

    
    /**
     * Default constructor for creating a Task object.
     */
    public Task() {
    }
    
    /**
     * Constructor for creating a Task object with specific attributes.
     *
     * @param id The ID of the task.
     * @param taskName The name of the task.
     * @param taskDetails The details of the task.
     * @param taskCategory The category of the task.
     * @param taskDue The due date of the task.
     * @param taskAssignee The assignee of the task.
     * @param taskStatus The status of the task.
     * @param projectName The name of the associated project.
     * @param taskPriority The priority of the task.
     * @param taskTags The tags associated with the task.
     * @param todoId The ID of the associated ToDo.
     */

    public Task(int id, String taskName, String taskDetails, String taskCategory,
    		LocalDate date, String taskAssignee, String taskStatus, String projectName,
                String taskPriority, String taskTags, String todoId) {
        this.id = id;
        this.taskName = taskName;
        this.taskDetails = taskDetails;
        this.taskCategory = taskCategory;
        this.taskDue = date;
        this.taskAssignee = taskAssignee;
        this.taskStatus = taskStatus;
        this.projectName = projectName;
        this.taskPriority = taskPriority;
        this.taskTags = taskTags;
        this.todoId = todoId;
    }

    public Task(int i, String string, String string2, String string3, Date valueOf, String string4, String string5,
			String string6, String string7, String string8, String string9) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }

    public LocalDate getTaskDue() {
        return taskDue;
    }

    public void setTaskDue(LocalDate localDate) {
        this.taskDue = localDate;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskTags() {
        return taskTags;
    }

    public void setTaskTags(String taskTags) {
        this.taskTags = taskTags;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    
    
    /**
     * Returns a string representation of the Task object.
     *
     * @return A string containing Task attribute values.
     */
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDetails='" + taskDetails + '\'' +
                ", taskCategory='" + taskCategory + '\'' +
                ", taskDue=" + taskDue +
                ", taskAssignee='" + taskAssignee + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", projectName='" + projectName + '\'' +
                ", taskPriority='" + taskPriority + '\'' +
                ", taskTags='" + taskTags + '\'' +
                ", todoId='" + todoId + '\'' +
                '}';
    }
}
