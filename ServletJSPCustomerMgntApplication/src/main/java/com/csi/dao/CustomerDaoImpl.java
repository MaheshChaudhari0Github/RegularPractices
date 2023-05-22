package com.csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.csi.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection = null;

	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customermanagementapplication",
					"root", "root");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into customer(custid, custname, custaddress, custcontactnumber, custaccountbalance, custage, custdob, custemailid, custpassword)values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, customer.getCustId());
			preparedStatement.setString(2, customer.getCustName());
			preparedStatement.setString(3, customer.getCustAddress());
			preparedStatement.setLong(4, customer.getCustContactNumber());
			preparedStatement.setDouble(5, customer.getCustAccountBalance());
			preparedStatement.setInt(6, customer.getCustAge());
			preparedStatement.setDate(7, new java.sql.Date(customer.getCustDOB().getTime()));
			preparedStatement.setString(8, customer.getCustEmailId());
			preparedStatement.setString(9, customer.getCustPassword());

			preparedStatement.executeUpdate();

			System.out.println("Data Inserted into DB Successfully");
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
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from customer where custemailid=? and custpassword=?");

			preparedStatement.setString(1, custEmailId);
			preparedStatement.setString(2, custPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			flag = resultSet.next();
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
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where custid=?");

			preparedStatement.setInt(1, custId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customer.setCustId(resultSet.getInt(1));
				customer.setCustName(resultSet.getString(2));
				customer.setCustAddress(resultSet.getString(3));
				customer.setCustContactNumber(resultSet.getLong(4));
				customer.setCustAccountBalance(resultSet.getDouble(5));
				customer.setCustAge(resultSet.getInt(6));
				customer.setCustDOB(resultSet.getDate(7));
				customer.setCustEmailId(resultSet.getString(8));
				customer.setCustPassword(resultSet.getString(9));

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
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustId(resultSet.getInt(1));
				customer.setCustName(resultSet.getString(2));
				customer.setCustAddress(resultSet.getString(3));
				customer.setCustContactNumber(resultSet.getLong(4));
				customer.setCustAccountBalance(resultSet.getDouble(5));
				customer.setCustAge(resultSet.getInt(6));
				customer.setCustDOB(resultSet.getDate(7));
				customer.setCustEmailId(resultSet.getString(8));
				customer.setCustPassword(resultSet.getString(9));

				customers.add(customer);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customers;
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update customer set custname=?, custaddress=?, custcontactnumber=?, custaccountbalance=?, custage=?, custdob=?, custemailid=?, custpassword=? where custid=?");

			preparedStatement.setString(1, customer.getCustName());
			preparedStatement.setString(2, customer.getCustAddress());
			preparedStatement.setLong(3, customer.getCustContactNumber());
			preparedStatement.setDouble(4, customer.getCustAccountBalance());
			preparedStatement.setInt(5, customer.getCustAge());
			preparedStatement.setDate(6, new java.sql.Date(customer.getCustDOB().getTime()));
			preparedStatement.setString(7, customer.getCustEmailId());
			preparedStatement.setString(8, customer.getCustPassword());
			preparedStatement.setInt(9, customer.getCustId());
			preparedStatement.executeUpdate();

			System.out.println("Data Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where custid=?");

			preparedStatement.setInt(1, custId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> sorByAge() {
		// TODO Auto-generated method stub
		return findAll().stream().sorted(Comparator.comparingLong(Customer::getCustAge)).toList();
	}

	@Override
	public List<Customer> sorByName() {
		// TODO Auto-generated method stub
		return findAll().stream().sorted((c1, c2) -> c1.getCustName().compareTo(c2.getCustName())).toList();
	}

	@Override
	public List<Customer> sorAccBalance() {
		// TODO Auto-generated method stub
		return findAll().stream().sorted(Comparator.comparingDouble(Customer::getCustAccountBalance)).toList();
	}

	@Override
	public List<Customer> sorByCustDOB() {
		// TODO Auto-generated method stub
		return findAll().stream().sorted((c1, c2) -> c1.getCustDOB().compareTo(c2.getCustDOB())).toList();
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub
		return findAll().stream().filter(cust -> cust.getCustName().equals(custName)).toList();
	}

	@Override
	public Customer filterByEmailId(String custEmailId) {
		// TODO Auto-generated method stub

		Customer customer = new Customer();

		for (Customer ccCustomer : findAll()) {
			if (ccCustomer.getCustEmailId().equals(custEmailId)) {
				customer = ccCustomer;
				break;
			}
		}
		return customer;
	}

	@Override
	public List<Customer> filterByAccBalance(double custAccountBalance) {
		// TODO Auto-generated method stub
		return findAll().stream().filter(cust -> cust.getCustAccountBalance() >= custAccountBalance).toList();
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from customer");

			preparedStatement.executeUpdate();

			System.out.println("All data Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
