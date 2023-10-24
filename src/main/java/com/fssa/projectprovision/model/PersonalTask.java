package com.fssa.projectprovision.model;

import java.time.LocalDate;

import java.time.LocalTime;

public class PersonalTask {

    private int taskId;
    private long userId;
    private String taskName;
    private boolean remainder;
    private LocalDate taskDate;
    private LocalTime taskTime;

    public PersonalTask(int taskId, long userId, String taskName, boolean remainder, LocalDate taskDate, LocalTime taskTime) {
        this.taskId = taskId;
        this.userId = userId;
        this.taskName = taskName;
        this.remainder = remainder;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
    }

    public PersonalTask() {
    }
 
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isRemainder() {
        return remainder;
    }

    public void setRemainder(boolean remainder) {
        this.remainder = remainder;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public LocalTime getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(LocalTime taskTime) {
        this.taskTime = taskTime;
    }

    @Override
    public String toString() {
        return "PersonalTask{" +
                "taskId=" + taskId +
                ", userId=" + userId +
                ", taskName='" + taskName + '\'' +
                ", remainder=" + remainder +
                ", taskDate=" + taskDate +
                ", taskTime=" + taskTime +
                '}';
    }
}
