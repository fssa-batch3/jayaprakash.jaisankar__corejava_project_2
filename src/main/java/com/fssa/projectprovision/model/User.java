package com.fssa.projectprovision.model;


import java.sql.Date;
import java.time.LocalDate;

/**
 * 
 * * A class representing a user in the system.
 * 
 * This class holds various attributes and methods to manage user information.
 * 
 * @author JayaprakashJaisankar
 *
 */
public class User {
    private long id;
    private String name;
    private String gender;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private String address;
    private String aboutMe;
    private String email;
    private String password;
    private String profilePic;
    private String myTodos; // Represent JSON as a String
    private long userId;
    private boolean isDeleted;

    /**
     * Default constructor for creating a User object.
     */
   
    public User() { 
    }
    /**
     * Parameterized constructor for creating a User object.
     *
     * @param name The name of the user.
     * @param gender The gender of the user.
     * @param mobileNumber The mobile number of the user.
     * @param dateOfBirth The date of birth of the user.
     * @param address The address of the user.
     * @param aboutMe A short description about the user.
     * @param email The email address of the user.
     * @param password The password of the user's account.
     * @param profilePic The profile picture of the user.
     * @param myTodos JSON representation of user's to-do list.
     * @param userId The user's unique identifier.
     * @param isDeleted Flag indicating if the user is deleted.
     */
    public User(String name, String gender, String mobileNumber, LocalDate dateOfBirth,
                String address, String aboutMe, String email, String password,
                String profilePic, String myTodos, long userId,boolean isDeleted) {
        this.name = name;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.aboutMe = aboutMe;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
        this.myTodos = myTodos;
        this.userId = userId;
        this.isDeleted = isDeleted;
    }

    
    /**
     * Checks if the user is marked as deleted.
     *
     * @return True if the user is deleted, false otherwise.
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Sets the deleted status of the user.
     *
     * @param deleted The deleted status to set.
     */
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    
  
    /**
     * Checks if the user is active (not deleted).
     *
     * @return True if the user is active, false if deleted.
     */

    public boolean isActive() {
        return !isDeleted;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

  
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getMyTodos() {
        return myTodos;
    }

    public void setMyTodos(String myTodos) {
        this.myTodos = myTodos;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

	

	public void setDateOfBirth(Date valueOf) {

		
	}

	public void setActive(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
}

