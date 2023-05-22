package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(customer);
		t.commit();
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (Customer customer : getAllData()) {
			if (customer.getCustEmailID().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Customer customer2 = (Customer) s.get(Customer.class, custId);
		customer2.setCustName(customer.getCustName());
		customer2.setCustAddress(customer.getCustAddress());
		customer2.setCustNumber(customer.getCustNumber());
		customer2.setCustAccBalance(customer.getCustAccBalance());
		customer2.setCustDOB(customer.getCustDOB());
		customer2.setCustEmailID(customer.getCustEmailID());
		customer2.setCustPassword(customer.getCustPassword());
		s.update(customer2);
		t.commit();
	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Customer customer = (Customer) s.get(Customer.class, custId);
		s.delete(customer);
		t.commit();
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		return s.createQuery("from Customer").list();
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Customer customer = (Customer) s.get(Customer.class, custId);
		return customer;
	}

}
