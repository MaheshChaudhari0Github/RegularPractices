package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Addre_M_to_M")
public class Address {
@Id
@GeneratedValue
private int addressId;
private String addressCity;
private String addressState;
private String addressCountry;
private long addressPincode;
 @ManyToMany
 private List<Employee>employees;
public Address(String addressCity, String addressState, String addressCountry, long addressPincode,
		List<Employee> employees) {
	super();
	this.addressCity = addressCity;
	this.addressState = addressState;
	this.addressCountry = addressCountry;
	this.addressPincode = addressPincode;
	this.employees = employees;
}
}