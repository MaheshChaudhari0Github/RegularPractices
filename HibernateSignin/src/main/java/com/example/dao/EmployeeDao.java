package com.example.dao;

import com.example.model.Employee;

public interface EmployeeDao {
	
	public void signup(Employee employee);
	
	public boolean signin(String empEmailId, String empPassword);
	

}
