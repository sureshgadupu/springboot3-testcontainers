package dev.fullstackcode.eis.springboot.devcontainers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcConnectionDetails;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
public class BaseIT {
    @Autowired
    protected TestRestTemplate testRestTemplate ;

    @Container
    @ServiceConnection(type = JdbcConnectionDetails.class)
    public static PostgreSQLContainer<?> postgresDB = new PostgreSQLContainer<>("postgres:13.2");

//    @DynamicPropertySource
//    public static void properties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url",postgresDB::getJdbcUrl);
//        registry.add("spring.datasource.username", postgresDB::getUsername);
//        registry.add("spring.datasource.password", postgresDB::getPassword);
//
//    }
}
