package com.example.dao;

import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
    private static SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void signup(Employee employee) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        s.save(employee);
        t.commit();
    }

    @Override
    public boolean signin(String emp_Email, String emp_Password) {

        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        boolean flag = false;
        for (Employee employee:getAlldata())
        {
         if (employee.getEmp_Email().equals(emp_Email)&& employee.getEmp_Password().equals(emp_Password))
         {
            flag = true; 
         }
        }
        return flag;
    }

    @Override
    public Employee getDataById(int emp_id) {
        Session s = sf.openSession();
        Employee employee = (Employee) s.get(Employee.class,emp_id);
        return employee;
    }

    @Override
    public List<Employee> getDataByName(String emp_name) {
        Session s = sf.openSession();
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee:getAlldata()) {
            if (employee.getEmp_Name().equals(emp_name)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public Employee getDataByNumber(long emp_Number) {
        Session s = sf.openSession();
        Employee employees= new Employee();
        for (Employee employee: getAlldata()){
            if(employee.getEmp_Number()==emp_Number){
                employees=employee;
            }
        }
        return employees;
    }

    @Override
    public Employee getDataByEmail(String emp_Email) {
        Session s = sf.openSession();
        Employee employees = new Employee();
        for (Employee employee:getAlldata()) {
            if(employee.getEmp_Email().equals(emp_Email)){
                employees=employee;
            }
        }
        return employees;
    }

    @Override
    public List<Employee> getAlldata() {
        Session s = sf.openSession();
        return s.createQuery("from Employee").list();
    }

    @Override
    public List<Employee> getDataByUsingAnyInput(Employee employee) {
        Session s = sf.openSession();
        List<Employee> lists = new ArrayList<>();
        for (Employee employee1 : getAlldata()) {
            if(employee1.getEmp_id()== employee.getEmp_id()||
            employee1.getEmp_Name().equals(employee.getEmp_Name())||
            employee1.getEmp_Number()==employee.getEmp_Number()||
            employee1.getEmp_Address().equals(employee.getEmp_Address())||
            employee1.getEmp_Email().equals(employee.getEmp_id())){
                lists.add(employee1);
            }
        }
        return lists;
    }

    @Override
    public void updateData(int emp_id, Employee employee) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Employee employee1 = (Employee) s.get(Employee.class,emp_id);

        employee1.setEmp_Name(employee.getEmp_Name());
        employee1.setEmp_Address(employee.getEmp_Address());
        employee1.setEmp_DOB(employee.getEmp_DOB());
        employee1.setEmp_Number(employee.getEmp_Number());
        employee1.setEmp_salary(employee.getEmp_salary());
        employee1.setEmp_Email(employee.getEmp_Email());
        employee1.setEmp_Password(employee.getEmp_Password());
        s.update(employee1);
        t.commit();
    }

    @Override
    public List<Employee> sortByName() {
        return getAlldata().stream().sorted((e1,e2)-> e1.getEmp_Name().compareTo(e2.getEmp_Name())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortBySalary() {
        return getAlldata().stream().sorted(Comparator.comparingDouble(Employee::getEmp_salary)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByDOB() {
        return getAlldata().stream().sorted((e1,e2)->e1.getEmp_DOB().compareTo(e2.getEmp_DOB())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortById() {
        return getAlldata().stream().sorted(Comparator.comparingLong(Employee::getEmp_id)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> filterById(int emp_Id) {
        return getAlldata().stream().filter(employee -> employee.getEmp_id()>=emp_Id).collect(Collectors.toList());
    }

    @Override
    public List<Employee> filterDataBySalary(double emp_Salary) {
        return getAlldata().stream().filter(employee -> employee.getEmp_salary()>=emp_Salary).collect(Collectors.toList());
    }

    @Override
    public void deleteDatabtId(int emp_id) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Employee employees = getDataById(emp_id);
        s.delete(employees);
        t.commit();
    }

    @Override
    public void deleteAllData() {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        for (Employee employee:getAlldata()) {
            s.delete(employee);
        }
        t.commit();
    }
}