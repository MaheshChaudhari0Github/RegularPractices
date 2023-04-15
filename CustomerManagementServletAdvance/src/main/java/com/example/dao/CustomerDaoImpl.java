package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Connection con = null;

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
	public void signUP(Customer customer) {
		// TODO Auto-generated method stub

		String insert = "insert into customer(custid,custname,custaddress,custnumber,custaccbalance,custage,custdob,custemailid,custpassword) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);

			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getCustName());
			ps.setString(3, customer.getCustAddress());
			ps.setLong(4, customer.getCustNumber());
			ps.setDouble(5, customer.getCustAccBalance());
			ps.setInt(6, customer.getCustAge());
			ps.setDate(7, new java.sql.Date(customer.getCustDOB().getTime()));
			ps.setString(8, customer.getCustEmailId());
			ps.setString(9, customer.getCustPassword());

			ps.executeUpdate();
			System.out.println("Data inserted Sucessgfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub

		boolean flag = false;

		try {
			String select = "select * from customer where custemailid = ? and custpassword=?";

			PreparedStatement ps = con.prepareStatement(select);

			ps.setString(1, custEmailId);
			ps.setString(2, custPassword);

			ResultSet rs = ps.executeQuery();

			flag = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();

		try {

			String selectId = "select * from customer where custId=?";

			PreparedStatement ps = con.prepareStatement(selectId);

			ps.setInt(1, custId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customer.setCustId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setCustAddress(rs.getString(3));
				customer.setCustNumber(rs.getLong(4));
				customer.setCustAccBalance(rs.getDouble(5));
				customer.setCustAge(rs.getInt(6));
				customer.setCustDOB(rs.getDate(7));
				customer.setCustEmailId(rs.getNString(8));
				customer.setCustPassword(rs.getString(9));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();

		try {

			String selectFindAll = "select * from customer";

			PreparedStatement ps = con.prepareStatement(selectFindAll);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setCustId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setCustAddress(rs.getString(3));
				customer.setCustNumber(rs.getLong(4));
				customer.setCustAccBalance(rs.getDouble(5));
				customer.setCustAge(rs.getInt(6));
				customer.setCustDOB(rs.getDate(7));
				customer.setCustEmailId(rs.getNString(8));
				customer.setCustPassword(rs.getString(9));

				customers.add(customer);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public void updateData(Integer custId, Customer customer) {
		// TODO Auto-generated method stub

		try {
			String updateData = "update customer set custname=?,custaddress=?,custnumber=?,custaccbalance=?,custage=?,custdob=?,custemailid=?,custpassword=? where custid=?";

			PreparedStatement ps = con.prepareStatement(updateData);

			ps.setString(1, customer.getCustName());
			ps.setString(2, customer.getCustAddress());
			ps.setLong(3, customer.getCustNumber());
			ps.setDouble(4, customer.getCustAccBalance());
			ps.setInt(5, customer.getCustAge());
			ps.setDate(6, new java.sql.Date(customer.getCustDOB().getTime()));
			ps.setString(7, customer.getCustEmailId());
			ps.setString(8, customer.getCustPassword());
			ps.setInt(9, custId);

			System.out.println("Customer Data is updated Sucessfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub

		try {
			String deleteById = "delete from customer where custid=?";
			PreparedStatement ps = con.prepareStatement(deleteById);

			ps.setInt(1, custId);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> sortByAge() {
		// TODO Auto-generated method stub

		return findAll().stream().sorted(Comparator.comparingLong(Customer::getCustAge)).collect(Collectors.toList());
	}

	@Override
	public List<Customer> sortByName() {
		// TODO Auto-generated method stub

		return findAll().stream().sorted((c1, c2) -> c1.getCustName().compareTo(c2.getCustName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Customer> sortByAccBalance() {
		// TODO Auto-generated method stub
		return findAll().stream().sorted(Comparator.comparingDouble(Customer::getCustAccBalance))
				.collect(Collectors.toList());
	}

	@Override
	public List<Customer> sortByCustDOB() {
		// TODO Auto-generated method stub
		return findAll().stream().sorted((c1, c2) -> c1.getCustDOB().compareTo(c2.getCustDOB()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub

		return findAll().stream().filter(cust -> cust.getCustName().equals(custName)).collect(Collectors.toList());
	}

	@Override
	public Customer filterByEmailId(String custEmailId) {
		// TODO Auto-generated method stub
		Customer cust = new Customer();
		for (Customer ccCustomer : findAll()) {
			if (ccCustomer.getCustEmailId().equals(custEmailId)) {
				cust = ccCustomer;
			}
		}
		return cust;
	}

	@Override
	public List<Customer> filterByAccBalance(double custAccBalance) {
		// TODO Auto-generated method stub
		return findAll().stream().filter(cust -> cust.getCustAccBalance() >= custAccBalance)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		try {
			String truncate = "truncate table customer";
			PreparedStatement ps = con.prepareStatement(truncate);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}