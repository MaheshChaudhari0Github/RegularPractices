package com.example;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Service {

	private static SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//saveData();
		//code();
		//agg();
		nq();
	}

	static void saveData() {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Employee emp = new Employee("Alok", "Manipur", 40, 288456L);
		s.save(emp);
		t.commit();
		s.close();
	}

	static void code() {// hcql code
		Session s = sf.openSession();
		Criteria criteria = s.createCriteria(Employee.class);
		// Criterion criterion = Restrictions.eq("empName", "Alok");
		// Criterion criterion = Restrictions.gt("empSalary", 20.0);
		// Criterion criterion = Restrictions.ge("empSalary", 20.0);
		Criterion criterion = Restrictions.lt("empSalary", 20.0);
		@SuppressWarnings("unchecked")
		List<Employee> employees = criteria.add(criterion).list();
		employees.forEach(System.out::println);
		s.close();
	}
	
	static void agg() { // aggregate function
		Session s = sf.openSession();
		//List<Employee> employees = s.createQuery("select MAX(empSalary)from Employee").list();
		//List<Employee> employees = s.createQuery("select MIN(empSalary)from Employee").list();
		@SuppressWarnings("unchecked")
		List<Employee> employees = s.createQuery("select COUNT(empSalary)from Employee").list();
		System.out.println(employees);
		s.close();
	}
	static void nq() {// named query
		Session s = sf.openSession();
		Query query = s.getNamedQuery("findbyname");
		query.setParameter("empName", "Alok");
		@SuppressWarnings("unchecked")
		List<Employee>employees = query.list();
		employees.forEach(System.out::println);
		s.close();
	}
}
