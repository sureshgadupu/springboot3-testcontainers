package dev.fullstackcode.eis.springboot.devcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

//@SpringBootTest
class ApplicationLocalDevelopment extends BaseIT{

	public static void main(String args[]) {
		System.out.println("running inside the test `main` method.");
		SpringApplication.from(Application::main).run(args);
	}

}

