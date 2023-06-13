package com.example.dao;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void signup(Employee employee);
    public boolean signin(String emp_Email, String emp_Password);
    public Employee getDataById(int emp_id);
    public List<Employee> getDataByName(String emp_name);
    public Employee getDataByNumber(long emp_Number);
    public Employee getDataByEmail(String emp_Email);
    public List<Employee> getAlldata();
    public List<Employee> getDataByUsingAnyInput(Employee employee);
    public void updateData (int emp_id,Employee employee);
    public List<Employee> sortByName();
    public List<Employee> sortBySalary();
    public List<Employee> sortByDOB();
    public List<Employee> sortById();
    public List<Employee> filterById(int emp_Id);
    public List<Employee> filterDataBySalary(double emp_Salary);
    public void deleteDatabtId(int emp_id);
    public void deleteAllData();

}
