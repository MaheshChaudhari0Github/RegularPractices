package com.example;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CustomerService {

	SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService cs = new CustomerService();

		/*
		 * cs.signup(); cs.signin("shamuram@.com", "shamu@123"); cs.getAllData();
		 * cs.getDataById(2); cs.updateData(2); cs.deleteDataById(1); cs.sortByName();
		 * cs.sortByAccBalance(); cs.filterDataByAccBalance(300);
		 */cs.deleteAllData();

	}

	void signup() {

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Customer custs = new Customer("DabluBhaii", "D town", 458549, 10.0, "dabluram@.com", "dablu@123");
		s.save(custs);
		t.commit();

	}

	@SuppressWarnings("unchecked")
	void signin(String custEmailId, String custPassword) {
		boolean flag = false;
		Session s = sf.openSession();
		List<Customer> customers = s.createQuery("from Customer").list();
		for (Customer customer : customers) {
			if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
				flag = true;
			}
		}
		if (flag) {
			System.out.println("Sign in Sucessfully");
		} else {
			System.out.println("Invalid");
		}

	}

	void getDataById(int custId) {

		Session s = sf.openSession();
		// 1 st Method
		/*
		 * Customer customer = (Customer) s.get(Customer.class, custId);
		 * System.out.println(customer);
		 */
		// 2 nd Method

		@SuppressWarnings("unchecked")
		List<Customer> customers = s.createQuery("from Customer").list();
		customers.stream().filter(cust -> cust.getCustId() == custId).forEach(System.out::println);

	}

	void getAllData() {

		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customers = s.createQuery("from Customer").list();
		customers.forEach(System.out::println);

	}

	void updateData(int custId) {

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Customer customer = (Customer) s.load(Customer.class, custId);
		customer.setCustName("Ram");
		// use any variable to update any value
		s.update(customer);
		t.commit();
	}

	void deleteDataById(int custId) {

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Customer customer = (Customer) s.load(Customer.class, custId);
		s.delete(customer);
		t.commit();
	}

	void sortByName() {

		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customers = s.createQuery("from Customer").list();
		customers.stream().sorted((c1, c2) -> c1.getCustName().compareTo(c2.getCustName()))
				.forEach(System.out::println);
	}

	void sortByAccBalance() {

		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customers = s.createQuery("from Customer").list();
		customers.stream().sorted(Comparator.comparingDouble(Customer::getCustAccBalance).reversed())
				.forEach(System.out::println);
		// using reversed method we are printing the values in descending order for
		// ascending just remove reversed
	}

	void filterDataByAccBalance(double custAccBalance) {

		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customer = s.createQuery("from Customer").list();
		customer.stream().filter(cust -> cust.getCustAccBalance() >= custAccBalance).forEach(System.out::println);

	}

	void deleteAllData() {

		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customer = s.createQuery("from Customer").list();
		for (Customer customers : customer) {
			Transaction t = s.beginTransaction();
			s.delete(customers);
			t.commit();
		}
	}
}