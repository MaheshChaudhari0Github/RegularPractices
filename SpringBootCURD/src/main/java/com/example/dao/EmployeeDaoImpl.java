package com.example.dao;

import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.core.annotation.AnnotationConfigurationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    private static SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void saveData(Employee employee) {
        Session s =  sf.openSession();
        Transaction t =  s.beginTransaction();
        s.save(employee);
        t.commit();
    }

    @Override
    public List<Employee> getAllData() {
        Session s =  sf.openSession();

        return s.createQuery("from Employee").list();
    }

    @Override
    public void updateData(int empId, Employee employee) {
        Session s =  sf.openSession();
        Transaction t =  s.beginTransaction();
        Employee employee1 = (Employee) s.get(Employee.class, empId);

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpNumber(employee.getEmpNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        s.update(employee1);
        t.commit();

    }

    @Override
    public void deleteData(int empId) {
        Session s =  sf.openSession();
        Transaction t =  s.beginTransaction();
        Employee employee1 = (Employee) s.get(Employee.class, empId);
        s.delete(employee1);
        t.commit();
    }
}