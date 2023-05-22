package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Addr_M_to_One")
public class Address {
@Id
@GeneratedValue
private int addressId;
private String addresssCity;
private String addresssState;
private String addresssCountry;
private long addressPincode;
public Address(String addresssCity, String addresssState, String addresssCountry, long addressPincode) {
	super();
	this.addresssCity = addresssCity;
	this.addresssState = addresssState;
	this.addresssCountry = addresssCountry;
	this.addressPincode = addressPincode;
}

}
