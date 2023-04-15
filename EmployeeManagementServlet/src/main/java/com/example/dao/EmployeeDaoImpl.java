package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con = null;

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "Mahesh@472001");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		String inserts = "insert into employee(empid,empname,empaddress,empsalary,emailid,emppassword)values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(inserts);

			ps.setInt(1, employee.getEmpid());
			ps.setString(2, employee.getEmpname());
			ps.setString(3, employee.getEmpaddress());
			ps.setDouble(4, employee.getEmpSalary());
			ps.setString(5, employee.getEmpEmailId());
			ps.setString(6, employee.getEmpPassword());

			ps.executeUpdate();
			System.out.println("Data Inserted Sucessfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {
			PreparedStatement ps = con
					.prepareStatement("select * from employee where emailid=? and emppassword=?");

			ps.setString(1, empEmailId);
			ps.setString(2, empPassword);

			ResultSet rs = ps.executeQuery();

			flag = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

}
