package com.example;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.mysql.cj.protocol.Resultset;


/**
 * Hello world!
 *
 */
public class App 
{
	public static String addEmpatos(Connection con) throws SQLException
	{
		try (//int row=st1.executeUpdate("insert into empatos values(5,'Shital',50000)");
				//int row2=st1.executeUpdate("insert into empatos values(6,'Rutuja',55000)");
				//int row3=st1.executeUpdate("insert into empatos values(7,'Neha',60000)");
		Scanner obj = new Scanner(System.in)) {
			System.out.println("Enter the id:"); 
			int id =obj.nextInt();
			System.out.println("Enter the name:");
			String name=obj.next();
			System.out.println("Enter the salary:");
			int salary=obj.nextInt();
			try {
				PreparedStatement pst = con.prepareStatement("insert into empatos values  ");
				pst.setInt(1, id);
				pst.setString(2,name);
				pst.setInt(3, salary);
				pst.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return "employee added";
	}
		
	public static String updateEmpatos(Connection con) throws SQLException
	{
		PreparedStatement pt=con.prepareStatement("update empatos set salary=? where id=?");
		pt.setInt(1,3);
		pt.setInt(2, 1);
		pt.executeUpdate();
		
		return "updated employee";
		
	}
	
	public static String deleteEmpatos(Connection con) throws SQLException
	{
		try (Scanner obj = new Scanner(System.in)) {
			System.out.println("Enter the id:");
			int id=obj.nextInt();
			try {
			PreparedStatement pst=con.prepareStatement("delete from empatos where id=? ");
			pst.setInt(1, id);
			pst.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return "delete employee";
	}
    public static void main( String[] args) throws SQLException
    {
    	Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Jdbc","root","Mahesh@472001");
    	Statement st=con.createStatement();
    	int row=st.executeUpdate("create table empwipro(id int primary key,name varchar(30),salary int)");
    	System.out.println( row );
    	int row0=st.executeUpdate("insert into empwipro values(1105,'Vaishnavi',25000)");
    	int row1=st.executeUpdate("insert into empwipro values(1106,'Aditi',30000)");
    	int row2=st.executeUpdate("insert into empwipro values(1104,'Neha',33000)");
    	int row3=st.executeUpdate("insert into empwipro values(1108,'Mahesh',55000)");
    	System.out.println(row0);
    	System.out.println(row1);
    	System.out.println(row2);
    	System.out.println(row3);
    	
    	
    	System.out.println(addEmpatos(con));
    	System.out.println(deleteEmpatos(con));
    	System.out.println(updateEmpatos(con));
    	
 //   	int row=st.executeUpdate("create table empatos(id int primary key,name varchar(30),salary int)");
 //   	System.out.println(row);
    	
 //   	int row1=st.executeUpdate("insert into empatos values(1,'Vaishnavi',25000)");
 //   	System.out.println(row1);
    	
 //   	int row2=st.executeUpdate("insert into empatos values(2,'Shruti',30000)");
 //   	System.out.println(row2);
    	
 //   	int row3=st.executeUpdate("insert into empatos values(3,'Aditi',40000)");
 //   	System.out.println(row3);
    	
 //   	int row4=st.executeUpdate("insert into empatos values(4,'Neha',45000)");
 //   	System.err.println(row4);
    	
 //   
    	
    	ResultSet rs=st.executeQuery("Select * from empatos");
    	while(rs.next())
    	{
   		System.out.println("Id: "+rs.getInt("id")+ " " +"Name: "+rs.getString("name")+ " " + "salary: "+rs.getInt("salary"));
    	}
    	
    }
}