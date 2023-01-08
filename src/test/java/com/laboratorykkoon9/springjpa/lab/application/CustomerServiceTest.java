package com.laboratorykkoon9.springjpa.lab.application;

import com.laboratorykkoon9.springjpa.lab.domain.Customer;
import com.laboratorykkoon9.springjpa.lab.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService customerService;

    private static final String LOGIN_ID = "eric@gmail.com";
    private static final Integer givenAge = 1;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    @DisplayName("해당 나이를 가진 고객들의 리스트를 리턴한다.")
    void getCustomersByAge_test1() {
        // given
        Customer customer = Customer.builder()
                .loginId(LOGIN_ID)
                .age(givenAge)
                .build();

        given(customerRepository.findByAge(any())).willReturn(List.of(customer));

        // when
        List<Customer> customers = customerService.getCustomersByAge(givenAge);

        // then
        assertAll(
                () -> assertThat(customers.size()).isEqualTo(1),
                () -> assertThat(customers.get(0).getLoginId()).isEqualTo(LOGIN_ID),
                () -> assertThat(customers.get(0).getAge()).isEqualTo(givenAge)
        );
    }
}
