package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.example.model.Employee;
@Component
public class EmployeeDaoImpl implements EmployeeDao{
	private static SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void saveData(Employee employee) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		s.save(employee);
		t.commit();

	}

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();

		return s.createQuery("from Employee").list();
	}

	@Override
	public void updateData(int empid, Employee employee) {
		// TODO Auto-generated method stub

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Employee employee2 = (Employee) s.get(Employee.class, empid);

		if (employee2.getEmpId()==empid) {
			employee2.setEmpName(employee.getEmpName());
			employee2.setEmpAddress(employee.getEmpAddress());
			employee2.setEmpSalary(employee.getEmpSalary());
			employee2.setEmpNumber(employee.getEmpNumber());
			employee2.setEmpDOB(employee.getEmpDOB());

			s.update(employee2);
			t.commit();

			System.out.println("Udpate Data Sucessfully");

		}else {
			System.out.println("Record not Available");
		}
	}

	@Override
	public void deleteData(int empid) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Employee employee2 = (Employee) s.get(Employee.class, empid);

		s.delete(employee2);
		t.commit();
	}

}
