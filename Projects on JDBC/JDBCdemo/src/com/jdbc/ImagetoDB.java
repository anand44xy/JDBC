package com.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*/
 * store images(lesser size or single) to database
 */
public class ImagetoDB {
	public static void main(String[] args) {
		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "Anand", "8550");

			// Create dynamic qurie
			String q = "INSERT INTO eImages(ePic) VALUES(?)";
			PreparedStatement pstmt = con.prepareStatement(q);

			FileInputStream fis = new FileInputStream("D:\\Anand's Stuff\\photos\\ganesha1.jpg");// to read file this
																									// method is used
																									// here
			pstmt.setBinaryStream(1, fis, fis.available());// it gives the available memory in fis
			pstmt.executeUpdate();

			System.out.println("Image saved to Database successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
