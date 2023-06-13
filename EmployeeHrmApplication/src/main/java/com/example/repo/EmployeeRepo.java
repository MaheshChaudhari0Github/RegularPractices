package com.example.repo;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

//     public List<Employee> findByEmpName(String empName);
//     public Employee findByNumber(long empNumber);
//     public Employee findByEmail(String empEmail);
}
