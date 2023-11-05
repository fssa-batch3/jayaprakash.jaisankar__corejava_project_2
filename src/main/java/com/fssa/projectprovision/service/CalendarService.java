package com.fssa.projectprovision.service;

import com.fssa.projectprovision.dao.CalendarDAO;
import com.fssa.projectprovision.model.CalendarEntry;

import java.util.List;

public class CalendarService {

    private CalendarDAO calendarDAO;

    public CalendarService() {
        this.calendarDAO = new CalendarDAO();
    }

    public CalendarService(CalendarDAO calendarDAO) {
        this.calendarDAO = calendarDAO;
    }

    public boolean addCalendarEntry(CalendarEntry entry) {
        return calendarDAO.insertCalendarEntry(entry);
    }

    public List<CalendarEntry> getCalendarEntriesByUserId(long userId) {
        return calendarDAO.getCalendarEntriesByUserId(userId);
    }
}
