package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity <Employee> saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }
    @GetMapping("/getalldata")
    public ResponseEntity <List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @PutMapping("/updatedata/{empId}")
    public  ResponseEntity <Employee> updateData(@PathVariable int empId,@RequestBody Employee employee){
        //
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee));
    }
    @DeleteMapping("/deletedata/{empId}")
    public ResponseEntity <String> deleteData(@PathVariable int empId){
    employeeServiceImpl.deleteData(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
