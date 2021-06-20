package com.learneracademy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.learneracademy.models.Classs;
import com.learneracademy.models.Student;
import com.learneracademy.models.Subject;
import com.learneracademy.models.Teacher;

public class ReportDAO {

	
	 private static String jdbcURL; 
	  private static String jdbcUsername; 
	  private static String jdbcPassword; 
	  private static Connection jdbcConnection;
	  
	  public ReportDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		  
	  this.jdbcURL = jdbcURL; 
	  this.jdbcUsername = jdbcUsername; 
	  this.jdbcPassword = jdbcPassword; }
	  
	  static void connect() throws SQLException{ 
		  if(jdbcConnection == null || jdbcConnection.isClosed()) { 
			  try { 
				  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	  }
	  
			  catch(Exception ex) { 
				  System.out.println(ex.getMessage()); 
			  } 
			  jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
			  } 
		  }
	 
   public ReportDAO() {}
   
   public List<Classs> getAllClasss(){
		
		List<Classs> classsList = new ArrayList<Classs>();
		
			try {
				connect();
				PreparedStatement statement = jdbcConnection.prepareStatement("select * from classs");
				ResultSet rs= statement.executeQuery();
			
				while (rs.next()) {
				//System.out.println(rs.getInt(1)+" : "+ rs.getString(2)+" : "+ rs.getString(3));
				
				Classs classs = new Classs();
				classs.setClasssid(rs.getInt(1));
				classs.setClasssname(rs.getString(2));
				
				System.out.println(classs);
				classsList.add(classs);
				
			}
			
			
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return classsList;
		
	}
	
	
   
   public List<Subject> getAllSubject(){
		
		List<Subject> subjectList = new ArrayList<Subject>();
		
			try {
				connect();
				PreparedStatement statement = jdbcConnection.prepareStatement("select * from subjects");
				ResultSet rs= statement.executeQuery();
			
				while (rs.next()) {
				//System.out.println(rs.getInt(1)+" : "+ rs.getString(2)+" : "+ rs.getString(3));
				
				Subject subject = new Subject();
				subject.setSubjectid(rs.getInt(1));
				subject.setSubjectname(rs.getString(2));
				subject.setTeachername(rs.getString(3));
				subject.setTeacherid(rs.getInt(4));
				subject.setClasssid(rs.getInt(5));
				System.out.println(subject);
				subjectList.add(subject);
				
			}
			
			
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return subjectList;
		
	}
   
   
   
   
  	public List<Student> getAllStudent(){
  		
  		List<Student> studentList = new ArrayList<Student>();
  		
  		
  		
  		
  		
  		//try (Connection connection = getConnection();

  	            // Step 2:Create a statement using connection object
  	           // PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
  	           // System.out.println(preparedStatement);
  	           // ResultSet rs= preparedStatement.executeQuery();
  	            
  		
  			try {
  				connect();
  				PreparedStatement statement = jdbcConnection.prepareStatement("select * from students");
  				ResultSet rs= statement.executeQuery();
  			
  				while (rs.next()) {
  				//System.out.println(rs.getInt(1)+" : "+ rs.getString(2)+" : "+ rs.getString(3));
  				
  				Student student = new Student();
  				student.setStudentid(rs.getInt(1));
  				student.setStudentname(rs.getString(2));
  				student.setStudentlocation(rs.getString(3));
  				System.out.println(student);
  				studentList.add(student);
  				
  			}
  			
  			
  		}
  		
  		catch(Exception ex) {
  			System.out.println(ex.getMessage());
  		}
  		
  		return studentList;
  		
  	}
   
   
  	
public List<Teacher> getAllTeacher(){
		
		List<Teacher> teacherList = new ArrayList<Teacher>();
		
		
		
		
		
		//try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	           // PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	           // System.out.println(preparedStatement);
	           // ResultSet rs= preparedStatement.executeQuery();
	            
		
			try {
				connect();
				PreparedStatement statement = jdbcConnection.prepareStatement("select * from teachers");
				ResultSet rs= statement.executeQuery();
			
				while (rs.next()) {
				//System.out.println(rs.getInt(1)+" : "+ rs.getString(2)+" : "+ rs.getString(3));
				
				Teacher teacher = new Teacher();
				teacher.setTeacherid(rs.getInt(1));
				teacher.setTeachername(rs.getString(2));
				teacher.setTeacherlocation(rs.getString(3));
				System.out.println(teacher);
				teacherList.add(teacher);
				
			}
			
			
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return teacherList;
		
	}
   
   
   
   
}
