package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllData();
	public void saveData(Employee employee); 

}
