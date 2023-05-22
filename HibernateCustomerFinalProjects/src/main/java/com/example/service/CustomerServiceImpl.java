package com.example.service;

import java.util.List;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	CustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.signUp(customer);
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		return customerDao.signIn(custEmailId, custPassword);
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateData(custId, customer);
	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub
		customerDao.deleteDataById(custId);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerDao.getAllData();
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		return customerDao.getDataById(custId);
	}
}