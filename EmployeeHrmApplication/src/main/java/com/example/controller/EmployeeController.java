package com.example.controller;

import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.Optional;
import java.sql.PreparedStatement;
@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/singup")
    public ResponseEntity<Employee> signup(@RequestBody Employee employee){
        log.info("Trying to signup data"+employee.getEmpName());
        return ResponseEntity.ok(employeeServiceImpl.signup(employee));
    }

    @GetMapping("/signin/{empEmail}/{empPassword}")
    public ResponseEntity <Boolean> signin(@PathVariable String empEmail,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signin(empEmail,empPassword));
    }

    @Cacheable(value = "empId")
    @GetMapping("/getdatbyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

//    @GetMapping("/getdatabyname/{empName}")
//    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
//        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
//    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

//    @GetMapping("/getdatabynumber/{empNumber}")
//    public ResponseEntity<Employee> getDataByNumber(@PathVariable long empNumber){
//        return ResponseEntity.ok(employeeServiceImpl.getDataByNumber(empNumber));
//    }

//    @GetMapping("/getdatabyemail/{empEmail}")
//    public ResponseEntity<Employee> getDataByEmail(@PathVariable String empEmail){
//        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpEmail(empEmail));
//    }

    @GetMapping("/getdatabyanyinput/{input}")
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input){
        return ResponseEntity.ok(employeeServiceImpl.getDataByAnyInput(input));
    }

//    @GetMapping("/sortbyname")
//   public ResponseEntity<List<Employee>> sortbyname(@PathVariable String empName){
//        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
//    }

    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortById(){
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge(){
        return ResponseEntity.ok(employeeServiceImpl.sortByAge());
    }

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB(){
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary(){
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }

    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }

    @GetMapping("/loanisvalid/{empId}")
    public ResponseEntity<String> loanIsValid(@PathVariable int empId){
        String msg=null;
        if (employeeServiceImpl.loanisvalid(empId)){
            msg="Loan is Valid";
        }else {
            msg="Loan is Not Valid";
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId,@RequestBody Employee employee) throws RecordNotFoundException {
        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Id is not Valid"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpNumber(employee.getEmpNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmail(employee.getEmpEmail());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpSalary(employee.getEmpSalary());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok
                ("data Deleted Sucessfully");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All the data is deleted Successfully");
    }
}