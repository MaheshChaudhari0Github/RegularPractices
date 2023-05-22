package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name="findbyname",query="from Employee e where e.empName=:empName")})

@Entity
public class Employee {
@Id
@GeneratedValue
private int empId;
private String empName;
private String empAddress;
private double empSalary;
private long empNumber;

public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(String empName, String empAddress, double empSalary, long empNumber) {
	super();
	this.empName = empName;
	this.empAddress = empAddress;
	this.empSalary = empSalary;
	this.empNumber = empNumber;
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

@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empSalary="
			+ empSalary + ", empNumber=" + empNumber + "]";
}

}
