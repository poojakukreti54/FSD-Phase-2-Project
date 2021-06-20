package com.learneracademy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learneracademy.models.Student;
import com.learneracademy.models.Classs;

public class ClasssDAO {

	
	 private static String jdbcURL; 
	  private static String jdbcUsername; 
	  private static String jdbcPassword; 
	  private static Connection jdbcConnection;
	  
	  public ClasssDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		  
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
	 
   public ClasssDAO() {}
   
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
				classs.setSubjectname(rs.getString(3));
				System.out.println(classs);
				classsList.add(classs);
				
			}
			
			
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return classsList;
		
	}
	
	public void insertClasss(Classs adm) {
		//System.out.println(INSERT_USERS_SQL);
		//try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
         
		
		try {
			connect();
			PreparedStatement preparedStatement = jdbcConnection.prepareStatement
					("insert into classs(classsname,subjectname) values(?,?)");
			
		
		
			preparedStatement.setString(1, adm.getClasssname());
			preparedStatement.setString(2, adm.getSubjectname());
          
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
          
           
       } catch (SQLException e) {
           printSQLException(e);
       }
		
	}

	public static boolean deleteClasss(int classsid) throws SQLException {
		
		
		
		boolean rowDeleted;
       //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
           
		try {
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement
					("delete from classs where classsid=?");
			
			statement.setInt(1, classsid);
			rowDeleted = statement.executeUpdate() > 0;
       }finally {
       }
      return rowDeleted;
		}
		
       
       public boolean updateClasss(Classs classs) throws SQLException {
          boolean rowUpdated = false;
           //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
             
           
           try {
   			connect();
   			PreparedStatement statement = jdbcConnection.prepareStatement
   					("update classs set classsname = ?,subjectname=? where classsid = ?;");
   			
           
   			statement.setString(1, classs.getClasssname());
   			statement.setString(2, classs.getSubjectname());
            
               statement.setInt(3, classs.getClasssid());
               // statement.executeUpdate()
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
