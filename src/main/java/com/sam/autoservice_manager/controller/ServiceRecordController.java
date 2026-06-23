package com.sam.autoservice_manager.controller;

import com.sam.autoservice_manager.dto.CreateServiceRecordRequest;
import com.sam.autoservice_manager.entity.ServiceRecord;
import com.sam.autoservice_manager.service.ServiceRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-records")
public class ServiceRecordController {

    private final ServiceRecordService serviceRecordService;

    public ServiceRecordController(ServiceRecordService serviceRecordService) {
        this.serviceRecordService = serviceRecordService;
    }

    @PostMapping
    public ServiceRecord create(
            @RequestBody CreateServiceRecordRequest request) {

        return serviceRecordService.create(request);
    }

    @GetMapping
    public List<ServiceRecord> getAll() {
        return serviceRecordService.getAll();
    }
}
