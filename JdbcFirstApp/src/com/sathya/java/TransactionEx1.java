package com.sathya.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionEx1 {

	public static void main(String[] args) 
	{
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","manager");
		
			Statement=Connection.create Statement();
			Connection.set AutoCommit(false);
			Statement.executeupdate("insert into empvalue(1007,'saikumar',45000.00)");
			Statement.executeupdate("insert into empvalue(1008,'kumar',35000.00)");
			Statement.executeupdate("insert into empvalue(1009,'sai',25000.00)");
			Statement.executeupdate("delete from emp where empid=1007");
			connection.commit();
		}
	
		catch(ClassNotFoundExecption | SQLExeption e)
		{
			Connection.rollback();
			e.PrintStackTrace();
			
			finally
			{
				if(connection!=null)
					Connection.close();
				if(Statement!=null)
				Statement.close();
			}
		}
	
