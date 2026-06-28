package com.sam.autoservice_manager.service;


import com.sam.autoservice_manager.dto.CreateAppointmentRequest;
import com.sam.autoservice_manager.entity.Appointment;
import com.sam.autoservice_manager.entity.Vehicle;
import com.sam.autoservice_manager.repository.AppointmentRepository;
import com.sam.autoservice_manager.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final VehicleRepository vehicleRepository;

    public AppointmentService(
            AppointmentRepository appointmentRepository,
            VehicleRepository vehicleRepository) {

        this.appointmentRepository = appointmentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Appointment create(CreateAppointmentRequest request) {

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(
                LocalDateTime.parse(request.getAppointmentDate())
        );

        appointment.setStatus(request.getStatus());
        appointment.setNote(request.getNote());
        appointment.setVehicle(vehicle);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Appointment updateStatus(Long id, String status) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(status);

        return appointmentRepository.save(appointment);
    }
}
