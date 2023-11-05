package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.CalendarDAO;
import com.fssa.projectprovision.model.CalendarEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCalendarService {

    private CalendarService calendarService;
    private CalendarDAO calendarDAO;

    @BeforeEach
    public void setUp() {
        calendarService = new CalendarService(new FakeCalendarDAO());
    }

    @Test
    public void testAddCalendarEntry() {
        CalendarEntry entry = new CalendarEntry();
        entry.setUrl("https://example.com");
        entry.setUserId(1);

        boolean result = calendarService.addCalendarEntry(entry);

        assertTrue(result);
    }

    @Test
    public void testGetCalendarEntriesByUserId() {
        long userId = 1698122443181L;

        List<CalendarEntry> calendarEntries = calendarService.getCalendarEntriesByUserId(userId);

        assertTrue(calendarEntries != null && !calendarEntries.isEmpty());

        for (CalendarEntry entry : calendarEntries) {
            assertEquals(userId, entry.getUserId());
        }
    }

    private class FakeCalendarDAO extends CalendarDAO {
        private List<CalendarEntry> calendarEntries = new ArrayList<>();

        @Override
        public boolean insertCalendarEntry(CalendarEntry entry) {
            calendarEntries.add(entry);
            return true;
        }

        @Override
        public List<CalendarEntry> getCalendarEntriesByUserId(long userId) {
            List<CalendarEntry> result = new ArrayList<>();
            for (CalendarEntry entry : calendarEntries) {
                if (entry.getUserId() == userId) {
                    result.add(entry);
                }
            }
            return result;
        }
    }
}
