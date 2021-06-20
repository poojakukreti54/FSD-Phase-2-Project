package com.learneracademy.models;

public class Report {
	
	private int classsid;
	private String classsname;
	private String subjectname;
	
	

	private int subjectid;
	private String teachername;
	private int teacherid;
	
	
	private int studentid;
	private String studentname;
	private String studentlocation;
	
	private String teacherlocation;

	public int getClasssid() {
		return classsid;
	}

	public void setClasssid(int classsid) {
		this.classsid = classsid;
	}

	public String getClasssname() {
		return classsname;
	}

	public void setClasssname(String classsname) {
		this.classsname = classsname;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

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

	public String getTeacherlocation() {
		return teacherlocation;
	}

	public void setTeacherlocation(String teacherlocation) {
		this.teacherlocation = teacherlocation;
	}

	public Report(int classsid, String classsname, String subjectname) {
		super();
		this.classsid = classsid;
		this.classsname = classsname;
		this.subjectname = subjectname;
	}

	public Report(int classsid, String subjectname, int subjectid, String teachername, int teacherid) {
		super();
		this.classsid = classsid;
		this.subjectname = subjectname;
		this.subjectid = subjectid;
		this.teachername = teachername;
		this.teacherid = teacherid;
	}

	public Report(String classsname, String teachername, int teacherid, String teacherlocation) {
		super();
		this.classsname = classsname;
		this.teachername = teachername;
		this.teacherid = teacherid;
		this.teacherlocation = teacherlocation;
	}

	
	
	
	

}
