package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CURDapp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * 1. Load Driver Class 
		 * 2. Establish Connections 
		 * 3. Create Statements 
		 * 4. Execute Query 
		 * 5. Close Connection
		 */

		Connection con = null; // by using this we can close the can down if we start connection by establish After 2 
		// then it gives compile time error so better is to create here..
		
		try {
			// 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CURDJDBCe", "root", "Mahesh@472001");

			// Statement st = con.createStatement();

			// We create a Database here.
			/*
			 * String createDBSQL="create database CURDJDBCe";
			 * 
			 * PreparedStatement ps = con.prepareStatement(createDBSQL);
			 * 
			 * ps.executeUpdate();
			 * 
			 * System.out.println("DataBase Created SucessFully");
			 */

			// We create a table here

			/*
			 * String
			 * createTableSQL="create table curds(id int, name varchar(23),salary int)";
			 * 
			 * PreparedStatement ps = con.prepareStatement(createTableSQL);
			 * 
			 * ps.executeUpdate();
			 * 
			 * System.out.println("Table is created Sucessfully");
			 */

			// we want to insert a values in tables

			/*
			 * String InsertValuesSQL =
			 * "insert into curds(id,name,salary)values(1,'SAS',123),(2,'SDS',234),(3,'SES',345)"
			 * ;
			 * 
			 * PreparedStatement ps = con.prepareStatement(InsertValuesSQL);
			 * 
			 * ps.executeUpdate();
			 * 
			 * System.out.println("Insert values is Sucessfully");
			 */

			// we can create a table and insert values in only 2 lines

			/*
			 * String createTablecurdsOneLine =
			 * "create table curdsOneLine(id int, name varchar(23),salary int)"; String
			 * insertvaluescurdsOneLine =
			 * "insert into curdsOneLine values(2,'QWQ',234),(3,'WEW',456)";
			 * 
			 * PreparedStatement pss = con.prepareStatement(createTablecurdsOneLine);
			 * PreparedStatement pss1 = con.prepareStatement(insertvaluescurdsOneLine);
			 * 
			 * pss.executeUpdate(); pss1.executeUpdate();
			 * 
			 * System.out.println("WE have created a table ans also inserted a values ;;");
			 */

			// we want to update a values in tables

			/*
			 * String InsertValuesSQL = "Update curds set name='ASADAS' where id=1";
			 * 
			 * PreparedStatement ps = con.prepareStatement(InsertValuesSQL);
			 * 
			 * ps.executeUpdate();
			 * 
			 * System.out.println("Update Sucessfully");
			 */

			// We can read all the data or print the whole table

			/*
			 * String selectSQL = "select * from curds";
			 * 
			 * PreparedStatement psq = con.prepareStatement(selectSQL);
			 * 
			 * ResultSet rs = psq.executeQuery();
			 * 
			 * while (rs.next()) {
			 * System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)); }
			 */

			// we can delete a record

			String deleteSQL = "delete from curds where id = 1";

			PreparedStatement ps = con.prepareStatement(deleteSQL);

			ps.executeUpdate();

			System.out.println("Deleted Sucessfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			System.out.println();
		}

	}
}