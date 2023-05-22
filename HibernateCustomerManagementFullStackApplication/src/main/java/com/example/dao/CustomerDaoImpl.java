package com.example.dao;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void signup(Customer customer) {
		// TODO Auto-generated method stub

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(customer);
		t.commit();

	}

	@Override
	public boolean signin(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (Customer customer : getAllData()) {
			if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
				flag = true;
			}

		}
		return flag;
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Customer customer = (Customer) s.get(Customer.class, custId);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();

		return s.createQuery("from Customer").list();
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Customer customer2 = getDataById(custId);
		customer2.setCustName(customer.getCustName());
		customer2.setCustAddress(customer.getCustAddress());
		customer2.setCustNumber(customer.getCustNumber());
		customer2.setCustAccBalance(customer.getCustAccBalance());
		customer2.setCustGender(customer.getCustGender());
		customer2.setCustDOB(customer.getCustDOB());
		customer2.setCustEmailId(customer.getCustEmailId());
		customer2.setCustPassword(customer.getCustPassword());

		s.update(customer2);
		t.commit();
	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Customer customer2 = getDataById(custId);
		s.delete(customer2);
		t.commit();
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		for (Customer customer : getAllData()) {
			Transaction t = s.beginTransaction();
			s.delete(customer);
			t.commit();
		}
	}

	@Override
	public List<Customer> sortByCustName() {
		// TODO Auto-generated method stub
		return getAllData().stream().sorted((c1, c2) -> c1.getCustName().compareTo(c2.getCustName())).toList();
	}

	@Override
	public List<Customer> sortByAccBalance() {
		// TODO Auto-generated method stub
		return getAllData().stream().sorted(Comparator.comparingDouble(Customer::getCustAccBalance)).toList();
	}

	@Override
	public List<Customer> sortByDob() {
		// TODO Auto-generated method stub
		return getAllData().stream().sorted((c1, c2) -> c1.getCustDOB().compareTo(c2.getCustDOB())).toList();
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub
		return getAllData().stream().filter(cust -> cust.getCustName().equals(custName)).toList();
	}

	@Override
	public List<Customer> filterByAccBalance(double custAccBalance) {
		// TODO Auto-generated method stub
		return getAllData().stream().filter(cust -> cust.getCustAccBalance() >= custAccBalance).toList();
	}

}
