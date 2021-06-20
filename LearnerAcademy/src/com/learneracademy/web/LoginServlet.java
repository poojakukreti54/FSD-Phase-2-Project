package com.learneracademy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		response.setContentType("text/html");
		
		if(username.equals("Admin") && password.equals("Admin")){
			HttpSession session = request.getSession();
			session.setAttribute("uname", username);
			response.sendRedirect("dashboard.html");
		}
	
		else {
			RequestDispatcher dispatcher= request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
			out.println("<h2  style= 'color:red';> + '  ' + '  '  + invalid credentials");
		}
	
	
	}
	
	

}
