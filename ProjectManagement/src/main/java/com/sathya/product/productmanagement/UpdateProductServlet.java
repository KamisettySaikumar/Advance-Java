package com.sathya.product.productmanagement;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Read the Data from Form..
				Integer proId=Integer.parseInt(request.getParameter("proId"));
				String updatedproName=request.getParameter("proName");
				
				Double updatedproPrice=Double.parseDouble(request.getParameter("proPrice"));
				String updatedproBrand=request.getParameter("proBrand");
				String updatedpromadeIn=request.getParameter("promadeIn");
				
				Date updatedpromDate=Date.valueOf(request.getParameter("promDate"));
				Date updatedproeDate=Date.valueOf(request.getParameter("proeDate"));
				
				Product_data product = new Product_data();
				product.setProId(proId);
				product.setProName(updatedproName);
				product.setProPrice(updatedproPrice);
				product.setProBrand(updatedproBrand);
				product.setPromadeIn(updatedpromadeIn);
				product.setPromDate(updatedpromDate);
				product.setPromeDate(updatedproeDate);
				
				Part filePart = request.getPart("newproImage");
				//newproImage is the name of your file input field
				
				if(filePart !=null && filePart.getSize()>0)
				{
					InputStream inputStream = filePart.getInputStream();
					byte[] newproImage = IOUtils.toByteArray(inputStream);
					product.setProImage(newproImage);
				}
				else
				{
					/*Part file = request.getPart("exsistingImage");
					InputStream inputStream = filePart.getInputStream();
					byte[] exsistingImage = IOUtils.toByteArray(inputStream);
					product.setProImage(exsistingImage);*/
					
					String s = request.getParameter("exsistingImage");
					byte[] exsistingImage = Base64.getDecoder().decode(s);
					product.setProImage(exsistingImage);
					
				}
				ProductDao dao = new ProductDao();
				int res = dao.updateById(product);
				
				if(res == 1)
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter writer = response.getWriter();
					writer.println("data updation fail check once.");
					 
					RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
					dispatcher.include(request, response);
				}
	}
}