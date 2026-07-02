package com.sam.autoservice_manager.dto.response;

import java.time.LocalDateTime;

public class CustomerAppointmentResponse {
    private Long id;

    private LocalDateTime appointmentDate;

    private String status;

    private String brand;

    private String model;

    private String licensePlate;

    public CustomerAppointmentResponse() {
    }

    public CustomerAppointmentResponse(Long id, LocalDateTime appointmentDate, String status, String brand, String model, String licensePlate) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
