package com.learneracademy.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.SubjectDAO;
import com.learneracademy.models.Subject;

/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
	SubjectDAO subjectDAO;
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    public void init() {
		
		  String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
		  String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
		  String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); 
		  subjectDAO = new SubjectDAO(jdbcURL, jdbcUsername, jdbcPassword);
		 
		
		
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
				action = "/listSubject";
			}

			switch (action) {
			case "/newSubject":
				newSubjectForm(request, response);
				break;

			case "/insertSubject":
				insertSubject(request, response);
				break;

			case "/listSubject":
				listSubject(request, response);
				break;
				
			case "/list":
				listSubject(request, response);

			case "/deleteSubject":
				deleteSubject(request, response);
				break;

			case "/updateSubject":
				updateSubject(request, response);
				break;

			default:
				listSubject(request, response);
				break;
			}
			// listEmployees(request, response);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	


	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("subjectid"));
        String name = request.getParameter("subjectname");
        
        Subject subject = new Subject(id, name);
        subjectDAO.updateSubject(subject);
        response.sendRedirect("listSubject");
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		// TODO Auto-generated method stub
		int subjectid = Integer.parseInt(request.getParameter("subjectid"));
		SubjectDAO.deleteSubject(subjectid);
		response.sendRedirect("listSubject");
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List < Subject > subjectList = subjectDAO.getAllSubject();
        request.setAttribute("SUBJECTS", subjectList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("subject.jsp");
        dispatcher.forward(request, response);
		
	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Subject subject = new Subject();
		//Subject subjectid = new Subject();
		subject.setSubjectname(request.getParameter("subjectname"));
		subject.setTeachername(request.getParameter("teachername"));
		int subjectid = Integer.parseInt(request.getParameter("teacherid"));
		subject.setTeacherid(subjectid);
		int subjectid2 = Integer.parseInt(request.getParameter("classsid"));
		subject.setTeacherid(subjectid2);
		
		
		subjectDAO.insertSubject(subject);
		response.sendRedirect("listSubject");

	}

	private void newSubjectForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("newSubjectForm.jsp");
		dispatcher.forward(request, response);

	}



	
	
	
	
}
