package com.example.dao;

import java.util.List;

import com.example.model.Customer;

public interface CustomerDao {
	
	public void signUp(Customer customer);
	
	public boolean signIn(String custEmailId, String custPassword);
	
	public List<Customer> findAll();

}