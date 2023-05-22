package com.example.dao;

import java.util.List;

import com.example.model.Customer;

public interface CustomerDao {
	
	public void signup(Customer customer);
	
	public boolean signin(String custEmailId , String custPassword);
	
	public List<Customer> getAllData();
	
	

}
