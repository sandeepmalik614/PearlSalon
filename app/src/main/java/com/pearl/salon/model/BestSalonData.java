package com.pearl.salon.model;

public class BestSalonData {

    private String title;

    private String rating;

    private String address;

    private boolean isAdd;

    public BestSalonData(String title, String rating, String address, boolean isAdd) {
        this.title = title;
        this.rating = rating;
        this.address = address;
        this.isAdd = isAdd;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
