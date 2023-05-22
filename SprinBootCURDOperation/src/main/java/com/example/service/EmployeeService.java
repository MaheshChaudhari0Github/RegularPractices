package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Employee;
@Service
public interface EmployeeService {
	
	public void saveData(Employee employee);

	public List<Employee> getAllData();
	
	public void updateData(int empid,Employee employee);
	
	public void deleteData(int empid);

}
