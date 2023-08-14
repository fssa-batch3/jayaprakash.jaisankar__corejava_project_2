package com.fssa.projectprovision.model;

import java.sql.Date;

public class Task {
    private int id;
    private String taskName;
    private String taskDetails;
    private String taskCategory;
    private Date taskDue;
    private String taskAssignee;
    private String taskStatus;
    private String projectName;
    private String taskPriority;
    private String taskTags;
    private String todoId;

    public Task() {
    }

    public Task(int id, String taskName, String taskDetails, String taskCategory,
                Date taskDue, String taskAssignee, String taskStatus, String projectName,
                String taskPriority, String taskTags, String todoId) {
        this.id = id;
        this.taskName = taskName;
        this.taskDetails = taskDetails;
        this.taskCategory = taskCategory;
        this.taskDue = taskDue;
        this.taskAssignee = taskAssignee;
        this.taskStatus = taskStatus;
        this.projectName = projectName;
        this.taskPriority = taskPriority;
        this.taskTags = taskTags;
        this.todoId = todoId;
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

    public Date getTaskDue() {
        return taskDue;
    }

    public void setTaskDue(Date taskDue) {
        this.taskDue = taskDue;
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
