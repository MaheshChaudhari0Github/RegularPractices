package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicsJDBC {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		// Create a new Connection
		
		Connection con = null;
		
		// 1. Load Driver Class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // @1

			// 2. Connect with Database | Establish Connection

			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Mahesh@472001"); // @2

				// 3. Create Statement

				Statement st = con.createStatement(); // @3

				// 4. Execute Query

				ResultSet rs = st.executeQuery("select * from jdbcbasictable"); // @4
				
				// Using while we are printing all the data from rs
				
				while (rs.next()) {
					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 	5. We have to close a connection so put it in finally block to always execute
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}