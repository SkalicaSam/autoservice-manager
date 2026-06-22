package com.sam.autoservice_manager.repository;

import com.sam.autoservice_manager.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
