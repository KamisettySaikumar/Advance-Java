package com.sathya.product.productmanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EditProductServlet() {
		super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		//Read the Data from Form..
		Integer proId=Integer.parseInt(request.getParameter("proId"));
		
		
		//Giving the proId to Dao layer..
		ProductDao dao = new ProductDao();
		Product_data exsisting = dao.findById(proId);
		
		request.setAttribute("exsistingproduct", exsisting);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit_product.jsp");
		dispatcher.forward(request, response);
       		
	}

}