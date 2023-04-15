package com.example.service;

import java.util.List;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	CustomerDao customerDaoImpl = new CustomerDaoImpl();
	

	@Override
	public void signUp(Customer custumer) {
		// TODO Auto-generated method stub
		customerDaoImpl.signUp(custumer);
		
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		return customerDaoImpl.signIn(custEmailId, custPassword);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDaoImpl.findAll();
	}

}
