package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer_management")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "cust_id")
	private int custid;

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "cust_address")
	private String custAddress;

	@Column(name = "cust_number", unique = true)
	private long custNumber;

	@Column(name = "cust_balance")
	private double custAccBalance;

	@Column(name = "cust_gender")
	// @Transient Avoid persist data into database
	private String custGender;

	@Temporal(TemporalType.DATE)
	@Column(name = "cust_dob")
	private Date custDOB;

	@Column(name = "cust_email", unique = true)
	private String custEmailId;

	@Column(name = "cust_password")
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

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
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
		return "Customer [custid=" + custid + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custNumber=" + custNumber + ", custAccBalance=" + custAccBalance + ", custGender=" + custGender
				+ ", custDOB=" + custDOB + ", custEmailId=" + custEmailId + ", custPassword=" + custPassword + "]";
	}
}
