package com.student.management;

public class Student {

	    private int studentId;
	    private String studentName;
	    private String studentPhone;
	    private String studentCity;

	    public Student(int studentId, String studentName, String studentPhone, String studentCity) {
	        this.studentId=studentId;
	        this.studentName = studentName;
	        this.studentPhone = studentPhone;
	        this.studentCity = studentCity;
	    }

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getStudentPhone() {
			return studentPhone;
		}

		public void setStudentPhone(String studentPhone) {
			this.studentPhone = studentPhone;
		}

		public String getStudentCity() {
			return studentCity;
		}

		public void setStudentCity(String studentCity) {
			this.studentCity = studentCity;
		}
		
		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}


		public Student() {
			super();
			
		}

		

		@Override
		public String toString() {
			return "Student [studentName=" + studentName + ", studentPhone=" + studentPhone + ", studentCity="
					+ studentCity + ", studentId=" + studentId + "]";
		}

	

	
	
	

}
