package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Connection con = null;

	// Default Constructor
	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "Mahesh@472001");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 

	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub

		String insert = "insert into customer(custid,custname,custaddress,custnumber,custaccbalance,custage,custdob,custemailid,custpassword) "
				+ "values(?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			System.out.println("System is not created yet");

			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getCustName());
			ps.setString(3, customer.getCustAddress());
			ps.setLong(4, customer.getCustNumber());
			ps.setDouble(5, customer.getCustAccBalance());
			ps.setInt(6, customer.getCustAge());
			ps.setDate(7, new java.sql.Date(customer.getCustDob().getTime()));
			ps.setString(8, customer.getCustEmailId());
			ps.setString(9, customer.getCustPassword());

			ps.executeUpdate();

			System.out.println("Customer Data is Inserted in Databse Sucessfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		boolean status= false;
		String select="select * from customer where custemailid=? and custpassword=?";  
		try {
			PreparedStatement ps = con.prepareStatement(select);
			
			ps.setString(1, custEmailId);
			ps.setString(2, custPassword);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		  
		return status;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		
		List<Customer>customers = new ArrayList<Customer>();
		String select="select * from customer";
		try {
			PreparedStatement ps = con.prepareStatement(select);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Customer customer = new Customer();
				
				customer.setCustId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setCustAddress(rs.getString(3));
				customer.setCustNumber(rs.getLong(4));
				customer.setCustAccBalance(rs.getDouble(5));
				customer.setCustAge(rs.getInt(6));
				customer.setCustDob(rs.getDate(7));
				customer.setCustEmailId(rs.getString(8));
				customer.setCustPassword(rs.getString(9));
				
				customers.add(customer);
	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}

}
