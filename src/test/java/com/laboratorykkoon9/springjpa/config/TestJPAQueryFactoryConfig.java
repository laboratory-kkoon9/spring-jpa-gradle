package com.laboratorykkoon9.springjpa.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * JPAQueryFacotry가 필요할 경우 @Import 하여 사용한다.
 */
@TestConfiguration
public class TestJPAQueryFactoryConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
