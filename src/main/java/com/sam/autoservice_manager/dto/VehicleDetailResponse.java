package com.sam.autoservice_manager.dto;
import java.util.List;
import com.sam.autoservice_manager.dto.AppointmentResponse;
import com.sam.autoservice_manager.dto.ServiceRecordResponse;




public class VehicleDetailResponse {


    private Long id;

    private String brand;

    private String model;

    private String licensePlate;

    private List<AppointmentResponse> appointments;

    private List<ServiceRecordResponse> serviceRecords;

    public VehicleDetailResponse() {
    }

    public VehicleDetailResponse(Long id, String brand, String model, String licensePlate, List<AppointmentResponse> appointments, List<ServiceRecordResponse> serviceRecords) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.appointments = appointments;
        this.serviceRecords = serviceRecords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<AppointmentResponse> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentResponse> appointments) {
        this.appointments = appointments;
    }

    public List<ServiceRecordResponse> getServiceRecords() {
        return serviceRecords;
    }

    public void setServiceRecords(List<ServiceRecordResponse> serviceRecords) {
        this.serviceRecords = serviceRecords;
    }
}
