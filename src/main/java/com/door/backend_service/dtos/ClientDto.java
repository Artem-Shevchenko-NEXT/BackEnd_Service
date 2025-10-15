package com.door.backend_service.dtos;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for Client entity.
 * DTOs are used to transfer data between the API layer and clients.
 * This separates the internal entity representation from the external API contract,
 * providing better control over what data is exposed and received.
 */
public class ClientDto {

    private Long clientId;
    private String clientName;
    private String phone;
    private Integer cases;
    private LocalDateTime createdDate;

    // Default constructor - required for JSON deserialization
    public ClientDto() {
    }

    // Full constructor - useful for creating DTOs programmatically
    public ClientDto(Long clientId, String clientName, String phone, Integer cases, LocalDateTime createdDate) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.phone = phone;
        this.cases = cases;
        this.createdDate = createdDate;
    }

    // Getters and Setters - required for JSON serialization/deserialization
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}

