package com.fssa.projectprovision.service;



import java.util.List;

import com.fssa.projectprovision.dao.CalendarDAO;
import com.fssa.projectprovision.model.CalendarEntry;

public class CalendarService {

    private CalendarDAO calendarDAO;

    public CalendarService() {
        this.calendarDAO = new CalendarDAO();
    }

    public boolean addCalendarEntry(CalendarEntry entry) {
        return calendarDAO.insertCalendarEntry(entry);
    }
//
//    public CalendarEntry getCalendarEntryById(int id) {
//        return calendarDAO.getCalendarEntryById(id);
//    }

    public List<CalendarEntry> getCalendarEntriesByUserId(long userId) {
        return calendarDAO.getCalendarEntriesByUserId(userId);
    }

}
