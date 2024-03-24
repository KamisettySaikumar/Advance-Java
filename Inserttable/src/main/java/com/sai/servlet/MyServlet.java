package com.sai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int startNumber = Integer.parseInt(request.getParameter("Start Number"));
		int endNumber = Integer.parseInt(request.getParameter("End Number"));
		String operation = request.getParameter("operation");
		PrintWriter writer = response.getWriter();
		switch (operation) {

		case "even":
			writer.println("Even Numbers are:");
			for (int i = startNumber; i <= endNumber; i++) {
				if (i % 2 == 0) {
					writer.print(i + " ");
				}
			}
			break;
		case "odd":
			writer.println("Odd Numbers are:");
			for (int i = startNumber; i <= endNumber; i++) {
				if (i % 2 != 0) {
					writer.print(i + " ");
				}
			}
			break;
		case "prime":
			writer.println("PrimeNumers:");
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
						writer.print(i + " ");
					}
				}
			}
			break;

		case "strong":
			writer.println("Strong numbers are:");
			for (int i = startNumber; i <= endNumber; i++) {

				int originalNum = i;
				int sum = 0;
				int temp = i;

				while (temp > 0) {
					int lastdigit = temp % 10;
					int fact = 1;
					for (int j = 1; j <= lastdigit; j++) {
						fact = fact * j;
					}
					sum = sum + fact;
					temp = temp / 10;
				}

				if (sum == originalNum) {
					response.getWriter().print(originalNum+" ");
				}
			}
		}

	}

}
