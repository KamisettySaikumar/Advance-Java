package com.sai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the data
		String EmployeeId=request.getParameter("EmployeeId");
	    String EmployeeName=request.getParameter("EmployeeName");
	double EmployeeBasicsalary=Double.parseDouble(request.getParameter("EmployeeBasicsalary"));
	//process the data
	double HRA;
	double PF;
	double DA;
	double Grosssalary;
	if(EmployeeBasicsalary>=50000) {
	HRA=30*EmployeeBasicsalary/100;
	 DA=10*EmployeeBasicsalary/100;
	 PF=6*EmployeeBasicsalary/100;
	 Grosssalary=Double.parseDouble(request.getParameter("EmployeeBasicsalary"))+HRA+DA-PF;
	}
	else if(EmployeeBasicsalary<50000 && EmployeeBasicsalary>25000) {
		 HRA=20*EmployeeBasicsalary/100;
		 DA=5*EmployeeBasicsalary/100;
		 PF=3*EmployeeBasicsalary/100;
		 Grosssalary=Double.parseDouble(request.getParameter("EmployeeBasicsalary"))+HRA+DA-PF;
		}
	else {
		 HRA=10*EmployeeBasicsalary/100;
		 DA=3*EmployeeBasicsalary/100;
		 PF=2*EmployeeBasicsalary/100;
		 Grosssalary=Double.parseDouble(request.getParameter("EmployeeBasicsalary"))+HRA+DA-PF;
		}
	//render the response
	
	PrintWriter writer=response.getWriter();
	 writer.println("<html>");
	 
	 writer.println("<body bgcolor=pink>");
	 writer.println("<h1>Employee Info:</h1>");
	 writer.println("<h2>Output:</h2>");
	 writer.println("<p>Employee id:" + EmployeeId + "</p>");
	 writer.println("<p>Employee Name: "+EmployeeName+"</p>");
	 writer.println("<p>Employee BasicSalary:"+EmployeeBasicsalary+"</p>");
	 writer.println("<p>HRA:"+HRA+"</p>");
	 writer.println("<p>DA:"+DA+"</p>");
	 writer.println("<p>PF:"+PF+"</p>");
	 writer.println("<p>Gross Salary:"+Grosssalary+"</p>");
	 writer.println("</html>");
}	

}

	

	
