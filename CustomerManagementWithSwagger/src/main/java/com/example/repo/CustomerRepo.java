package com.example.repo;

import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo  extends JpaRepository<Customer,Integer> {

}
