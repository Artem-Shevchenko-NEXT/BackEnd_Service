package com.door.backend_service.dtos;

/**
 * Request DTO for creating a new client.
 * This is used when clients send POST requests to create new Client entities.
 * Separating request DTOs from entity DTOs allows for different validation rules
 * and prevents clients from setting fields that should be auto-generated (like ID or createdDate).
 */
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

