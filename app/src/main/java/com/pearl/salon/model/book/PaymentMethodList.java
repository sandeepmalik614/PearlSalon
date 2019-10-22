package com.pearl.salon.model.book;

public class PaymentMethodList {

    private String name;

    private String endWith;

    private int drawable;

    private boolean isSelected;

    public PaymentMethodList(String name, String endWith, int drawable, boolean isSelected) {
        this.name = name;
        this.endWith = endWith;
        this.drawable = drawable;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndWith() {
        return endWith;
    }

    public void setEndWith(String endWith) {
        this.endWith = endWith;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
