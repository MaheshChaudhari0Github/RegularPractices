package com.example.dao;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {
    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee signup(Employee employee){
        return employeeRepoImpl.save(employee);
    }
    public boolean signin(String empEmail, String empPassword){
        boolean flag = false;
        for (Employee employee:employeeRepoImpl.findAll()) {
            if(employee.getEmpEmail().equals(empEmail) && employee.getEmpPassword().equals(empPassword)){
                flag=true;
            }
        }
        return flag;
    }

    public Optional<Employee> getDataById(int empId){
        return employeeRepoImpl.findById(empId);
    }

//    public List<Employee> getDataByName(String empName){
//        return employeeRepoImpl.findByEmpName(empName);
//    }

//    public Employee getDataByNumber(long empNumber){
//        return employeeRepoImpl.findByNumber(empNumber);
//    }

//    public Employee getDataByEmpEmail(String empEmail){
//        return employeeRepoImpl.findByEmail(empEmail);
//    }

    public List<Employee> getDataByAnyInput(String input){
        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee: employeeRepoImpl.findAll()) {
            // name, number, email, id

            if(String.valueOf(employee.getEmpId()).equals(input)  ||
            employee.getEmpName().equals(input)  ||
            employee.getEmpEmail().equals(input)   ||
            String.valueOf(employee.getEmpNumber()).equals(input)){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
    public List<Employee> getAllData(){
        return employeeRepoImpl.findAll();
    }

    public List<Employee> sortByName(){
        return employeeRepoImpl.findAll().stream().sorted((e1,e2)-> e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }

    public List<Employee> sortById(){
        return  employeeRepoImpl.findAll().stream().sorted(Comparator.comparingLong(Employee::getEmpId)).collect(Collectors.toList());
    }

    public List<Employee> sortBySalary(){
        return employeeRepoImpl.findAll().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
    }

    public List<Employee> sortByAge(){
        return employeeRepoImpl.findAll().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());
    }

    public List<Employee> sortByDOB(){
        return employeeRepoImpl.findAll().stream().sorted((e1,e2)->e1.getEmpDOB().compareTo(e2.getEmpDOB())).collect(Collectors.toList());
    }

    public List<Employee> filterDataBySalary(double empSalary){
        return employeeRepoImpl.findAll().stream().filter(emp -> emp.getEmpSalary()>=empSalary).collect(Collectors.toList());
    }

    public boolean loanisvalid(int empId){
        boolean flag = false;
        for (Employee employee: employeeRepoImpl.findAll()
             ) {
            if(employee.getEmpId()==empId && employee.getEmpSalary()>=5000){
                flag= true;
            }
        }
        return flag;
    }

    public Employee updateData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public void deleteDataById(int empId){
        employeeRepoImpl.deleteById(empId);
    }

    public void deleteAllData(){
        employeeRepoImpl.deleteAll();
    }
}
