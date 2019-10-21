package com.pearl.salon.model.book;

import java.util.ArrayList;

public class BookHeadingList {

    private String heading;

    private ArrayList<BookServiceList> serviceList;

    public BookHeadingList(String heading, ArrayList<BookServiceList> serviceList) {
        this.heading = heading;
        this.serviceList = serviceList;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public ArrayList<BookServiceList> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<BookServiceList> serviceList) {
        this.serviceList = serviceList;
    }
}
