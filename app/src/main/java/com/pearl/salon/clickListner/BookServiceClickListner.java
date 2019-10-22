package com.pearl.salon.clickListner;

public interface BookServiceClickListner {

    void onPriceAdd(String name, int price);

    void onPriceChange(String name, int price);

    void onPriceDelete(String name, int price);

}
