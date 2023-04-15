package com.example.model;

public class Employee {
	private int empid;

	private String empName;

	private String empAddress;
	
	private double empSalary;

	private String empEmailId;

	private String empPassword;

	// Constructor using fields
	public Employee(int empid, String empName, String empAddress, double empSalary, String empEmailId,
			String empPassword) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
		this.empEmailId = empEmailId;
		this.empPassword = empPassword;
	}

	// Getter Setters
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empName;
	}

	public void setEmpname(String empName) {
		this.empName = empName;
	}

	public String getEmpaddress() {
		return empAddress;
	}

	public void setEmpaddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
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

	// To String
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empAddress=" + empAddress + ", empSalary="
				+ empSalary + ", empEmailId=" + empEmailId + ", empPassword=" + empPassword + "]";
	}
}
