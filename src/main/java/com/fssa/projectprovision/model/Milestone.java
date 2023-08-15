package com.fssa.projectprovision.model;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Milestone {

    private int todoId;
    private String taskText;
    private Date taskDate;
    private LocalTime taskTime;
    private boolean isRemainder;

    public Milestone() {
        // Default constructor
    }

    public Milestone(int todoId, String taskText, Date taskDate, LocalTime taskTime, boolean isRemainder) {
        this.todoId = todoId;
        this.taskText = taskText;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.isRemainder = isRemainder;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int i) {
        this.todoId = i;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date date) {
        this.taskDate = date;
    }

    public LocalTime getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(LocalTime taskTime) {
        this.taskTime = taskTime;
    }

    public boolean isRemainder() {
        return isRemainder;
    }

    public void setRemainder(boolean remainder) {
        isRemainder = remainder;
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "todoId='" + todoId + '\'' +
                ", taskText='" + taskText + '\'' +
                ", taskDate=" + taskDate +
                ", taskTime=" + taskTime +
                ", isRemainder=" + isRemainder +
                '}';
    }

	public void setUserId1(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setTaskDetails(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setMilestone(Milestone milestone) {
		// TODO Auto-generated method stub
		
	}



	public void setUserId(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setUserId11(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setTaskDate1(Date date) {
		// TODO Auto-generated method stub
		
	}


}
