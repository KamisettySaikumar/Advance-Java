package com.satya.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@MultipartConfig
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read the Data from Form..
				String proId=request.getParameter("proId");
				String proName=request.getParameter("proName");
				Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
				String proBrand=request.getParameter("proBrand");
				String proMade=request.getParameter("proMade");
				Date proMfgDate=Date.valueOf(request.getParameter("proManfactureDate"));
				Date proExpDate=Date.valueOf(request.getParameter("proExpireDate"));
				Part part=request.getPart("proImage");
				InputStream proImage=part.getInputStream();
				
				//Using above details create the product Object...
				Product product=new Product();
				product.setProId(proId);
				product.setName(proName);
				product.setProprice(proPrice);
				product.setProBrand(proBrand);
				product.setProMade(proMade);
				product.setProMfgDate(proMfgDate);
				product.setProExpDate(proExpDate);
				product.setProImage(proImage);
				
				//Giving the Product  Object to DAO Layer...
				ProductDao productDao=new ProductDao();
				int result=productDao.save(product);
				PrintWriter out=response.getWriter();
				out.print("Data Saved successfully");
				
				
	}
	

}
