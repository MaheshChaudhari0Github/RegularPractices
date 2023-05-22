package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void signup(Employee employee) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(employee);
		t.commit();

	}

	@Override
	public boolean signin(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employee = s.createQuery("from Employee").list();
		for (Employee employee2 : employee) {
			if (employee2.getEmpEmailId().equals(empEmailId) && employee2.getEmpPassword().equals(empPassword)) {
				flag = true;
			}
		}
		return flag;
	}

}