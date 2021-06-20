package com.learneracademy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learneracademy.models.Subject;

public class SubjectDAO {

	

	 private static String jdbcURL; 
	  private static String jdbcUsername; 
	  private static String jdbcPassword; 
	  private static Connection jdbcConnection;
	  
	  public SubjectDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		  
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
	 
  public SubjectDAO() {}
  
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
	
	public void insertSubject(Subject adm) {
		
		try {
			connect();
			PreparedStatement preparedStatement = jdbcConnection.prepareStatement
					("Insert into subjects(subjectname,teachername,teacherid,classsid) values(?,?,?,?)");
			
		
		
			preparedStatement.setString(1, adm.getSubjectname());
			preparedStatement.setString(2, adm.getTeachername());
			preparedStatement.setInt(3, adm.getTeacherid());
			preparedStatement.setInt(4, adm.getClasssid());
          System.out.println(preparedStatement);
          preparedStatement.executeUpdate();
         
          
      } catch (SQLException e) {
          printSQLException(e);
      }
		
	}

	public static boolean deleteSubject(int subjectid) throws SQLException {
		
		
		
		boolean rowDeleted;
      //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
          
		try {
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement
					("delete from subjects where subjectid=?");
			
			statement.setInt(1, subjectid);
			rowDeleted = statement.executeUpdate() > 0;
      }finally {
      }
     return rowDeleted;
		}
		
      
      public boolean updateSubject(Subject subject) throws SQLException {
         boolean rowUpdated = false;
          //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            
          
          try {
  			connect();
  			PreparedStatement statement = jdbcConnection.prepareStatement
  					("update subjects set subjectname = ? where subjectid = ?;");
  			
          
  			statement.setString(1, subject.getSubjectname());
              statement.setInt(2, subject.getSubjectid());
              
              rowUpdated = statement.executeUpdate() > 0;
          }
          catch(Exception ex) { ex.printStackTrace(); }
          
          
          return rowUpdated;
      }
      
     
      private void printSQLException(SQLException ex) {
          for (Throwable e: ex) {
              if (e instanceof SQLException) {
                  e.printStackTrace(System.err);
                  System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                  System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                  System.err.println("Message: " + e.getMessage());
                  Throwable t = ex.getCause();
                  while (t != null) {
                      System.out.println("Cause: " + t);
                      t = t.getCause();
                  }
              }
		
		
	}
      }
	
	
	
	
	
	
}
