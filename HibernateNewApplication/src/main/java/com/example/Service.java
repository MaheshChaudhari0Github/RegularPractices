package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	public static SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		
		//saveData();
		//getData();
		deleteData();
		
		// TODO Auto-generated method stub
	}
	 static void saveData(){
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Address address = new Address("Mall", "Pune", "India", 456123);
		Employee employee = new Employee("Kalesh", 123456, 10, address);
		s.save(employee);
		t.commit();

	}

	@SuppressWarnings("unchecked")
	static void getData() {
		Session s = sf.openSession();
		//1 st method
		s.createQuery("from Employee").list().forEach(System.out::println);
		// 2nd method
		s.createQuery("from Employee").list().forEach(emp ->System.out.println(emp));

	}
	
	static void deleteData(){
		Session s = sf.openSession(); 
		Transaction t = s.beginTransaction();
		s.createQuery("delete from Employee where empid = 7 ").executeUpdate();
		 System.out.println("Deleted");
		 t.commit();
	}
}