package com.fssa.projectprovision.model;

public class CalendarEntry {
    private int id;
    private String url;  
    private long userId; 

    public CalendarEntry() {
     
    }

    public CalendarEntry(int id, String url, long userId) {
        this.id = id;
        this.url = url;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CalendarEntry{" +
                "id=" + id +
                ", url=" + url +
                ", userId=" + userId +
                '}';
    }
}
