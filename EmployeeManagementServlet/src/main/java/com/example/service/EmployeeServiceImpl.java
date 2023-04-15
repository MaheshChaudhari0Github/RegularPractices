package com.example.service;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
	
	

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.signUp(employee);
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.signIn(empEmailId, empPassword);
	}

}
