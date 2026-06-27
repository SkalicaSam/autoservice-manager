package com.sam.autoservice_manager.service;

import com.sam.autoservice_manager.dto.AppointmentResponse;
import com.sam.autoservice_manager.dto.CreateVehicleRequest;
import com.sam.autoservice_manager.dto.ServiceRecordResponse;
import com.sam.autoservice_manager.dto.VehicleDetailResponse;
import com.sam.autoservice_manager.entity.Appointment;
import com.sam.autoservice_manager.entity.Customer;
import com.sam.autoservice_manager.entity.Vehicle;
import com.sam.autoservice_manager.repository.CustomerRepository;
import com.sam.autoservice_manager.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    public VehicleService(
            VehicleRepository vehicleRepository,
            CustomerRepository customerRepository) {

        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }

    public Vehicle createVehicle(CreateVehicleRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Vehicle vehicle = new Vehicle();

        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setLicensePlate(request.getLicensePlate());
        vehicle.setCustomer(customer);

        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public VehicleDetailResponse getVehicleDetailByVehicleId(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        List<AppointmentResponse> appointmentResponses =
                vehicle.getAppointments()
                        .stream()
                        .map(a -> new AppointmentResponse(
                                a.getId(),
                                a.getAppointmentDate(),
                                a.getStatus(),
                                a.getNote()
                        ))
                        .toList();

        List<ServiceRecordResponse> serviceResponses =
                vehicle.getServiceRecords()
                        .stream()
                        .map(s -> new ServiceRecordResponse(
                                s.getId(),
                                s.getServiceDate(),
                                s.getDescription(),
                                s.getPrice()
                        ))
                        .toList();


        return new VehicleDetailResponse(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getLicensePlate(),
                appointmentResponses,
                serviceResponses
        );
    }
}
