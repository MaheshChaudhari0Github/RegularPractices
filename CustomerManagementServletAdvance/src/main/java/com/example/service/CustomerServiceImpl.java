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
		customerDaoImpl.signIn(custEmailId, custPassword);
		return false;
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		customerDaoImpl.getDataById(custId);
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		customerDaoImpl.findAll();
		return null;
	}

	@Override
	public void updateData(Integer custId, Customer customer) {
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
		customerDaoImpl.sortByAge();
		return null;
	}

	@Override
	public List<Customer> sortByName() {
		// TODO Auto-generated method stub
		customerDaoImpl.sortByName();
		return null;
	}

	@Override
	public List<Customer> sortByAccBalance() {
		// TODO Auto-generated method stub
		customerDaoImpl.sortByAccBalance();
		return null;
	}

	@Override
	public List<Customer> sortByCustDOB() {
		// TODO Auto-generated method stub
		customerDaoImpl.sortByCustDOB();
		return null;
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub
		customerDaoImpl.filterByName(custName);
		return null;
	}

	@Override
	public Customer filterByEmailId(String custEmailId) {
		// TODO Auto-generated method stub
		customerDaoImpl.filterByEmailId(custEmailId);
		return null;
	}

	@Override
	public List<Customer> filterByAccBalance(double custAccBalance) {
		// TODO Auto-generated method stub
		customerDaoImpl.filterByAccBalance(custAccBalance);
		return null;
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteAllData();

	}

}
