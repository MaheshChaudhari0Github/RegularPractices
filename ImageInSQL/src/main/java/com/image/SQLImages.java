package com.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLImages {
	public static void main(String[] args) throws IOException, FileNotFoundException, SQLException {

		Connection con = null;

		try { // 1. Load Class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Image", "root", "Mahesh@472001");

			// Query
			String insert = "insert into images(image_id,image) values (?,?)";

			// Prepared Statement
			PreparedStatement ps = con.prepareStatement(insert);

			// Set the value
			ps.setInt(1, 1);

			// Creating file with object
			File f = new File("D://Pratiks/apple.jpg");

			// File as a input
			FileInputStream fi = new FileInputStream(f);

			// Set a file
			ps.setBinaryStream(2, fi, fi.available());

			// Execute
			int i = ps.executeUpdate(); // REPLACEMENT

			// ps.executeUpdate();

			System.out.println("Image Inserted " + i + " Sucess");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally { // Close the connection
			con.close();
		}
	}
}