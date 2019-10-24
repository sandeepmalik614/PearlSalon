package com.pearl.salon.model.inbox;

public class InboxList {

    private String username;

    private String message;

    private int unread;

    private String image;

    private String time;

    public InboxList(String username, String message, int unread, String image, String time) {
        this.username = username;
        this.message = message;
        this.unread = unread;
        this.image = image;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
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
}
