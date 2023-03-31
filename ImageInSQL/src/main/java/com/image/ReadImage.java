package com.image;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadImage {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con= null;
		
		try {// 1. Load Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Establish connection / Connect with database
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Image?useSSL=false","root","Mahesh@472001");
			
			// Query
			String select = "select * from Images";
			
			//3. create Prepared Statement
			PreparedStatement ps = con.prepareStatement(select);
			
			// Execute 
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) { // now on 1st row
			
				Blob b = rs.getBlob(2); // 2 means 2nd column data
				
				byte ar[] = b.getBytes(1,(int)b.length()); // 1 means first image
				
				// File output
				FileOutputStream fout = new FileOutputStream("D://Pratiks/applesql.jpg"); // we can give any name instead of applesql + extension like png and others
				
				fout.write(ar);
				
				fout.close();
			}
			System.out.println("Done");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}