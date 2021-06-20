package com.learneracademy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.ClasssDAO;
import com.learneracademy.dao.ReportDAO;
import com.learneracademy.dao.StudentDAO;
import com.learneracademy.dao.SubjectDAO;
import com.learneracademy.dao.TeacherDAO;
import com.learneracademy.models.Classs;
import com.learneracademy.models.Student;
import com.learneracademy.models.Subject;
import com.learneracademy.models.Teacher;

public class ReportServlet extends HttpServlet {
	
	ReportDAO classsDAO;
	ReportDAO studentDAO;
	ReportDAO subjectDAO;
	ReportDAO teacherDAO;
	
	
	
	
	/*
	ClasssDAO classsDAO;
	StudentDAO studentDAO;
	SubjectDAO subjectDAO;
	TeacherDAO teacherDAO;
	*/

	private static final long serialVersionUID = 1L;
       
    
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String action = request.getServletPath();
			//System.out.println(action);

			try {

				// String action = request.getParameter("command");

				// if the command is missing, then default to listing students
				if (action == null) {
					action = "/report";
				}

				switch (action) {
					
				case "/report":
					reportClass(request, response);
				case "/reportClass":
					reportClass(request, response);

				default:
					reportClass(request, response);
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
	       

			
			List < Student > studentList = studentDAO.getAllStudent();
	        request.setAttribute("STUDENTS", studentList);
	        RequestDispatcher dispatcher2 = request.getRequestDispatcher("classreport.jsp");
	        dispatcher2.forward(request, response);
			
	        
	        
	        List < Subject > subjectList = subjectDAO.getAllSubject();
	        request.setAttribute("SUBJECTS", subjectList);
	        RequestDispatcher dispatcher3 = request.getRequestDispatcher("classreport.jsp");
	        dispatcher3.forward(request, response);
	        

			List < Teacher > teacherList = teacherDAO.getAllTeacher();
	        request.setAttribute("TEACHERS", teacherList);
	        RequestDispatcher dispatcher4 = request.getRequestDispatcher("classreport.jsp");
	        dispatcher4.forward(request, response);
			
	        
			
		}

			
		   /*
				 * Subject subject = new Subject();
				 * subject.setSubjectname(request.getParameter("subjectname"));
				 * subject.setStudentlocation(request.getParameter("teachername"));
				 * subjectDAO.insertStudent(subject); response.sendRedirect("listClasss");
				 */

		}


