package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	
	 private static SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		//Address address = new Address("Mall", "PCMC", "Maharashtra", "India", 411044);
		Address address = new Address();
		address.setAddressStreet("Mall");
		address.setAddressCity("Mumbai");
		address.setAddressState("MH");
		address.setAddressCountry("India");
		address.setAddressPinCode(412008); 
		s.delete(address);
		//Employee employee = new Employee("Adarsh", 9820, address);
		Employee employee = new Employee();
		employee.setEmpName("Kalesh");
		employee.setEmpSalary(8564);
		employee.setAddress(address);
		s.delete(employee);
		t.commit();
		System.out.println("Data Inserted Sucessfully");
	}
}