package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
	    boolean success = false;
	    try {
	        // jdbc Code...
	        Connection con = CP.CreateC();
	        String q = "INSERT INTO students(sid, sname, sphone, scity) VALUES(?,?,?,?)";

	        // PreparedStatement
	        PreparedStatement pstmnt = con.prepareStatement(q);

	        // Set the values of parameters
	        pstmnt.setInt(1, st.getStudentId());
	        pstmnt.setString(2, st.getStudentName());
	        pstmnt.setString(3, st.getStudentPhone());
	        pstmnt.setString(4, st.getStudentCity());

	        // execute...
	        pstmnt.executeUpdate();
	        success = true;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}

	public static boolean deleteStudent(int userId) {
		boolean success=false;
		try {
			//jdbc Code...
			Connection con=CP.CreateC();
			String q="DELETE FROM students WHERE sid=?";
			
			//PreparedStatement
			PreparedStatement pstmnt=con.prepareStatement(q);
		    
			//Set the values of parameter
			pstmnt.setInt(1, userId);
			
			//execute...
			pstmnt.executeUpdate();
			success=true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
		
	}

	public static void showAllStudents() {
	    try {
	        // jdbc Code...
	        Connection con = CP.CreateC();
	        String q = "SELECT * FROM students;";

	        java.sql.Statement stmt = con.createStatement();
	        ResultSet set = stmt.executeQuery(q);

	        while (set.next()) {
	            int id = set.getInt("sid"); 
	            String name = set.getString("sname"); 
	            String phone = set.getString("sphone"); 
	            String city = set.getString("scity"); //

	            System.out.println("ID: " + id);
	            System.out.println("Name: " + name);
	            System.out.println("Phone: " + phone);
	            System.out.println("City: " + city);
	            System.out.println("++++++++++++++++++++");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static boolean updateStudent(int studentId, String newName, String newPhone, String newCity) {
	    boolean success = false;
	    try {
	        // JDBC Code...
	        Connection con = CP.CreateC();
	        String q = "UPDATE students SET sname=?, sphone=?, scity=? WHERE sid=?";

	        // PreparedStatement
	        PreparedStatement pstmnt = con.prepareStatement(q);

	        // Set the values of parameters
	        pstmnt.setString(1, newName);
	        pstmnt.setString(2, newPhone);
	        pstmnt.setString(3, newCity);
	        pstmnt.setInt(4, studentId);

	        // execute...
	        int rowsUpdated = pstmnt.executeUpdate();
	        if (rowsUpdated > 0) {
	            success = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}


	
     
}
