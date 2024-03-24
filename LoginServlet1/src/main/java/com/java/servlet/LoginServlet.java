package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.WriteAbortedException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String Status;
		if(username.equals("Sathya")&&password.equals("Sai@1234"))
		{
		
			Status="Login Successfull";
		}
		
		
		else
		{
			Status="Login Fail";
		}
		
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Login Status </h1>"+Status);
		writer.println("</html>");
	}
}

