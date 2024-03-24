package com.sathya.product.productmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer proId=Integer.parseInt(request.getParameter("proId"));
		ProductDao productdao = new ProductDao();
		int deleteResult=0;
		try {
			deleteResult = productdao.deletebyId(proId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(deleteResult==1) {
			//to send the data to jsp file add the data into request object
			request.setAttribute("deleteResult", deleteResult);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else{
			//to send the data to jsp file add the data into request object
			
			
			request.setAttribute("deleteResult", deleteResult);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
			
		}
}
}