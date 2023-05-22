package com.example.service;

import java.util.List;
import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	CustomerDao customerDaoImpl = new CustomerDaoImpl();

	@Override
	public void signup(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.signup(customer);
		
	}

	@Override
	public boolean signin(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		return customerDaoImpl.signin(custEmailId, custPassword);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerDaoImpl.getAllData();
	}

}
