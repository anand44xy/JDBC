package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;

    public static Connection CreateC() {
        try {
            // Load the new MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the connection
            String user = "Anand";
            String password = "8550";
            String url = "jdbc:mysql://localhost:3306/student_management";
            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
