package com.example.service;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDaoImpl;

    @Override
    public void saveData(Employee employee) {
        employeeDaoImpl.saveData(employee);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    @Override
    public void updateData(int empId, Employee employee) {
        employeeDaoImpl.updateData(empId,employee);
    }

    @Override
    public void deleteData(int empId) {
        employeeDaoImpl.deleteData(empId);

    }
}
