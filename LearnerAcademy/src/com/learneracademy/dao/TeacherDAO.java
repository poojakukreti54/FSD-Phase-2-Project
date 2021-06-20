package com.learneracademy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learneracademy.models.Student;
import com.learneracademy.models.Teacher;

public class TeacherDAO {

	
	 private static String jdbcURL; 
	  private static String jdbcUsername; 
	  private static String jdbcPassword; 
	  private static Connection jdbcConnection;
	  
	  public TeacherDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		  
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
	 
   public TeacherDAO() {}
   
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
	
	public void insertTeacher(Teacher adm) {
		//System.out.println(INSERT_USERS_SQL);
		//try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
         
		
		try {
			connect();
			PreparedStatement preparedStatement = jdbcConnection.prepareStatement
					("insert into teachers(teachername, teacherlocation) values(?,?)");
			
		
		
			preparedStatement.setString(1, adm.getTeachername());
            preparedStatement.setString(2, adm.getTeacherlocation());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
          
           
       } catch (SQLException e) {
           printSQLException(e);
       }
		
	}

	public static boolean deleteTeacher(int teacherid) throws SQLException {
		
		
		
		boolean rowDeleted;
       //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
           
		try {
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement
					("delete from teachers where teacherid=?");
			
			statement.setInt(1, teacherid);
			rowDeleted = statement.executeUpdate() > 0;
       }finally {
       }
      return rowDeleted;
		}
		
       
       public boolean updateTeacher(Teacher teacher) throws SQLException {
          boolean rowUpdated = false;
           //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
             
           
           try {
   			connect();
   			PreparedStatement statement = jdbcConnection.prepareStatement
   					("update teachers set teachername = ?,teacherlocation= ? where teacherid = ?;");
   			
           
   			statement.setString(1, teacher.getTeachername());
               statement.setString(2, teacher.getTeacherlocation());
               statement.setInt(3, teacher.getTeacherid());
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
