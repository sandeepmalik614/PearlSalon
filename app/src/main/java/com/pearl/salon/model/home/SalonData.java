package com.pearl.salon.model.home;

public class SalonData {

    private String title;

    private String rating;

    private String address;

    private boolean isAdd;

    private String image;

    public SalonData(String title, String rating, String address, boolean isAdd, String image) {
        this.title = title;
        this.rating = rating;
        this.address = address;
        this.isAdd = isAdd;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
