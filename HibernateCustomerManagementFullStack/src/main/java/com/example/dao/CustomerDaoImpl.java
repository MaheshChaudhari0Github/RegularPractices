package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao{
	
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
		
		boolean status= false;
		for(Customer customer: getAllData()) {
			if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
				status= true;
			}
		}
		
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		return s.createQuery("from Customer").list();
	}

}
