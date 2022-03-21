package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// to print output on browswer
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("txtuname");
		String passWord = request.getParameter("txtpword");
		
		//out.println("Welcome " +userName);
		//out.println("your password is " +passWord);
		
		if (userName.equalsIgnoreCase("admin") && passWord.equals("admin@123")) 
		{
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.html");
				rd.forward(request, response);
		}
		else 
		{
			out.println("Invalid user name or password:  ");
			out.println("");
			out.println("Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
	}
}


