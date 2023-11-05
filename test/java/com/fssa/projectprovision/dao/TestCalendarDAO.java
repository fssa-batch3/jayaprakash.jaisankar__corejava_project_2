package com.fssa.projectprovision.dao;

import com.fssa.projectprovision.model.CalendarEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCalendarDAO {

    private CalendarDAO calendarDAO;

    @BeforeEach
    public void setUp() {
        calendarDAO = new CalendarDAO();
    }

    @Test
    public void testInsertCalendarEntry() {
        CalendarEntry entry = new CalendarEntry();
        entry.setUrl("https://example.com");
        entry.setUserId(1);

        boolean result = calendarDAO.insertCalendarEntry(entry);

        assertTrue(result);
    }

    @Test
    public void testGetCalendarEntriesByUserId() {
        long userId = 1;

        List<CalendarEntry> calendarEntries = calendarDAO.getCalendarEntriesByUserId(userId);

        assertTrue(calendarEntries != null && !calendarEntries.isEmpty());

        for (CalendarEntry entry : calendarEntries) {
            assertEquals(userId, entry.getUserId());
        }
    }
}
