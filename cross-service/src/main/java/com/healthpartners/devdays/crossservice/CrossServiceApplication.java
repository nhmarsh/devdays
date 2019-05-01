package com.healthpartners.devdays.crossservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class CrossServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossServiceApplication.class, args);
	}

}
