package com.sai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class Registrationservlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 1: Read the data
	String UserName =request.getParameter("User Name");
	String Password=request.getParameter("Password");
	long mobile=Long.parseLong(request.getParameter("mobile"));
	
	String email=request.getParameter("email");
	String gender=request.getParameter("gender");
	String dob=request.getParameter("dob");
	
	String[] quals=request.getParameterValues("qualification");
	String country=request.getParameter("country");
	String[] lang=request.getParameterValues("languages");
	String Address=request.getParameter("Address");
	
	//step2: process the data
	String q=String.join(",", quals);
	String l=String.join("-", lang);
	
	//step3: Render the response
	response.setContentType("text/html");
	PrintWriter Writer=response.getWriter();
	Writer.println("<html>");
	Writer.println("<body bgcolor=pink>");
	Writer.println("your UserName:"+UserName);
	Writer.println("<br>");
	Writer.println("your Password:"+Password);
	Writer.println("<br>");
	Writer.println("your mobile:"+mobile);
	Writer.println("<br>");
	Writer.println("your email:"+email);
	Writer.println("<br>");
	Writer.println("your gender:"+gender);
	Writer.println("<br>");
	Writer.println("your dob:"+dob);
	Writer.println("<br>");
	Writer.println("your quals:"+quals);
	Writer.println("<br>");
	Writer.println("your country:"+country);
	Writer.println("<br>");
	Writer.println("your lang:"+lang);
	Writer.println("<br>");
	Writer.println("your Address:"+Address);
	Writer.println("<br>");
	
	Writer.println("</body>");
	Writer.println("</html>");
	
}
}