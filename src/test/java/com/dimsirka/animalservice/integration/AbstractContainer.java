package com.dimsirka.animalservice.integration;

import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

@ActiveProfiles("test")
public class AbstractContainer {
    static PostgreSQLContainer postgreSQLContainer;

    static {
        postgreSQLContainer = new PostgreSQLContainer("postgres:12.2")
                .withPassword("postgres")
                .withUsername("postgres")
                .withDatabaseName("animal_db");
        postgreSQLContainer.start();

        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());
    }

}
