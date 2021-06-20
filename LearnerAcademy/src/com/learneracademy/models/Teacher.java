package com.learneracademy.models;

public class Teacher {

	private int teacherid;
	private String teachername;
	private String teacherlocation;
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeacherlocation() {
		return teacherlocation;
	}
	public void setTeacherlocation(String teacherlocation) {
		this.teacherlocation = teacherlocation;
	}
	@Override
	public String toString() {
		return "Teacher [teacherid=" + teacherid + ", teachername=" + teachername + ", teacherlocation="
				+ teacherlocation + "]";
	}
	public Teacher(int teacherid, String teachername, String teacherpassword) {
		super();
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.teacherlocation = teacherlocation;
	}
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
