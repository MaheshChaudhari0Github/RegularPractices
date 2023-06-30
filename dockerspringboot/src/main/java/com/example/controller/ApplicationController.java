package com.example.controller;

import com.example.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
public class ApplicationController {

    @GetMapping
    public String sayHello(){
        return "WELCOME TO FINTECH CSI PUNE";
    }
   @GetMapping("/getalldata")
    public List<Customer> getallData(){
        return Stream.of(new Customer(121,"JAGS",5680),
                new Customer(122,"MSHD",4620),
                new Customer(123,"UGDW",1470),
                new Customer(124,"MSTX",4830)).collect(Collectors.toList());
    }

    @GetMapping("/filterdatabyaccountbalance/{custBalance}")
    public List<Customer> filterDataByAccBalance(@PathVariable double custBalance){
        return getallData().stream().filter(cust-> cust.getCustBalance()>= custBalance).collect(Collectors.toList());
    }
}
