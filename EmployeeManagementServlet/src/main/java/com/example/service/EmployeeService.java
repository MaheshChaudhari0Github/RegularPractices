package com.example.service;

import com.example.model.Employee;

public interface EmployeeService {

	public void signUp(Employee employee);

	public boolean signIn(String empEmailId, String empPassword);
}
