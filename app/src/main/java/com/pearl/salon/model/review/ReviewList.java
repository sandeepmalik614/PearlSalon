package com.pearl.salon.model.review;

public class ReviewList {

    private String username;

    private String image;

    private String time;

    private String comment;

    private long star;

    public ReviewList(String username, String image, String time, String comment, long star) {
        this.username = username;
        this.image = image;
        this.time = time;
        this.comment = comment;
        this.star = star;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getStar() {
        return star;
    }

    public void setStar(long star) {
        this.star = star;
    }
}
