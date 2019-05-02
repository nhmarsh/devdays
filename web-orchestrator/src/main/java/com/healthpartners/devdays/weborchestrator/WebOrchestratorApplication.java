package com.healthpartners.devdays.weborchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class WebOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebOrchestratorApplication.class, args);
	}

}
