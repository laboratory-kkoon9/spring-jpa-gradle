package com.laboratorykkoon9.springjpa.lab.repository;

import com.laboratorykkoon9.springjpa.config.TestJPAQueryFactoryConfig;
import com.laboratorykkoon9.springjpa.lab.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@Import({TestJPAQueryFactoryConfig.class})
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    private static final String LOGIN_ID = "eric@gmail.com";

    @BeforeEach
    void init() {
        customer = customerRepository.save(
                Customer.builder()
                        .loginId(LOGIN_ID)
                        .build()
        );
    }

    @Test
    @DisplayName("LoginId로 고객의 정보를 찾는다.")
    void findByLoginId_test1() {
        // when
        Customer givenCustomer = customerRepository.findByLoginId(LOGIN_ID).get();

        // then
        assertAll(
                () -> assertThat(givenCustomer.getId()).isEqualTo(customer.getId()),
                () -> assertThat(givenCustomer.getLoginId()).isEqualTo(customer.getLoginId())
        );
    }

    @Test
    @DisplayName("없는 LoginId로 고객의 정보를 찾으면 빈 Optional 객체를 리턴한다.")
    void findByLoginId_test2() {
        // given
        String nonExistLoginId = "nonExistLoginId";
        // when
        Optional<Customer> givenCustomer = customerRepository.findByLoginId(nonExistLoginId);

        // then
        assertThat(givenCustomer.isPresent()).isFalse();
    }
}
