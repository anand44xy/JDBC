package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TakeInput {
	public static void main(String[] args) {
		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Create connection
			String url = "jdbc:mysql://localhost:3306/employee";
			String username = "Anand";
			String password = "8550";
			Connection con = DriverManager.getConnection(url, username, password);

			// Create a dynamic query
			String q = "INSERT INTO employeeData (eId, eName, eCity) VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);

			Scanner scn = new Scanner(System.in);
			System.out.println("Enter employee ID: ");
			int eId = scn.nextInt();
			System.out.println("Enter employee Name:");
			String eName = scn.next();
			System.out.println("Enter employee City:");
			String eCity = scn.next();

			// Insert data
			pstmt.setInt(1, eId);
			pstmt.setString(2, eName);
			pstmt.setString(3, eCity);

			pstmt.executeUpdate(); // NOTE: don't pass q(query) again, if prepaedStatement

			System.out.println("Data inserted successfully...");
			scn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
