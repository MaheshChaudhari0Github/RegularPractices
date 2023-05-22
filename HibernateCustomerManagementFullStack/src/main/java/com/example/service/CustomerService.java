package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
	
public void signup(Customer customer);
	
	public boolean signin(String custEmailId , String custPassword);
	
	public List<Customer> getAllData();

}
