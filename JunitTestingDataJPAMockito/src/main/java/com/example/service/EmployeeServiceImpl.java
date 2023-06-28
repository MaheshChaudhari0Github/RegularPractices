package com.example.service;

import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee saveData(Employee employee){
        return employeeDaoImpl.saveData(employee);
    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public Employee updateData(Employee employee){
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteData(int empId){
        employeeDaoImpl.deleteData(empId);
    }
}
