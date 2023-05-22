package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
	
public void signup(Customer customer);
	
	public boolean signin(String custEmailId, String custPassword);
	
	public Customer getDataById(int custId);
	
	public List<Customer> getAllData();
	
	public void updateData(int custId, Customer customer);
	
	public void deleteDataById(int custId);
	
	public void deleteAllData();
	
	public List<Customer> sortByCustName();
	
	public List<Customer> sortByAccBalance();
	
	public List<Customer> sortByDob();
	
	public List<Customer> filterByName(String custName);
	
	public List<Customer> filterByAccBalance(double custAccBalance);

}
