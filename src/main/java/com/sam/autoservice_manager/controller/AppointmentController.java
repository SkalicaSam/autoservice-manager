package com.sam.autoservice_manager.controller;

import com.sam.autoservice_manager.dto.AppointmentStatusUpdateRequest;
import com.sam.autoservice_manager.dto.CreateAppointmentRequest;
import com.sam.autoservice_manager.entity.Appointment;
import com.sam.autoservice_manager.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment create(
            @RequestBody CreateAppointmentRequest request) {

        return appointmentService.create(request);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAll();
    }

    @PatchMapping("/{id}/status")
    public Appointment updateStatus(
            @PathVariable Long id,
            @RequestBody AppointmentStatusUpdateRequest request) {
        return appointmentService.updateStatus(id, request.getStatus());
    }

}
