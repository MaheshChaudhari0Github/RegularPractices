package com.example.service;

import java.util.List;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService
{

	CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public void signUP(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.signUP(customer);
		
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		return customerDao.signIn(custEmailId, custPassword);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerDao.getAllData();
	}

}
