package com.example;

public class Employee {

	private int empId;

	private String empName;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	/*
	 * void show() { System.out.println("Employee Id - " + empId +
	 * "\n Employee Name - " + empName); }
	 */
}