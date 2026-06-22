package com.sam.autoservice_manager.service;

import com.sam.autoservice_manager.dto.CreateVehicleRequest;
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
}
