package com.sai.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/.CookiesThirdServlet")
public class CookiesThirdServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the requested form data
		 String email=request.getParameter("email");
		 String phone=request.getParameter("phone");
		 //create cookie object
		 Cookie cookie5=new Cookie("email","email");
		 Cookie cookie6=new Cookie("phone","phone");
		 //add cookie into response object
		 response.addCookie(cookie5);
		 response.addCookie(cookie6);
		 response.setContentType("text/html");
		 PrintWriter writer=response.getWriter();
		 Cookie[] cookies=request.getCookies();
		 writer.println("<html>");
		 writer.println("<body style=color:red>");
		 writer.println("<pre>");
		 writer.println("Username:"+cookies[0].getValue());
		 writer.println("age:"+cookies[1].getValue());
		 writer.println("qualification:"+cookies[2].getValue());
		 writer.println("designition:"+cookies[3].getValue());
		 writer.println("email:"+request.getParameter("email"));
		 writer.println("password:"+request.getParameter("phone"));
		 writer.println("</pre>");
		 writer.println("</body>");
		 writer.println("</html>");
		
	}
}