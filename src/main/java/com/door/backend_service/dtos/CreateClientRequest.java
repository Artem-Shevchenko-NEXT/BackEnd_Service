package com.door.backend_service.dtos;


public class CreateClientRequest {

    private String clientName;
    private String phone;
    private Integer cases;

    // Default constructor
    public CreateClientRequest() {
    }

    // Full constructor
    public CreateClientRequest(String clientName, String phone, Integer cases) {
        this.clientName = clientName;
        this.phone = phone;
        this.cases = cases;
    }

    // Getters and Setters
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }
}

