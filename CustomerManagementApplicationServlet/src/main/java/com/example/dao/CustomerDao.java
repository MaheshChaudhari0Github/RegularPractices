package com.example.dao;

	import java.util.List;

	import com.example.model.Customer;
	
	public interface CustomerDao {
		
		public void signUP(Customer customer);

		public boolean signIn(String custEmailId, String custPassword);

		public Customer getDataById(int custId);

		public List<Customer> findAll();

		public void updateData(int custId, Customer customer);

		public void deleteDataById(int custId);

		public List<Customer> sortByAge();

		public List<Customer> sortByName();

		public List<Customer> sortByAccBalance();

		public List<Customer> sortByCustDOB();

		public List<Customer> filterByName(String custName);

		public Customer filterByEmailId(String custEmailId);

		public List<Customer> filterByAccBalance(double custAccBalance);

		public void deleteAllData();

	}