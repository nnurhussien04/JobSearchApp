package com.example.employableApplication.employable_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EmployableBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployableBackendApplication.class, args);
	}

}
