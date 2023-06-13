package com.example.service;

import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signup(Employee employee){
        return employeeDaoImpl.signup(employee);
    }
    public boolean signin(String empEmail, String empPassword){
        return employeeDaoImpl.signin(empEmail,empPassword);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeDaoImpl.getDataById(empId);
    }

//    public List<Employee> getDataByName(String empName){
//        return employeeDaoImpl.getDataByName(empName);
//    }

//    public Employee getDataByNumber(long empNumber){
//        return employeeDaoImpl.getDataByNumber(empNumber);
//    }

//    public Employee getDataByEmpEmail(String empEmail){
//        return employeeDaoImpl.getDataByEmpEmail(empEmail);
//    }

    public List<Employee> getDataByAnyInput(String input){
        return employeeDaoImpl.getDataByAnyInput(input);
    }
    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public List<Employee> sortByName(){
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortById(){
        return  employeeDaoImpl.sortById();
    }

    public List<Employee> sortBySalary(){
        return employeeDaoImpl.sortBySalary();
    }

    public List<Employee> sortByAge(){
        return employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByDOB(){
        return employeeDaoImpl.sortByDOB();
    }

    public List<Employee> filterDataBySalary(double empSalary){
        return employeeDaoImpl.filterDataBySalary(empSalary);
    }

    public boolean loanisvalid(int empId){
        return employeeDaoImpl.loanisvalid(empId);
    }

    public Employee updateData(Employee employee){
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId){
        employeeDaoImpl.deleteDataById(empId);
    }

    public void deleteAllData(){
        employeeDaoImpl.deleteAllData();
    }
}
