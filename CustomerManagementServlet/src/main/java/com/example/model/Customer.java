package com.example.model;

import java.util.Date;

public class Customer {

	private int custId;

	private String custName;

	private String custAddress;

	private long custNumber;

	private Double custAccBalance;

	private int custAge;

	private Date custDob;

	private String custEmailId;

	private String custPassword;

	// Default Constructor
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	// Constructor using fields
	public Customer(int custId, String custName, String custAddress, long custNumber, Double custAccBalance,
			int custAge, Date custDob, String custEmailId, String custPassword) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custNumber = custNumber;
		this.custAccBalance = custAccBalance;
		this.custAge = custAge;
		this.custDob = custDob;
		this.custEmailId = custEmailId;
		this.custPassword = custPassword;
	}

	// Getter Setter
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public long getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(long custNumber) {
		this.custNumber = custNumber;
	}

	public Double getCustAccBalance() {
		return custAccBalance;
	}

	public void setCustAccBalance(Double custAccBalance) {
		this.custAccBalance = custAccBalance;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public Date getCustDob() {
		return custDob;
	}

	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	// To String Method
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custNumber=" + custNumber + ", custAccBalance=" + custAccBalance + ", custAge=" + custAge
				+ ", custDob=" + custDob + ", custEmailId=" + custEmailId + ", custPassword=" + custPassword + "]";
	}
}