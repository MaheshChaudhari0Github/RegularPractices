package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.EmployeeDao;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDaoImpl;

	@Override
	public void saveData(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.saveData(employee);
		
	}

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getAllData();
	}

	@Override
	public void updateData(int empid, Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.updateData(empid, employee);
	}

	@Override
	public void deleteData(int empid) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteData(empid);
	}

}
