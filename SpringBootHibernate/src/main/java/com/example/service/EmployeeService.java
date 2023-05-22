package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllData();
	public void saveData(Employee employee); 

}
