package com.fssa.projectprovision.model;


import java.sql.Date;
import java.time.LocalDate;

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

   
    public User() { 
    }

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

    // Getters and Setters
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

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

