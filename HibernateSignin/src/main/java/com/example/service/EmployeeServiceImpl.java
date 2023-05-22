package com.example.service;

import com.example.dao.EmployeeDaoImpl;
import com.example.dao.EmployeeDao;
import com.example.model.Employee;

public class EmployeeServiceImpl  implements EmployeeService{
	
	EmployeeDao employeeDoaImpl = new EmployeeDaoImpl();

	@Override
	public void signup(Employee employee) {
		// TODO Auto-generated method stub
		employeeDoaImpl.signup(employee);
	}

	@Override
	public boolean signin(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		
		return employeeDoaImpl.signin(empEmailId, empPassword);
	}

}
