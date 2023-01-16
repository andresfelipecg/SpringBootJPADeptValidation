package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaDeptValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDeptValidationApplication.class, args);
		System.out.println("Spring Boot JPA started");
	}

}
