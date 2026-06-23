package com.sam.autoservice_manager.repository;


import com.sam.autoservice_manager.entity.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
}
