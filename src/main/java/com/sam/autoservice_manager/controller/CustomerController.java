package com.sam.autoservice_manager.controller;


import com.sam.autoservice_manager.dto.CreateVehicleRequest;
import com.sam.autoservice_manager.dto.VehicleResponse;
import com.sam.autoservice_manager.entity.Customer;
import com.sam.autoservice_manager.entity.Vehicle;
import com.sam.autoservice_manager.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/{id}/vehicles")
    public List<VehicleResponse> getVehiclesByCustomerId(@PathVariable Long id) {
        return customerService.getVehiclesByCustomerId(id);
    }
}
