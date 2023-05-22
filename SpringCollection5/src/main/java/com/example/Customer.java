package com.example;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Customer {
	
	private List custList;
	private Set custSet;
	private Map custMap;
	private Properties custProperties;
	
	
	public List getCustList() {
		return custList;
	}
	public void setCustList(List custList) {
		this.custList = custList;
	}
	public Set getCustSet() {
		return custSet;
	}
	public void setCustSet(Set custSet) {
		this.custSet = custSet;
	}
	public Map getCustMap() {
		return custMap;
	}
	public void setCustMap(Map custMap) {
		this.custMap = custMap;
	}
	public Properties getCustProperties() {
		return custProperties;
	}
	public void setCustProperties(Properties custProperties) {
		this.custProperties = custProperties;
	}
}