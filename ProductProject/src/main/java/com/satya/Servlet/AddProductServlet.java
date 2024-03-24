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

import com.satya.products.ProductDao;
import com.satya.products.Products;
@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//Read the data
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMnfgDate=Date.valueOf(request.getParameter("proMnfgDate"));
		Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
		Part part=request.getPart("proImage");
		InputStream proImage=part.getInputStream();
		
		//using the above details create the product object
		Products product=new Products();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMnfgDate(proMnfgDate);
		product.setProExpDate(proExpDate);
		product.setProImage(proImage);
		
		//giving the product object into Dao layer
		ProductDao productDao=new ProductDao();
		int result=productDao.save(product);
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("Data inserted successfully..."+result);
		
	}

}