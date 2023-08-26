package com.gb.vale.demoexpandelist.model;

import java.util.List;

public class ParentMedic {

    private String nameClinic;
    private String address;

    private boolean selected;

    private List<ExpandeHistory> listHistory;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ParentMedic(String nameClinic, String address, List<ExpandeHistory> listHistory) {
        this.nameClinic = nameClinic;
        this.address = address;
        this.listHistory = listHistory;
        this.selected = false;
    }

    public List<ExpandeHistory> getListHistory() {
        return listHistory;
    }

    public void setListHistory(List<ExpandeHistory> listHistory) {
        this.listHistory = listHistory;
    }

    public String getNameClinic() {
        return nameClinic;
    }

    public void setNameClinic(String nameClinic) {
        this.nameClinic = nameClinic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
