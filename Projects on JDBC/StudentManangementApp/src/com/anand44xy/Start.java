package com.anand44xy;

import java.util.Scanner;
import com.student.management.Student;
import com.student.management.StudentDao;

public class Start {

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int choice;
            System.out.println("Welcome to Student Management App");
            System.out.println("_________________________________");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Display Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit App");

            while (true) {
                System.out.println("Enter your choice:");
                choice = scn.nextInt();
                scn.nextLine(); // Consume the newline character

                switch (choice) {
                case 1: // Add Student
                    int id;
                    try {
                        System.out.println("Enter the user ID: ");
                        id = scn.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for the user ID.");
                        scn.nextLine(); // Consume the invalid input
                        break; // Exit the case
                    }
                    scn.nextLine(); // Consume the newline character

                    System.out.println("Enter the user name: ");
                    String name = scn.nextLine();
                    System.out.println("Enter the user phoneNo: ");
                    String phone = scn.nextLine();
                    System.out.println("Enter the user city: ");
                    String city = scn.nextLine();

                    // Create student object to store student
                    Student st = new Student(id, name, phone, city);

                    boolean answer = StudentDao.insertStudentToDB(st);

                    if (answer) {
                        System.out.println("Student added successfully");
                    } else {
                        System.out.println("Something went wrong!");
                    }

                    System.out.println(st);
                    break;


                        
                    case 2: // Delete Student
                        System.out.println("Enter student id to delete: ");
                        int userId=Integer.parseInt(scn.nextLine());
                        
                        boolean answer1=StudentDao.deleteStudent(userId);
                        
                        if (answer1) {
                            System.out.println("Delete Successfully");
                        } else {
                            System.out.println("Something went wrong!");
                        }
                        break;

                        
                    case 3: // Display Student
                        StudentDao.showAllStudents();
                        break;
                    
                    case 4://Update Student
                        try (Scanner scn1 = new Scanner(System.in)) {
                            System.out.println("Enter student ID to update: ");
                            int studentId;
                            try {
                                studentId = Integer.parseInt(scn1.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid student ID! Please enter a valid integer.");
                                return; // Exit the method
                            }

                            System.out.println("Enter new name: ");
                            String newName = scn1.nextLine();

                            System.out.println("Enter new phone number: ");
                            String newPhone = scn1.nextLine();

                            System.out.println("Enter new city: ");
                            String newCity = scn1.nextLine();

                            boolean updateResult = StudentDao.updateStudent(studentId, newName, newPhone, newCity);

                            if (updateResult) {
                                System.out.println("Student information updated successfully.");
                            } else {
                                System.out.println("Failed to update student information. Student ID may not exist.");
                            }
                        }

                    case 5://Exit App
                        System.out.println("Thank you for using our services. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            }
        }
    }
}
