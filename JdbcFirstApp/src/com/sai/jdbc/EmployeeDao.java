package com.sai.jdbc;

import java.sql.*;

public class EmployeeDao {
	public int save(Employee emp) throws SQLException {
	//Declare the resource 
	Connection connection=null;
	PreparedStatement preparedstatement=null;
	int Count=0;
	try
	{
		//get the connection
		
		connection=DbConnection.createConnection();
		
		//create the ps object
		
		preparedstatement=connection.prepareStatement("insert into emps values(?,?,?)");
		//read the data from emp object and set to perameter
		//Employee emp=new Employee();
		  preparedstatement.setInt(1,emp.getEmpid());
		  preparedstatement.setString(2,emp.getEmpName());
		  preparedstatement.setDouble(3,emp.getEmpSalary());
		 
		 Count=((PreparedStatement) preparedstatement).executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		//before relase connection check the connection present or not
		
		if(connection !=null)
			connection.close();
		if(preparedstatement!=null);
		preparedstatement.close();
	}
	return Count;
}

	public Employee findById(int empId) {
		Employee Employee = null;

		// try with resource

		try (Connection Connection = DbConnection.createConnection()) {
			PreparedStatement preparedStatement = Connection.prepareStatement("select * from emp where empid=?");

			// set the data to perameter
			preparedStatement.setInt(1, empId);

			// execute the qurry
			ResultSet resultset1 = preparedStatement.executeQuery();

			// if the record is present execute the below code if the record
			// is not present it returns null

			if (resultset1.next())
				;
			{
				// reading the data from resultset setting to employee
				Employee = new Employee();
				Employee.setEmpid(resultset1.getInt(1));
				Employee.setEmpName(resultset1.getString(2));
				Employee.setEmpSalary(resultset1.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Employee;
	}

	public int deleteById(int empid) {
		int count = 0;
		{
			try (Connection connection = DbConnection.createConnection())

			{
				PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empid=?");
				preparedStatement.setInt(1, empid);
				count=preparedStatement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			return count;
		}

	}
	// deleteById Salary
	public int deleteBySalary(double empSalary) {
		int count=0;
		try(Connection connection=DbConnection.createConnection()) {
			PreparedStatement ps=connection.prepareStatement("Delete from emp where salary=?");
			ps.setDouble(1, empSalary);
			count=ps.executeUpdate();
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return count;
	}
}
