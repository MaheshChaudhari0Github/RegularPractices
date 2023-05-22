package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int empId;
	
	private String empName;
	
	private String empAddress;
	
	private long empNumber;
	
	private String empEmailId;
	
	private String empPassword;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empAddress, long empNumber, String empEmailId, String empPassword) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empNumber = empNumber;
		this.empEmailId = empEmailId;
		this.empPassword = empPassword;
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

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public long getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(long empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empNumber="
				+ empNumber + ", empEmailId=" + empEmailId + ", empPassword=" + empPassword + "]";
	}
}