package com.example.controller;

import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        log.info("Trying to Save Data Employee - "+employee.getEmpName());
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @GetMapping("/getdatabynumber/{empNumber}")
    public ResponseEntity <Employee> getDataByContactNumber(@PathVariable long empNumber){
        return ResponseEntity.ok(employeeServiceImpl.getDataByNumber(empNumber));
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData (@PathVariable long empId, @RequestBody Employee employee)  {
        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(()->  new RecordNotFoundException("Employee Id Does Not Found"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpNumber(employee.getEmpNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteDataById (@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return  ResponseEntity.ok("Data Deleted");
    }
    @GetMapping("/getdata")
    public ResponseEntity<List<Employee>> getData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
}
