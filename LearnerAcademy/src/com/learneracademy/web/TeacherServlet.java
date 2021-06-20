package com.learneracademy.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.StudentDAO;
import com.learneracademy.dao.TeacherDAO;
import com.learneracademy.models.Student;
import com.learneracademy.models.Teacher;


public class TeacherServlet extends HttpServlet {
	
	TeacherDAO teacherDAO;
	private static final long serialVersionUID = 1L;
       
	
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    public void init() {
		
		  String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
		  String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
		  String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); 
		  teacherDAO = new TeacherDAO(jdbcURL, jdbcUsername, jdbcPassword);
		 
		
		
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
				action = "/listTeacher";
			}

			switch (action) {
			case "/newTeacher":
				newTeacherForm(request, response);
				break;

			case "/insertTeacher":
				insertTeacher(request, response);
				break;

			case "/listTeacher":
				listTeacher(request, response);
				break;
				
			case "/list":
				listTeacher(request, response);

			case "/deleteTeacher":
				deleteTeacher(request, response);
				break;

			case "/updateTeacher":
				updateTeacher(request, response);
				break;

			default:
				listTeacher(request, response);
				break;
			}
			// listEmployees(request, response);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

    
    private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setTeachername(request.getParameter("teachername"));
		teacher.setTeacherlocation(request.getParameter("teacherlocation"));
		teacherDAO.insertTeacher(teacher);
		response.sendRedirect("listTeacher");

	}

	


	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("teacherid"));
        String name = request.getParameter("teachername");
        String location = request.getParameter("teacherlocation");
        
        Teacher teacher = new Teacher(id, name, location);
        teacherDAO.updateTeacher(teacher);
        response.sendRedirect("listTeacher");
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		// TODO Auto-generated method stub
		int teacherid = Integer.parseInt(request.getParameter("teacherid"));
		TeacherDAO.deleteTeacher(teacherid);
		response.sendRedirect("listTeacher");

		

	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List < Teacher > teacherList = teacherDAO.getAllTeacher();
        request.setAttribute("TEACHERS", teacherList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher.jsp");
        dispatcher.forward(request, response);
		
	}

	
	private void newTeacherForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("newTeacherForm.jsp");
		dispatcher.forward(request, response);

	}



}
