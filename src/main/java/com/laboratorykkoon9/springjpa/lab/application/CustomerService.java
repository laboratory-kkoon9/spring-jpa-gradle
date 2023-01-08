package com.laboratorykkoon9.springjpa.lab.application;

import com.laboratorykkoon9.springjpa.lab.domain.Customer;
import com.laboratorykkoon9.springjpa.lab.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public boolean checkLoginId(final String loginId) {
        Optional<Customer> customer = customerRepository.findByLoginId(loginId);
        return customer.isPresent();
    }

    @Transactional
    public List<Customer> getCustomersByAge(final Integer age) {
        List<Customer> customers = customerRepository.findByAge(age);
        return customers;
    }
}
