package com.sai.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseClient {

	public static void main(String[] args) throws SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		int res1 = employeeDao.save(new Employee(1001, "sai", 116));
		System.out.println("data inserted successfully" + res1);

		int res2 = employeeDao.save(new Employee(1002, "kumar", 118));
		System.out.println("Data inserted successfully");

		// reading the data from database
		Employee emp = employeeDao.findById(1003);
		System.out.println(emp);

		// Delete by id()
		int deleteCount = employeeDao.deleteById(1001);
		if (deleteCount == 1)
			System.out.println("data deleted successfully");
		else
			System.out.println("data deleted fail");

		// delete by findbysalary
		int deletecount1 = employeeDao.deleteBySalary(15000);
		if (deletecount1 == 1)
			System.out.println("data delete succesfully");
		else
			System.out.println("data delete fail");
	}
	

}
