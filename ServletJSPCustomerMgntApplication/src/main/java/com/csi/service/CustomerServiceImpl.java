package com.csi.service;

import java.util.List;

import com.csi.dao.CustomerDao;
import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDaoImpl = new CustomerDaoImpl();

	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.signUp(customer);
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
	public List<Customer> sorByAge() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sorByAge();
	}

	@Override
	public List<Customer> sorByName() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sorByName();
	}

	@Override
	public List<Customer> sorAccBalance() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sorAccBalance();
	}

	@Override
	public List<Customer> sorByCustDOB() {
		// TODO Auto-generated method stub
		return customerDaoImpl.sorByCustDOB();
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
	public List<Customer> filterByAccBalance(double custAccountBalance) {
		// TODO Auto-generated method stub
		return customerDaoImpl.filterByAccBalance(custAccountBalance);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteAllData();
	}

}
