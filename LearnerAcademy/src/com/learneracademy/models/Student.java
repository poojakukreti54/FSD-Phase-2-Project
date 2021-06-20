package com.learneracademy.models;

public class Student {
	
	
	private int studentid;
	private String studentname;
	private String studentlocation;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentlocation() {
		return studentlocation;
	}
	public void setStudentlocation(String studentlocation) {
		this.studentlocation = studentlocation;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentlocation="
				+ studentlocation + "]";
	}
	public Student(int studentid, String studentname, String studentlocation) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentlocation = studentlocation;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
