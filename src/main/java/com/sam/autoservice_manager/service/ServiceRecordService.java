package com.sam.autoservice_manager.service;


import com.sam.autoservice_manager.dto.CreateServiceRecordRequest;
import com.sam.autoservice_manager.entity.ServiceRecord;
import com.sam.autoservice_manager.entity.Vehicle;
import com.sam.autoservice_manager.repository.ServiceRecordRepository;
import com.sam.autoservice_manager.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceRecordService {

    private final ServiceRecordRepository serviceRecordRepository;
    private final VehicleRepository vehicleRepository;

    public ServiceRecordService(
            ServiceRecordRepository serviceRecordRepository,
            VehicleRepository vehicleRepository) {

        this.serviceRecordRepository = serviceRecordRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public ServiceRecord create(CreateServiceRecordRequest request) {

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        ServiceRecord record = new ServiceRecord();

        record.setServiceDate(
                LocalDate.parse(request.getServiceDate())
        );

        record.setDescription(request.getDescription());

        record.setPrice(
                BigDecimal.valueOf(request.getPrice())
        );

        record.setVehicle(vehicle);

        return serviceRecordRepository.save(record);
    }

    public List<ServiceRecord> getAll() {
        return serviceRecordRepository.findAll();
    }
}
