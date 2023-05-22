package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {
	
	@GetMapping
	public String sayHii() {
		return "Welcomes";
	}
	@GetMapping("/services")
	public String sayServices() {
		return "Welcome Services";
	}
	@GetMapping("/addresss")
	public String sayAddress() {
		return "Welcome to Address";
	}
}
	

