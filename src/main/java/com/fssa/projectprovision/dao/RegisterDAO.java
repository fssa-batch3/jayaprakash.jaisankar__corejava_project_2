package com.fssa.projectprovision.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


import com.fssa.projectprovision.model.Register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
    private Connection connection;

    public RegisterDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean insertUser(	Register user) {
        try {
            String query = "INSERT INTO register (name, email, password, date_of_birth, gender, mobile_number, about_me, address, profile_pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, java.sql.Date.valueOf(user.getDateOfBirth()));
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getMobileNumber());
            preparedStatement.setString(7, user.getAboutMe());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setString(9, user.getProfilePic());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(Register user) {
        try {
            String query = "UPDATE register SET name=?, date_of_birth=?, gender=?, mobile_number=?, about_me=?, address=?, profile_pic=? WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(user.getDateOfBirth()));
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getMobileNumber());
            preparedStatement.setString(5, user.getAboutMe());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getProfilePic());
            preparedStatement.setString(8, user.getEmail());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(String email) {
        try {
            String query = "DELETE FROM register WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Register loginUser(String email, String password) {
        try {
            String query = "SELECT * FROM register WHERE email=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	Register user = new Register();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                user.setGender(resultSet.getString("gender"));
                user.setMobileNumber(resultSet.getString("mobile_number"));
                user.setAboutMe(resultSet.getString("about_me"));
                user.setAddress(resultSet.getString("address"));
                user.setProfilePic(resultSet.getString("profile_pic"));
                return user;
            } else {
                return null; // User not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Register getUserByEmail(String email) {
        try {
            String query = "SELECT * FROM register WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Register user = new Register();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                user.setGender(resultSet.getString("gender"));
                user.setMobileNumber(resultSet.getString("mobile_number"));
                user.setAboutMe(resultSet.getString("about_me"));
                user.setAddress(resultSet.getString("address"));
                user.setProfilePic(resultSet.getString("profile_pic"));
                return user;
            } else {
                return null; // User not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Register> getAllUsers() throws SQLException {
        List<Register> users = new ArrayList<>();
        String query = "SELECT * FROM register";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Register user = new Register();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                user.setGender(resultSet.getString("gender"));
                user.setMobileNumber(resultSet.getString("mobile_number"));
                user.setAboutMe(resultSet.getString("about_me"));
                user.setAddress(resultSet.getString("address"));
                user.setProfilePic(resultSet.getString("profile_pic"));
                users.add(user);
            }
        }
        
        return users;
    }
}
