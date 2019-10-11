package com.pearl.salon.model.service;

public class ServiceList {

    private String serviceName;
    private String serviceType;

    public ServiceList(String serviceName, String serviceType) {
        this.serviceName = serviceName;
        this.serviceType = serviceType;
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
