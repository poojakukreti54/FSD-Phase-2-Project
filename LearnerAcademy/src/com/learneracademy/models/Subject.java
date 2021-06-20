package com.learneracademy.models;

public class Subject {

	private int subjectid;
	private String subjectname;
	private String teachername;
	private int teacherid;
	private int classsid;
	
	
	
	
	
	public Subject(int subjectid, String subjectname, String teachername, int teacherid, int classsid) {
		super();
		this.subjectid = subjectid;
		this.subjectname = subjectname;
		this.teachername = teachername;
		this.teacherid = teacherid;
		this.classsid = classsid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getClasssid() {
		return classsid;
	}
	public void setClasssid(int classsid) {
		this.classsid = classsid;
	}
	public Subject(int subjectid, String subjectname, String teachername) {
		super();
		this.subjectid = subjectid;
		this.subjectname = subjectname;
		this.teachername = teachername;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", subjectname=" + subjectname + "]";
	}
	public Subject(int subjectid, String subjectname) {
		super();
		this.subjectid = subjectid;
		this.subjectname = subjectname;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(String subjectname) {
		super();
		this.subjectname = subjectname;
	}
	
	
	
	
	
	
	
	
}
