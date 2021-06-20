package com.learneracademy.web;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.StudentDAO;
import com.learneracademy.models.Student;
/*@WebServlet("/")
*/

public class StudentServlet extends HttpServlet {

	//private AdminDAO adminDAO;
	StudentDAO studentDAO;
	
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		
		  String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
		  String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
		  String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); 
		  studentDAO = new StudentDAO(jdbcURL, jdbcUsername, jdbcPassword);
		 
		
		
		//adminDAO= new AdminDAO();
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		//System.out.println(action);

		try {

			// String action = request.getParameter("command");

			// if the command is missing, then default to listing students
			if (action == null) {
				action = "/listAdmin";
			}

			switch (action) {
			case "/newStudent":
				newStudentForm(request, response);
				break;

			case "/insertStudent":
				insertStudent(request, response);
				break;

			case "/listStudent":
				listStudent(request, response);
				break;
		
			case "/deleteStudent":
				deleteStudent(request, response);
				break;

			case "/updateStudent":
				updateStudent(request, response);
				break;

			default:
				listStudent(request, response);
				break;
			}
			// listEmployees(request, response);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("studentid"));
        String name = request.getParameter("studentname");
        String location = request.getParameter("studentlocation");
        
        Student student = new Student(id, name, location);
        studentDAO.updateAdmin(student);
        response.sendRedirect("listStudent");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		// TODO Auto-generated method stub
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		StudentDAO.deleteStudent(studentid);
		response.sendRedirect("listStudent");

		/*
		 * 
		 * Admin admid = new Admin(); admid.setAdminid(request.getParameter("studentid"));
		 * adminDAO.deleteAdmin(admid);
		 * 
		 * 
		 * int admid = Integer.parseInt(request.getParameter("studentid")); //String admin
		 * = request.getParameter("studentid"); adminDAO.deleteAdmin(admid);
		 * 
		 * listAdmin(request, response);
		 * 
		 * 
		 * if (request.getAttribute("studentid") == null) { System.out.println("bye"); }
		 * else { System.out.println(request.getParameter("studentid")); } // int id =
		 * Integer.parseInt(request.getParameter("deptid")); PrintWriter out =
		 * response.getWriter(); out.println("deleting admin...");
		 */

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List < Student > studentList = studentDAO.getAllStudent();
        request.setAttribute("STUDENTS", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
        dispatcher.forward(request, response);
		
		
		

		/*
		 * List<Admin> adminList = adminDAO.getAllAdmin();
		 * request.setAttribute("ADMINS", adminList); RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("admin.jsp"); dispatcher.forward(request,
		 * response);
		 */
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStudentname(request.getParameter("studentname"));
		student.setStudentlocation(request.getParameter("studentlocation"));
		studentDAO.insertStudent(student);
		response.sendRedirect("listStudent");

	}

	private void newStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("newStudentForm.jsp");
		dispatcher.forward(request, response);

	}

}
