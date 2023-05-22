package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDao {
	
	public void saveData(Employee employee);

	public List<Employee> getAllData();
	
	public void updateData(int empid,Employee employee);
	
	public void deleteData(int empid);
}
