package dev.fullstackcode.eis.springboot.devcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;


public class ApplicationLocalDevelopment2 {

	public static void main(String args[]) {
		SpringApplication.from(Application::main)
				.with(LocalDevConfig.class)
				.run(args);;
	}

	@TestConfiguration(proxyBeanMethods = false)
	@ImportTestcontainers(BaseIT.class)
	static class LocalDevConfig {

	}

}

