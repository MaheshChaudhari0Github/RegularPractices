package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Add_O_to_M")
public class Address {
	@Id
	@GeneratedValue
	private int addressId;
	private String addressStreet;
	private String addressCity;
	private String addressState;
	private long addressPincode;

	public Address(String addressStreet, String addressCity, String addressState, long addressPincode) {
		super();
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressPincode = addressPincode;
	}

}
