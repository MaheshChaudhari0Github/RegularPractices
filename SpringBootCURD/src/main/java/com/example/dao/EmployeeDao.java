package com.example.dao;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void saveData(Employee employee);

    public List<Employee> getAllData();

    public void updateData(int empId, Employee employee);

    public void deleteData(int empId);
}
