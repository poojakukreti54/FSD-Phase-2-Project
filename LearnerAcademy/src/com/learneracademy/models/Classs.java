package com.learneracademy.models;

public class Classs {

	private int classsid;
	private String classsname;
	private String subjectname;
	
	
	
	
	
	public Classs(int classsid, String classsname, String subjectname) {
		super();
		this.classsid = classsid;
		this.classsname = classsname;
		this.subjectname = subjectname;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
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
	public Classs(int classsid, String classsname) {
		super();
		this.classsid = classsid;
		this.classsname = classsname;
	}
	@Override
	public String toString() {
		return "Classs [classsid=" + classsid + ", classsname=" + classsname + ", subjectname=" + subjectname + "]";
	}
	public Classs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
