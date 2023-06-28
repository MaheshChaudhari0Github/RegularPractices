package com.example.repo;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface EmployeeRepo extends JpaRepository <Employee,Integer>{
}
