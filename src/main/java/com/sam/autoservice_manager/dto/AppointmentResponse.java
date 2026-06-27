package com.sam.autoservice_manager.dto;

import java.time.LocalDateTime;

public class AppointmentResponse {
    private Long id;

    private LocalDateTime appointmentDate;

    private String status;

    private String note;

    public AppointmentResponse() {
    }

    public AppointmentResponse(Long id, LocalDateTime appointmentDate, String status, String note) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
