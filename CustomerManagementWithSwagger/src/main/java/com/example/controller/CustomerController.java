package com.example.controller;

import com.example.exception.RecordNotFoundException;
import com.example.model.Customer;
import com.example.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity <Customer> saveData(@RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }
    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Optional<Customer>> getDataById(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>> getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer> updateData(@PathVariable int custId,@RequestBody Customer customer) throws RecordNotFoundException {

       Customer customer1 = customerServiceImpl.getDataById(custId).orElseThrow(()-> new RecordNotFoundException("Customer Not Exist"));

       customer1.setCustName(customer.getCustName());
       customer1.setCustAddress(customer.getCustAddress());
       customer1.setCustNumber(customer.getCustNumber());
       customer1.setCustBalance(customer.getCustBalance());
       customer1.setCustDOB(customer.getCustDOB());

        return ResponseEntity.ok(customerServiceImpl.updateData(customer1));
    }
    @DeleteMapping("/deletedatabyid/{custId}")
    public  ResponseEntity<String> deleteDataById(@PathVariable int custId) {
        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("data Deleted Sucessfully");
    }

}
