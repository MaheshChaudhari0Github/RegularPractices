package com.example;

import java.util.LinkedList;
import java.util.List;

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
		List<Employee> employees = new LinkedList<Employee>();
		List<Address> addresses = new LinkedList<Address>();

		Address address1 = new Address("Pune", "MH", "India", 456, employees);
		Address address2 = new Address("Nagar", "Punjab", "India", 568, employees);
		Address address3 = new Address("Wakad", "Assam", "India", 792, employees);

		s.save(address1);
		s.save(address2);
		s.save(address3);
		
		addresses.add(address3);
		addresses.add(address2);
		addresses.add(address1);
		
		Employee employee1 = new Employee("Kalesh", 10, addresses);
		Employee employee2 = new Employee("Goresh", 20, addresses);
		Employee employee3 = new Employee("Malesh", 30, addresses);
		
		s.save(employee3);
		s.save(employee2);
		s.save(employee1);
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		t.commit();
	}

}
