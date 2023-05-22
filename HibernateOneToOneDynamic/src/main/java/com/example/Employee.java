package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "One_Employee")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	private String empName;
	
	private double empSalary;
	
	@OneToOne
	private Address address;
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public double getEmpSalary() {
		return empSalary;
	}


	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	/*
	 * public Employee(String empName, double empSalary, Address address) { super();
	 * this.empName = empName; this.empSalary = empSalary; this.address = address; }
	 */
}