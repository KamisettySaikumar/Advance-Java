package com.satya.products;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class ProductDao {
		
		public int save(Products product) {
			//Declare the resources
				Connection connection=null;
				PreparedStatement preparedStatement=null;
				int savecount=0;
				try {
					//Get the connection
					connection=DataBaseUtil.createconnection();
					//create the preparedStatement object
					preparedStatement=connection.prepareStatement("insert into product_data values (?,?,?,?,?,?,?,?)");
					//read the data from employee object and set to parameters
					preparedStatement.setString(1,product.getProId());
					preparedStatement.setString(2, product.getProName());
					preparedStatement.setDouble(3, product.getProPrice());
					preparedStatement.setString(4, product.getProBrand());
					preparedStatement.setString(5, product.getProMadeIn());
					preparedStatement.setDate(6, product.getProMnfgDate());
					preparedStatement.setDate(7, product.getProExpDate());
					preparedStatement.setBinaryStream(8, product.getProImage());
					savecount=preparedStatement.executeUpdate();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					//Before release the connection check the connection is present or not
					try {
						if(connection!=null)
							connection.close();
						if(preparedStatement!=null)
							preparedStatement.close();
					}
					catch ( SQLException e ) {
						e.printStackTrace();
					}
				}
				return savecount;
			}
	}
	

