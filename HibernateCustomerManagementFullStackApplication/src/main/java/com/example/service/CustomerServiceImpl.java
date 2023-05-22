package com.example.service;

import java.util.List;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService {

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
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		return customerDaoImpl.getDataById(custId);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerDaoImpl.getAllData();
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.updateData(custId, customer);
	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteDataById(custId);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteAllData();
	}

	@Override
	public List<Customer> sortByCustName() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sortByCustName();
	}

	@Override
	public List<Customer> sortByAccBalance() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sortByAccBalance();
	}

	@Override
	public List<Customer> sortByDob() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sortByDob();
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub
		return customerDaoImpl.filterByName(custName);
	}

	@Override
	public List<Customer> filterByAccBalance(double custAccBalance) {
		// TODO Auto-generated method stub
		return customerDaoImpl.filterByAccBalance(custAccBalance);
	}

}
