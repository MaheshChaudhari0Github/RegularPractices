package com.example;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
private String addressStreet;
private String addressCity;
private String addressCountry;
private long addressPincode;

public Address() {
	// TODO Auto-generated constructor stub
}
public Address(String addressStreet, String addressCity, String addressCountry, long addressPincode) {
	super();
	this.addressStreet = addressStreet;
	this.addressCity = addressCity;
	this.addressCountry = addressCountry;
	this.addressPincode = addressPincode;
}
@Override
public String toString() {
	return "Address [addressStreet=" + addressStreet + ", addressCity=" + addressCity + ", addressCountry="
			+ addressCountry + ", addressPincode=" + addressPincode + "]";
}

}
