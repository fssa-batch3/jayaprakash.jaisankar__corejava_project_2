package com.fssa.projectprovision.model;

import java.sql.Date;
import java.time.LocalDate;

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

    public Task() {
    }

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
