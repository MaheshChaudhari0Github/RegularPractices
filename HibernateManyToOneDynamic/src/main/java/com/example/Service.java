package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Address address = new Address("Pune", "Maharashtra", "India", 456321);
		s.save(address);
		
		Employee employee1 = new Employee("Kalesh", 10, address);
		Employee employee2 = new Employee("Goresh", 20, address);
		Employee employee3 = new Employee("Malesh", 30, address);
		Employee employee4 = new Employee("Palesh", 40, address);
		
		s.save(employee4);
		s.save(employee3);
		s.save(employee2);
		s.save(employee1);
		
		t.commit();

		System.out.println("Hurray!");

	}

}
