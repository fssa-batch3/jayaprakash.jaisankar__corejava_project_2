package com.fssa.projectprovision.model;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a Milestone associated with a Project Task.
 * 
 * @author JayaprakashJaisankar
 */

public class Milestone {

    private int tasks_id;
    private String taskText;
    private LocalDate taskDate;
    private LocalTime taskTime;
    private boolean isRemainder;

    /**
     * Default constructor for creating a Milestone object.
     */
    public Milestone() {
        // Default constructor
    }

    
    /**
     * Constructor for creating a Milestone object with specific attributes.
     *
     * @param tasks_id The ID of the associated task.
     * @param taskText The text of the task.
     * @param taskDate The date of the task.
     * @param taskTime The time of the task.
     * @param isRemainder Whether the task has a reminder.
     */
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
    
 
    /**
     * Returns a string representation of the Milestone object.
     *
     * @return A string containing Milestone attribute values.
     */

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

		
	}

	public void setTaskDetails(String string) {
	
		
	}

	public void setMilestone(Milestone milestone) {
		
		
	}



	public void setUserId(int int1) {
	
		
	}

	public void setUserId11(int int1) {
	
		
	}

	public void setTaskDate1(Date date) {
	
		
	}

	public String gettasks_id() {
	
		return null;
	}


	public void settasks_id(int int1) {
	
		
	}


}
