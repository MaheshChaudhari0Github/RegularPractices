package com.example.dao;

import java.util.List;

import com.example.model.Customer;

public interface CustomerDao {

	public void signUp(Customer customer);
	
	public boolean signIn(String custEmailId,String custPassword);
	
	public void updateData(int custId,Customer customer);
	
	public void deleteDataById(int custId);
	
	public List<Customer> getAllData();
	
	public Customer getDataById(int custId);
	
}
