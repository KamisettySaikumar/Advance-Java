package com.sai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
@WebServlet("/CalculatorSetvlet")
public class CalculatorSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the data
	
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String operation=request.getParameter("operation");
		//process data
		int result=0;
		switch(operation) {
		case "+": result=num1+num2;
		         break;
		case "-":result=num1-num2;
        break;
		case "*":result=num1*num2;
        break;
		case "/":result=num1/num2;
        break;
		case "%":result=num1%num2;
        break;
		}
		//render response
		 PrintWriter writer=response.getWriter();
		 writer.println("<html>");
		 
		 writer.println("<body bgcolor=pink>");
		 writer.println("<h1>Calculated result</h1>");
		 writer.println("<p>First number: " + num1 + "</p>");
		 writer.println("<p>Second Number: "+num2+"</p>");
		 writer.println("<p>Operation:"+operation+"</p>");
		 writer.println("<p>result:"+result+"</p>");
		

	}
	}
