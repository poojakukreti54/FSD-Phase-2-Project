package com.learneracademy.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.ClasssDAO;
import com.learneracademy.dao.SubjectDAO;
import com.learneracademy.models.Classs;
import com.learneracademy.models.Subject;

/**
 * Servlet implementation class SubjectServlet
 */
public class ClasssServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
	ClasssDAO classsDAO;
    public ClasssServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    public void init() {
		
		  String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
		  String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
		  String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); 
		  classsDAO = new ClasssDAO(jdbcURL, jdbcUsername, jdbcPassword);
		 
		
		
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
				action = "/listClasss";
			}

			switch (action) {
			case "/newClasss":
				newClasssForm(request, response);
				break;

			case "/insertClasss":
				insertClasss(request, response);
				break;

			case "/listClasss":
				listClasss(request, response);
				break;
				
			case "/report":
				reportClass(request, response);

			case "/deleteClasss":
				deleteClasss(request, response);
				break;

			case "/updateClasss":
				updateClasss(request, response);
				break;

			default:
				listClasss(request, response);
				break;
			}
			// listEmployees(request, response);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	


	private void reportClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List < Classs > classsList = classsDAO.getAllClasss();
        request.setAttribute("CLASS", classsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classreport.jsp");
        dispatcher.forward(request, response);
		
	}



	private void updateClasss(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("classsid"));
        String name = request.getParameter("classsname");
        String subjectname = request.getParameter("subjectname");
        
        Classs subject = new Classs(id, name,subjectname);
        classsDAO.updateClasss(subject);
        response.sendRedirect("listClasss");
	}

	private void deleteClasss(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		// TODO Auto-generated method stub
		int classsid = Integer.parseInt(request.getParameter("classsid"));
		ClasssDAO.deleteClasss(classsid);
		response.sendRedirect("listClasss");
	}

	private void listClasss(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List < Classs > classsList = classsDAO.getAllClasss();
        request.setAttribute("CLASS", classsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classs.jsp");
        dispatcher.forward(request, response);
		
	}

	private void insertClasss(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Classs classs = new Classs();
		classs.setClasssname(request.getParameter("classsname"));
		classs.setSubjectname(request.getParameter("subjectname"));
		
		classsDAO.insertClasss(classs);
		response.sendRedirect("listClasss");

	}

	private void newClasssForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("newClasssForm.jsp");
		dispatcher.forward(request, response);

	}



	
	
	
	
}
