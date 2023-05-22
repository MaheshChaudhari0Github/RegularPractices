package com.example;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Service {
	private static SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Address address1 = new Address("One_Mall", "Wakad", "Maharashtra", 411087);
		Address address2 = new Address("Satr_Mall", "Pune", "Maharashtra", 412035);
		Address address3 = new Address("Reliance_Mall", "Nagar", "Delhi", 56892);
		
		s.save(address1);
		s.save(address2);
		s.save(address3);
		
		List<Address> addresses = new LinkedList<Address>();
		
		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);
		
		Employee employee = new Employee("Kalesh", 5264, addresses);
		
		s.save(employee);
		t.commit();

	}
} 