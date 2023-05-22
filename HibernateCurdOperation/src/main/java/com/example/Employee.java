package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "emp_curd")

public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_address")
	private String empAddress;

	@Column(name = "emp_number")
	private long empNumber;

	@Column(name = "emp_salary")
	private double empSalary;

	@Column(name = "emp_date")
	@Temporal(TemporalType.DATE)
	private Date empDOB;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empAddress, long empNumber, double empSalary, Date empDOB) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empNumber = empNumber;
		this.empSalary = empSalary;
		this.empDOB = empDOB;
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

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	@Override
	public String toString() {

		SimpleDateFormat sdf = new SimpleDateFormat();
		String dobDate = sdf.format(empDOB);
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empNumber="
				+ empNumber + ", empSalary=" + empSalary + ", empDOB=" + dobDate + "]";
	}

}
