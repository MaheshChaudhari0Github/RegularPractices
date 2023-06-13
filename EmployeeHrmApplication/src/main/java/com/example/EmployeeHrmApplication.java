package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories("com.example.repo")
public class EmployeeHrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeHrmApplication.class, args);
	}

}
