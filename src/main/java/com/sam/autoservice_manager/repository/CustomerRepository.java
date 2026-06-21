package com.sam.autoservice_manager.repository;

import com.sam.autoservice_manager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
