package com.pearl.salon.model;

public class BestSalonData {

    private String title;

    private String rating;

    private String address;

    public BestSalonData(String title, String rating, String address) {
        this.title = title;
        this.rating = rating;
        this.address = address;
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
