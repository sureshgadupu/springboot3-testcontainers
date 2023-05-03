package dev.fullstackcode.eis.springboot.devcontainers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
class TestConnectionsConfiguration {

//	@Bean
//	ApplicationRunner neo4jRunner(PetRepository repository) {
//		return args -> {
//			var fido = repository.save(new Pet(null, "Fido"));
//			System.out.println("fido:  " + fido);
//		};
//	}

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresDBContainer() {
        return new PostgreSQLContainer<>("postgres:13.2");
    }
}
