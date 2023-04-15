package com.example.service;

import java.util.List;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDaoImpl = new CustomerDaoImpl();

	@Override
	public void signUP(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.signUP(customer);
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		return customerDaoImpl.signIn(custEmailId, custPassword);
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		return customerDaoImpl.getDataById(custId);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDaoImpl.findAll();
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
	public List<Customer> sortByAge() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sortByAge();
	}

	@Override
	public List<Customer> sortByName() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sortByName();
	}

	@Override
	public List<Customer> sortByAccBalance() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sortByAccBalance();
	}

	@Override
	public List<Customer> sortByCustDOB() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sortByCustDOB();
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub
		return customerDaoImpl.filterByName(custName);
	}

	@Override
	public Customer filterByEmailId(String custEmailId) {
		// TODO Auto-generated method stub
		return customerDaoImpl.filterByEmailId(custEmailId);
	}

	@Override
	public List<Customer> filterByAccBalance(double custAccBalance) {
		// TODO Auto-generated method stub
		return customerDaoImpl.filterByAccBalance(custAccBalance);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteAllData();
	}
}