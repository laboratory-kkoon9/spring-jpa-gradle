package com.laboratorykkoon9.springjpa.lab.repository;

import com.laboratorykkoon9.springjpa.lab.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByLoginId(String loginId);
}
