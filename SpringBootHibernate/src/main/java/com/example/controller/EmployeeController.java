package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeServiceImpl;
	
	@PostMapping("/savedata")
	
	public String saveData(@RequestBody Employee employee)  {
		employeeServiceImpl.saveData(employee);
		return "Data is Saved";
	}
	
	@GetMapping("/getalldata")
	public List<Employee> getAllData(){
		return employeeServiceImpl.getAllData();
	}
}