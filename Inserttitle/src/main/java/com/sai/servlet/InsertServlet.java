package com.sai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateNumberListServlet
 */
@WebServlet("/GenerateNumberListServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the data
	int startNumber= Integer.parseInt(request.getParameter("Start Number"));
	int endNumber= Integer.parseInt(request.getParameter("End Number"));
	String operation=request.getParameter("operation");
		//process the data
	int result=0;
	int count=0;
	 
	 response.setContentType("text/html");
     PrintWriter writer = response.getWriter();
     writer.println("<html><head><title>Even Numbers</title></head><body>");
     
     // Define the range of even numbers
    
int counnt=0;
     
     
     switch(operation) {
     
     case "even":
    	 
     for (int i = startNumber; i <= endNumber; i++) {
         if (i % 2 == 0) {
        	 writer.print("<p> even Numbers result is:"+ i + "</p>");
             
         }
     }
     break;
     case "odd":
    	 for (int i = startNumber; i <= endNumber; i++) {
             if (i % 2 != 0) {
                 writer.print("<p> odd Numbers result is:"+ i + "</p>");
             }
    	 }
    	 break;
    	 
     
    case "prime":
    	 
    	 for (int i = startNumber; i <= endNumber; i++) {
             if (i > 1) {
                 boolean isPrime = true;
                 for (int j = 2; j <= Math.sqrt(i); j++) {
                     if (i % j == 0) {
                         isPrime = false;
                         break;
                     }
                 }
                 if (isPrime) {
                     writer.println("<p>Prime Numbers resulrt is:<br>"+i+"</p>");
                 }
             }
         }
    	 break;
    	 
    case "strong":
    	  
    	for(int i=startNumber;i<=endNumber;i++)
    	{
    		
                int originalNum = i;
                int sum = 0;
                int temp = i;
                
                while (temp > 0) {
                    int lastdigit = temp % 10;
                    int fact = 1;
                    for (int j = 1; j <= lastdigit; j++) {
                        fact=fact*j;
                    }
                    sum = sum+fact;
                    temp=temp/ 10;
                }
                
                if (sum == originalNum) {
                    writer.println("<p>Strong Numbers result is"+originalNum + "</p>");
                }
            }
    	
     break;
     
     }
    
     writer.println("</body>");
     writer.println("</html>");
     
     }
	}