package com.pearl.salon.model.book;

public class BookTimeSlotList {

    private String time;

    private boolean isSelected;

    public BookTimeSlotList(String time, boolean isSelected) {
        this.time = time;
        this.isSelected = isSelected;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
