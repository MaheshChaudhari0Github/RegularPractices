package com.example;

public class Product {
	private int productid;
	private String productname;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public void init() {
		System.out.println("Method intialize");
	}
	
	public void destroy () {
		System.out.println("Method delete");
	}
	 

}