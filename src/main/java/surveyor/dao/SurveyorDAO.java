package surveyor.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import surveyor.service.exception.SurveyorServiceException;
import surveyor.model.Surveyor;
import surveyor.dao.exception.SurveyorDAOException;

public class SurveyorDAO {

    // Establish database connection
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/backend", "root", "123456");
        return connection;
    }

    // Create: Register a new surveyor
    public boolean register(Surveyor surveyor) throws SurveyorDAOException {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO surveyors (name, taluk, email) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setString(1, surveyor.getName());
            pst.setString(2, surveyor.getTaluk());
            pst.setString(3, surveyor.getEmail());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new SurveyorDAOException("Error registering surveyor", e);
        }
    }

    // Read: Get surveyor by email
    public Surveyor getSurveyorByEmail(String email) throws SurveyorDAOException {
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM surveyors WHERE email = ?";
            PreparedStatement pst = connection.prepareStatement(selectQuery);
            pst.setString(1, email);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String taluk = resultSet.getString("taluk");
                return new Surveyor(name, taluk, email);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new SurveyorDAOException("Error retrieving surveyor by email", e);
        }
    }

    // Update: Update surveyor information by email
    public boolean updateSurveyorByEmail(String name, String taluk, String email) throws SurveyorDAOException {
        try (Connection connection = getConnection()) {
            String updateQuery = "UPDATE surveyors SET name = ?, taluk = ? WHERE email = ?";
            PreparedStatement pst = connection.prepareStatement(updateQuery);
            pst.setString(1, name);
            pst.setString(2, taluk);
            pst.setString(3, email);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new SurveyorDAOException("Error updating surveyor information", e);
        }
    }

    // Delete: Delete surveyor by email
    public boolean deleteSurveyorByEmail(String email) throws SurveyorDAOException {
        try (Connection connection = getConnection()) {
            String deleteQuery = "DELETE FROM surveyors WHERE email = ?";
            PreparedStatement pst = connection.prepareStatement(deleteQuery);
            pst.setString(1, email);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new SurveyorDAOException("Error deleting surveyor", e);
        }
    }

}
