package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.example.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		List<Employee> employees = s.createQuery("from Employee").list();
		return employees;
	}

	@Override
	public void saveData(Employee employee) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(employee);
		t.commit();

	}

}
