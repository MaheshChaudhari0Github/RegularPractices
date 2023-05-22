package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Emplo_M_to_M")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	private String empName;
	
	private double empSalary;
	
	@ManyToMany
	private List<Address>addresses;

	public Employee(String empName, double empSalary, List<Address> addresses) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.addresses = addresses;
	}
	
	

}
