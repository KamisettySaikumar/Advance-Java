package com.sai.jdbc;

import java.sql.*;

public class DbConnection
{
	//this method will create the connection object and return connection
	public static Connection createConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","manager");
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
		}
		
	}
	


