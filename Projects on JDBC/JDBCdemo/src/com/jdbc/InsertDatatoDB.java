package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDatatoDB {
	public static void main(String[] args) {
		//Create Table in database
		try {
	    	 //load Driver
	    	 Class.forName("com.mysql.jdbc.Driver");
	    	 
	    	 //Creating Connection
	    	 String url="jdbc:mysql://localhost:3306/employee";
	    	 String username="Anand";
	    	 String password="8550";
	    	 
	    	 Connection con=DriverManager.getConnection(url,username,password);
	    	 
	    	 //Create static query
	    	 String q="CREATE TABLE employeeData(eId int(50) primary key auto_increment, eName varchar(200) not null, eCity varchar(400))";
	    	 
	    	 //Create Statement
	    	 Statement stmt=con.createStatement();
	    	 stmt.executeUpdate(q);
	    	 System.out.println("Table created in database successfully");
	    	 con.close();
	    	 
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}
     
}
