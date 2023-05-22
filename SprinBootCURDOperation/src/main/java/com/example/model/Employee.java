package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee_curd")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_address")
	private String empAddress;
	@Column(name = "emp_salary")
	private double empSalary;
	@Column(name = "emp_number")
	private long empNumber;
	@Column(name = "emp_dob")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date empDOB;
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
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public long getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(long empNumber) {
		this.empNumber = empNumber;
	}
	public Date getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empSalary="
				+ empSalary + ", empNumber=" + empNumber + ", empDOB=" + empDOB + "]";
	}
	
	

}
