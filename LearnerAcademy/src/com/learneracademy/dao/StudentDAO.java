package com.learneracademy.dao;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.learneracademy.models.Student;

public class StudentDAO {
	
	
	//private static String jdbcURL = "jdbc:mysql://localhost:3306/learner_academy_db?useSSL=false";
    //private static String jdbcUsername = "root";
    //private static String jdbcPassword = "Call@100";

    //private static final String INSERT_USERS_SQL = "INSERT INTO students" + "(studentname, studentlocation) VALUES "+" (?, ?);";

    //private static final String SELECT_USER_BY_ID = "select studentid,studentname,studentlocation from students where studentid =?";
    //private static final String SELECT_ALL_USERS = "select * from students";
    //private static final String DELETE_USERS_SQL = "delete from students where studentid = ?;";
    //private static final String UPDATE_USERS_SQL = "update students set studentname = ?,studentlocation= ? where studentid = ?;";


	
	 
	  private static String jdbcURL; 
	  private static String jdbcUsername; 
	  private static String jdbcPassword; 
	  private static Connection jdbcConnection;
	  
	  public StudentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		  
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
	 
    public StudentDAO() {}
    
    
    /*
    
    protected Connection getConnection() {
        Connection connection = null;
        if (connection==null){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
        return connection;
    }
    
    */
    
    
    
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
	
	public void insertStudent(Student adm) {
		//System.out.println(INSERT_USERS_SQL);
		//try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
          
		
		try {
			connect();
			PreparedStatement preparedStatement = jdbcConnection.prepareStatement
					("Insert into students(studentname, studentlocation) values(?,?)");
			
		
		
			preparedStatement.setString(1, adm.getStudentname());
            preparedStatement.setString(2, adm.getStudentlocation());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
           
            
        } catch (SQLException e) {
            printSQLException(e);
        }
		
	}

	public static boolean deleteStudent(int studentid) throws SQLException {
		
		
		
		boolean rowDeleted;
        //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            
		try {
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement
					("delete from students where studentid=?");
			
			statement.setInt(1, studentid);
            rowDeleted = statement.executeUpdate() > 0;
        }finally {
        }
       return rowDeleted;
		}
		
		
		/*
		 * try {
		 * 
		 * 
		 * connect();
		 * 
		 * 
		 * PreparedStatement statement = jdbcConnection.prepareStatement
		 * ("delete from student where id=?"); statement.setInt(1, id);
		 * //statement.setString(2, adm.getStudentlocation()); int rows=
		 * statement.executeUpdate();
		 * 
		 * if (rows>0) { //System.out.println(rs.getInt(1)+" : "+ rs.getString(2)+" : "+
		 * rs.getString(3));
		 * 
		 * System.out.println("Admin deleted successfully"); } else {
		 * System.out.println("there is some error while deleting admin"); }
		 * 
		 * jdbcConnection.close();
		 * 
		 * 
		 * 
		 * } catch(Exception ex) { ex.printStackTrace(); }
		 */
        
        
        public boolean updateAdmin(Student student) throws SQLException {
           boolean rowUpdated = false;
            //try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
              
            
            try {
    			connect();
    			PreparedStatement statement = jdbcConnection.prepareStatement
    					("update students set studentname = ?,studentlocation= ? where studentid = ?;");
    			
            
    			statement.setString(1, student.getStudentname());
                statement.setString(2, student.getStudentlocation());
                statement.setInt(3, student.getStudentid());
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
        }}
	
	
