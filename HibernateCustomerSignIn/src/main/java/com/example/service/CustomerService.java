package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
	public void signUP(Customer customer);
	public boolean signIn(String custEmailId, String custPassword);
	public List<Customer> getAllData();
}
