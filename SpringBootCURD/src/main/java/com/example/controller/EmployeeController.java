package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/saved")
    public String saveData(@RequestBody Employee employee){
        employeeServiceImpl.saveData(employee);
        return "Data Save Successfully";
    }
    @GetMapping("/getalldata")
    public List<Employee> getAllData(){
        return employeeServiceImpl.getAllData();
    }

    @PutMapping("/update/{empId}")
    public String updateData(@PathVariable int empId, @RequestBody Employee employee){
        employeeServiceImpl.updateData(empId,employee);
        return "Data Updated SuccessFully";
    }

    @DeleteMapping("/deletedata/{empId}")
    public String deletedata(@PathVariable  int empId){
        employeeServiceImpl.deleteData(empId);
        return "Delete Data SuccessFully";

    }
}
