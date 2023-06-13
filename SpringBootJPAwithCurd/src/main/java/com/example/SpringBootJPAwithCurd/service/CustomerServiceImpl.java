package com.example.SpringBootJPAwithCurd.service;

import com.example.SpringBootJPAwithCurd.dao.CustomerDaoImpl;
import com.example.SpringBootJPAwithCurd.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {
    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public Customer saveData(Customer customer) {
        return customerDaoImpl.saveData(customer);
    }

    public List<Customer> getAllData() {
        return customerDaoImpl.getAllData();
    }

    public Customer updateData(Customer customer) {
        return customerDaoImpl.updateData(customer);
    }

    public void deletaData(int custId) {
        customerDaoImpl.deletaData(custId);
    }
}
