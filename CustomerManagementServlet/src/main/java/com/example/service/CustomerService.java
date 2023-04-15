package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
	
	public void signUp(Customer costumer);

	public boolean signIn(String custEmailId, String custPassword);

	public List<Customer>findAll();

}