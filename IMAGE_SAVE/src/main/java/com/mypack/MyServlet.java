package com.mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("Welcome");
		int id=Integer.parseInt(request.getParameter("id"));
		File image=new File(request.getParameter("image"));
		FileInputStream fis = new FileInputStream(image);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","manager");
			String sql="insert into blobimg values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setBinaryStream(2,(InputStream)fis,(int)(image.length()));
			int s = ps.executeUpdate();
	        if (s > 0) {
	            System.out.println("Image Uploaded successfully !");
	        } else {
	            System.out.println("unsucessfull to upload image.");
	        }
	        
	        ps.close();
	        con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
