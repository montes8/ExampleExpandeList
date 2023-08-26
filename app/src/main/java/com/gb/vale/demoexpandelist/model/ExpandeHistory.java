package com.gb.vale.demoexpandelist.model;

public class ExpandeHistory {

    private String dateHistory;
    private String description;

    public ExpandeHistory(String dateHistory, String description) {
        this.dateHistory = dateHistory;
        this.description = description;
    }

    public String getDateHistory() {
        return dateHistory;
    }

    public void setDateHistory(String dateHistory) {
        this.dateHistory = dateHistory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExpandeHistory{" +
                "dateHistory='" + dateHistory + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
