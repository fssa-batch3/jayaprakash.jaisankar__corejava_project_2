package com.fssa.projectprovision.model;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Milestone {

    private int tasks_id;
    private String taskText;
    private LocalDate taskDate;
    private LocalTime taskTime;
    private boolean isRemainder;

    public Milestone() {
        // Default constructor
    }

    public Milestone(int todoId, String taskText, LocalDate taskDate, LocalTime taskTime, boolean isRemainder) {
        this.tasks_id = tasks_id;
        this.taskText = taskText;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.isRemainder = isRemainder;
    }

    public int gettasks_id1() {
        return tasks_id;
    }

    public void setTodoId(int tasks_id) {
        this.tasks_id = tasks_id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate localDate) {
        this.taskDate = localDate;
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
                "tasks_id='" + tasks_id + '\'' +
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

	public String gettasks_id() {
		// TODO Auto-generated method stub
		return null;
	}


	public void settasks_id(int int1) {
		// TODO Auto-generated method stub
		
	}


}
