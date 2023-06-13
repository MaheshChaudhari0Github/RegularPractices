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
    public void signup(Employee employee) {
        employeeDaoImpl.signup(employee);
    }

    @Override
    public boolean signin(String emp_Email, String emp_Password) {
        return employeeDaoImpl.signin(emp_Email,emp_Password);
    }

    @Override
    public Employee getDataById(int emp_id) {
        return employeeDaoImpl.getDataById(emp_id);
    }

    @Override
    public List<Employee> getDataByName(String emp_name) {
        return employeeDaoImpl.getDataByName(emp_name);
    }

    @Override
    public Employee getDataByNumber(long emp_Number) {
        return employeeDaoImpl.getDataByNumber(emp_Number);
    }

    @Override
    public Employee getDataByEmail(String emp_Email) {
        return employeeDaoImpl.getDataByEmail(emp_Email);
    }

    @Override
    public List<Employee> getAlldata() {
        return employeeDaoImpl.getAlldata();
    }

    @Override
    public List<Employee> getDataByUsingAnyInput(Employee employee) {
        return employeeDaoImpl.getDataByUsingAnyInput(employee);
    }

    @Override
    public void updateData(int emp_id, Employee employee) {
        employeeDaoImpl.updateData(emp_id,employee);
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    @Override
    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    @Override
    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    @Override
    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    @Override
    public List<Employee> filterById(int emp_Id) {
        return employeeDaoImpl.filterById(emp_Id);
    }

    @Override
    public List<Employee> filterDataBySalary(double emp_Salary) {
        return employeeDaoImpl.filterDataBySalary(emp_Salary);
    }


    @Override
    public void deleteDatabtId(int emp_id) {
        employeeDaoImpl.deleteDatabtId(emp_id);
    }

    @Override
    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();

    }
}
