package com.example.service;

import com.example.model.Employee;

public interface EmployeeService {
	
public void signup(Employee employee);
	
	public boolean signin(String empEmailId, String empPassword);

}
