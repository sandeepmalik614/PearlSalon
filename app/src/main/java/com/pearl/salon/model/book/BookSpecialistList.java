package com.pearl.salon.model.book;

public class BookSpecialistList {

    private String name;

    private String image;

    private boolean isSelected;

    public BookSpecialistList(String name, String image, boolean isSelected) {
        this.name = name;
        this.image = image;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
