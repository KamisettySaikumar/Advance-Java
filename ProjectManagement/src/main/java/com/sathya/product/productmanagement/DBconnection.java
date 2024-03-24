package com.sathya.product.productmanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection createConnection() {
		// TODO Auto-generated method stub
		Connection connection1=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","manager");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection1;

	}

}