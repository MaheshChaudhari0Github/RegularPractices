package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {
	@GetMapping
	public String sayHi() {
		return "Welcome to Anudip Foundation";
	}
	
	@GetMapping("/services")
	public String sayServices() {
		return "Software Services";
	}
	
	@GetMapping("/address")
	public String sayAddress() {
		return "Pune";
	}
}
