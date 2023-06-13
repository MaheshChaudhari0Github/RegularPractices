package com.example.dao;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {
    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData(Employee employee){
        return  employeeRepoImpl.save(employee);
    }
    public Optional<Employee> getDataById(long empId){
        return employeeRepoImpl.findById(empId);
    }
    public List<Employee> getDataByName(String empName){
        return employeeRepoImpl.findByEmpName(empName);
    }
    public Employee getDataByNumber(long empNumber){
        return employeeRepoImpl.findByEmpNumber(empNumber);
    }
    public List<Employee> getAllData(){
        return employeeRepoImpl.findAll();
    }
    public Employee updateData (Employee employee){
        return employeeRepoImpl.save(employee);
    }
     public void deleteDataById(long empId){
        employeeRepoImpl.deleteById(empId);
     }

}
