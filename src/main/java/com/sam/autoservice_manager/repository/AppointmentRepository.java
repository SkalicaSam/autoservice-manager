package com.sam.autoservice_manager.repository;


import com.sam.autoservice_manager.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
