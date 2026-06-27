package com.sam.autoservice_manager.dto;

import com.sam.autoservice_manager.entity.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ServiceRecordResponse {
    private Long id;

    private LocalDate serviceDate;

    private String description;

    private BigDecimal price;

    public ServiceRecordResponse() {
    }

    public ServiceRecordResponse(Long id, LocalDate serviceDate, String description, BigDecimal price) {
        this.id = id;
        this.serviceDate = serviceDate;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
