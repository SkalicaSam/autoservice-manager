package com.sam.autoservice_manager.service;


import com.sam.autoservice_manager.dto.VehicleResponse;
import com.sam.autoservice_manager.dto.response.CustomerAppointmentResponse;
import com.sam.autoservice_manager.entity.Customer;
import com.sam.autoservice_manager.entity.Vehicle;
import com.sam.autoservice_manager.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<VehicleResponse> getVehiclesByCustomerId(Long id) {
        Customer customer = getCustomerById(id);

        return customer.getVehicles().stream()
                .map(vehicle -> new VehicleResponse(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getLicensePlate()))
                .toList();
    }

    public List<CustomerAppointmentResponse> getAppointmentsByCustomerId(Long id) {
        Customer customer = getCustomerById(id);

        return customer.getVehicles()
                .stream()
                .flatMap(vehicle -> vehicle.getAppointments().stream())
                .map(appointment -> new CustomerAppointmentResponse(
                        appointment.getId(),
                        appointment.getAppointmentDate(),
                        appointment.getStatus(),
                        appointment.getVehicle().getBrand(),
                        appointment.getVehicle().getModel(),
                        appointment.getVehicle().getLicensePlate()
                ))
                .toList();

    }
}