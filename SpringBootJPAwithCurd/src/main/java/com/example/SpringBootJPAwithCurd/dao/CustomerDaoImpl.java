package com.example.SpringBootJPAwithCurd.dao;

import com.example.SpringBootJPAwithCurd.model.Customer;
import com.example.SpringBootJPAwithCurd.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    public Customer saveData(Customer customer){
        return customerRepoImpl.save(customer);
    }
    public List<Customer> getAllData(){
        return customerRepoImpl.findAll();
    }
    public Customer updateData(Customer customer){
        return  customerRepoImpl.save(customer);
    }
    public  void  deletaData(int custId){
        customerRepoImpl.deleteById(custId);
    }
}
