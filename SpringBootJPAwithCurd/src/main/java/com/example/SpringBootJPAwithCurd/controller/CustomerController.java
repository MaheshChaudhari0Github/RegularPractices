package com.example.SpringBootJPAwithCurd.controller;

import com.example.SpringBootJPAwithCurd.model.Customer;
import com.example.SpringBootJPAwithCurd.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

     @Autowired
    CustomerServiceImpl customerServiceImpl;

     @PostMapping("/savedata")
     public ResponseEntity<Customer> saveData(@RequestBody Customer customer){
         log.info("Saving Data for Customer"+ customer.getCustName());
         return ResponseEntity.ok(customerServiceImpl.saveData(customer));
     }

    @GetMapping("/getdata")
    public ResponseEntity<List<Customer>> getData(){
        log.info("List Size"+ customerServiceImpl.getAllData().size());
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }
    @PutMapping("/updateData/{custId}")
    public  ResponseEntity<Customer> updateData(@PathVariable int custId,@RequestBody Customer customer){

         return ResponseEntity.ok(customerServiceImpl.updateData(customer));
    }

    @DeleteMapping("/delete/{custId}")
    public ResponseEntity<String> deletedata(@PathVariable int custId){
         customerServiceImpl.deletaData(custId);
         return  ResponseEntity.ok("Data Deleted Sucessfully");
    }
}
