package com.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "custom")
public class Customer {
@Id
@GeneratedValue
private int custId;
private String custName;
private String custAddress;
private long custNumber;
private double custAccBalance;
private String custGender;
@Temporal(TemporalType.DATE)
private Date custDOB;
private String custEmailId;
private String custPassword;

public Customer() {
	// TODO Auto-generated constructor stub
}

public Customer(String custName, String custAddress, long custNumber, double custAccBalance, String custGender,
		Date custDOB, String custEmailId, String custPassword) {
	super();
	this.custName = custName;
	this.custAddress = custAddress;
	this.custNumber = custNumber;
	this.custAccBalance = custAccBalance;
	this.custGender = custGender;
	this.custDOB = custDOB;
	this.custEmailId = custEmailId;
	this.custPassword = custPassword;
}

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

public double getCustAccBalance() {
	return custAccBalance;
}

public void setCustAccBalance(double custAccBalance) {
	this.custAccBalance = custAccBalance;
}

public String getCustGender() {
	return custGender;
}

public void setCustGender(String custGender) {
	this.custGender = custGender;
}

public Date getCustDOB() {
	return custDOB;
}

public void setCustDOB(Date custDOB) {
	this.custDOB = custDOB;
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


@Override
public String toString() {
	return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress + ", custNumber="
			+ custNumber + ", custAccBalance=" + custAccBalance + ", custGender=" + custGender + ", custDOB=" + custDOB
			+ ", custEmailId=" + custEmailId + ", custPassword=" + custPassword + "]";
}
}
