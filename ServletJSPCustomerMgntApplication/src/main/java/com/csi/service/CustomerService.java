package com.csi.service;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerService {


	public void signUp(Customer customer);

	public boolean signIn(String custEmailId, String custPassword);

	public Customer getDataById(int custId);

	public List<Customer> findAll();

	public void updateData(int custId, Customer customer);

	public void deleteDataById(int custId);

	public List<Customer> sorByAge();

	public List<Customer> sorByName();

	public List<Customer> sorAccBalance();

	public List<Customer> sorByCustDOB();

	public List<Customer> filterByName(String custName);

	public Customer filterByEmailId(String custEmailId);

	public List<Customer> filterByAccBalance(double custAccountBalance);

	public void deleteAllData();



}
