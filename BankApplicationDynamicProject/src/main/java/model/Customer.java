package model;

public class Customer { 												// POJO Class
	
	private long customerAccountNumber;									// private variables because don't acess outside class 
	private String customerPassowrd;									// use in this class only

	public Customer(long customerAccountNumber, String customerPassowrd) {
		super();
		this.customerAccountNumber = customerAccountNumber;
		this.customerPassowrd = customerPassowrd;
	}

	public long getCustomerAccountNumber() {
		return customerAccountNumber;
	}

	public void setCustomerAccountNumber(long customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}

	public String getCustomerPassowrd() {
		return customerPassowrd;
	}

	public void setCustomerPassowrd(String customerPassowrd) {
		this.customerPassowrd = customerPassowrd;
	}

}
