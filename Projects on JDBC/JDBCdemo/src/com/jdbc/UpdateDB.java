package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDB {
	public static void main(String[] args) {
		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "Anand", "8550");
            
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++
			// Show the current database table
			System.out.println("Curretn Database...");
			System.out.println("______________________");

			String q1 = "SELECT * FROM employeedata;";

			java.sql.Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q1);

			while (set.next()) {
				int id = set.getInt("eId");
				String name = set.getString("eName");
				String city = set.getString("eCity");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("City: " + city);
				System.out.println("----------------------");
			}
			System.out.println();
			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

			// Create parametrized query
			String q = "UPDATE employeedata SET eName=?, eCity=? WHERE eId=? ";

			System.out.println("Update the Employee Data");
			System.out.println("__________________________");
			System.out.println();

			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the new Name:");
			String eName = scn.next();
			System.out.println("Enter the new City:");
			String eCity = scn.next();
			System.out.println("Enter the ID:");
			int eId = scn.nextInt();

			PreparedStatement pstmt = con.prepareStatement(q);
			// Process data
			pstmt.setString(1, eName);
			pstmt.setString(2, eCity);
			pstmt.setInt(3, eId);

			pstmt.executeUpdate();

			System.out.println("Update Successfully.");

			// Close Connection
			scn.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
