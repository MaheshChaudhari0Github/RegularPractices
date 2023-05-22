package com.example.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.controller")

public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreApplication.class, args);
		
	}
}