package com.example.service;

import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;
    public Employee saveData(Employee employee){
        return  employeeDaoImpl.saveData(employee);
    }
    public Optional<Employee> getDataById(long empId){
        return employeeDaoImpl.getDataById(empId);
    }
    public List<Employee> getDataByName(String empName){
        return employeeDaoImpl.getDataByName(empName);
    }
    public Employee getDataByNumber(long empNumber){
        return employeeDaoImpl.getDataByNumber(empNumber);
    }
    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }
    public Employee updateData (Employee employee){
        return employeeDaoImpl.updateData(employee);
    }
    public void deleteDataById(long empId){
        employeeDaoImpl.deleteDataById(empId);
    }
}
