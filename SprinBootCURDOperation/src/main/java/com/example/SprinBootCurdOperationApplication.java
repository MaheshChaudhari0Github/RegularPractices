package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.service" })
public class SprinBootCurdOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinBootCurdOperationApplication.class, args);
	}

}
