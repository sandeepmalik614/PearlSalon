package com.pearl.salon.model.service;

public class ServicePackageList {

    private String offerName;
    private String offerDesc;
    private String offerPrice;
    private String offerImage;

    public ServicePackageList(String offerName, String offerDesc, String offerPrice, String offerImage) {
        this.offerName = offerName;
        this.offerDesc = offerDesc;
        this.offerPrice = offerPrice;
        this.offerImage = offerImage;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferDesc() {
        return offerDesc;
    }

    public void setOfferDesc(String offerDesc) {
        this.offerDesc = offerDesc;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }
}
