package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.model.CalendarEntry;


import com.fssa.projectprovision.utils.ConnectionUtil;
import com.fssa.projectprovision.exception.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CalendarDAO {

    public boolean insertCalendarEntry(CalendarEntry entry)  {
        String query = "INSERT INTO calender (url, userid) VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, entry.getUrl()); 
            pst.setLong(2, entry.getUserId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } 
        catch (SQLException e) {
            handleSQLException(e);
            return false; 
        }
    }

    public List<CalendarEntry> getCalendarEntriesByUserId(long userId) {
        List<CalendarEntry> calendarEntries = new ArrayList<>();
        String query = "SELECT * FROM calender WHERE userid = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, userId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    CalendarEntry entry = buildCalendarEntryFromResultSet(rs);
                    calendarEntries.add(entry);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return calendarEntries;
    }
  
    private CalendarEntry buildCalendarEntryFromResultSet(ResultSet rs) throws SQLException {
        CalendarEntry entry = new CalendarEntry();
        entry.setId(rs.getInt("id"));
        entry.setUrl(rs.getString("url")); 
        entry.setUserId(rs.getLong("userid")); 
        return entry;
    }

    private void handleSQLException(SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("An error occurred while accessing the database.", e);
    }
}
