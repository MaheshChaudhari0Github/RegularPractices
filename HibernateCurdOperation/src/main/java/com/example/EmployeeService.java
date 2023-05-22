package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class EmployeeService {
	private static org.hibernate.SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService empservice = new EmployeeService();
		empservice.save();
		/*
		 * empservice.get(); empservice.delete(2); empservice.udpate(2);
		 */

	}

	void save() { // Create
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dobDate = null;
		try {
			dobDate = sdf.parse("09-09-1999");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee emps = new Employee("Shamuram", "Sangali", 4585668, 200, dobDate);
		s.save(emps);
		t.commit();
	}

	@SuppressWarnings("unchecked")
	void get() { // Read
		Session s = sf.openSession();
		s.createQuery("from Employee").list().forEach(System.out::println);

	}

	void udpate(int empId) { // Update

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dobDate = null;
		try {
			dobDate = sdf.parse("09-08-1998");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee emps = (Employee) s.get(Employee.class, empId);
		emps.setEmpName("Champus");
		emps.setEmpAddress("Katan");
		emps.setEmpSalary(900);
		emps.setEmpNumber(987253614);
		emps.setEmpDOB(dobDate);
		s.update(emps);
		t.commit();
	}

	void delete(int empId) { // Delete
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		// 1 st Method
		/*Employee emps = (Employee) s.get(Employee.class, empId);
		s.delete(emps);
		t.commit();*/
		
		// 2 nd Method
		@SuppressWarnings("unchecked")
		List<Employee> employees = s.createQuery("from Employee").list();
		for(Employee empl : employees) {
			if(empl.getEmpId()==empId) {
				s.delete(empl);
				t.commit();
			}	
		}
	}
}