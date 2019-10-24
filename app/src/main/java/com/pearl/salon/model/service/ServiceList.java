package com.pearl.salon.model.service;

public class ServiceList {

    private String serviceName;
    private String serviceType;
    private String image;

    public ServiceList(String serviceName, String serviceType, String image) {
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
