package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empl_O_to_M")
public class Employee {

	@Id
	@GeneratedValue
	private int empId;

	private String empName;

	private double empSalary;

	@OneToMany
	private List<Address> addresses;

	public Employee(String empName, double empSalary, List<Address> addresss) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.addresses = addresss;
	}

}
