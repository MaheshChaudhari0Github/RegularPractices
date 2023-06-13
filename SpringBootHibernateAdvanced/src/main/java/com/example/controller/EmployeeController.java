package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl;


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Employee employee) {
        log.info("# Trying to save data Employee: " + employee.getEmp_Name());
        employeeServiceImpl.signup(employee);
        return ResponseEntity.ok("Employee SignUp Done Successfully");
    }

    @GetMapping("/signin/{emp_Email}/{emp_Password}")
    public ResponseEntity<Boolean> signin(@PathVariable String emp_Email, @PathVariable String emp_Password) {
        return ResponseEntity.ok(employeeServiceImpl.signin(emp_Email, emp_Password));
    }

    @GetMapping("/getdatabtid/{emp_id}")
    public ResponseEntity<Employee> getDataById(@PathVariable int emp_id) {
        return ResponseEntity.ok(employeeServiceImpl.getDataById(emp_id));
    }

    @GetMapping("/getdatabyname/{emp_Name}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String emp_Name) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(emp_Name));
    }

    @GetMapping("/getdatabynumber/{emp_Number}")
    public ResponseEntity<Employee> getDataByNumber(@PathVariable long emp_Number) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByNumber(emp_Number));
    }

    @GetMapping("/getdatabyemail/{emp_Email}")
    public ResponseEntity<Employee> getDataByEmail(@PathVariable String emp_Email) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmail(emp_Email));
    }

    @PutMapping("/updatedata/{emp_id}")
    public ResponseEntity<String> updateData(@PathVariable int emp_id, @RequestBody Employee employee) {
        employeeServiceImpl.updateData(emp_id, employee);
        return ResponseEntity.ok("Update Data SuccessFully");
    }

    @GetMapping("/sortname")
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    @GetMapping("/sortid")
    public ResponseEntity<List<Employee>> sortById() {
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/sortsalary")
    public ResponseEntity<List<Employee>> sortBySalary() {
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }

    @GetMapping("/sortdob")
    public ResponseEntity<List<Employee>> sortByDob() {
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }

    @GetMapping("/getdatabyanyinput/{employee}")//not working
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByUsingAnyInput(employee));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeServiceImpl.getAlldata());
    }

    @GetMapping("/filtersalary/{emp_Salary}")
    public ResponseEntity<List<Employee>> filterBySalary(@PathVariable double emp_Salary) {
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(emp_Salary));
    }

    @DeleteMapping("/deletebyid/{emp_id}")
    public ResponseEntity<String> deletedatabyid(@PathVariable int emp_id) {
        employeeServiceImpl.deleteDatabtId(emp_id);
        return ResponseEntity.ok(("Data Deleted Successfully"));
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData() {
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }

}
