package com.sathya.product.productmanagement;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



	public class ProductDao {
		public int saveproduct(Product_data product) throws SQLException 
		{
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			int saveResult=0;
			try
			{
				connection=DBconnection.createConnection();	
				preparedStatement=connection.prepareStatement("INSERT INTO Product_data VALUES(?,?,?,?,?,?,?,?,?,?)");
				
				preparedStatement.setInt(1, product.getProId());
				preparedStatement.setString(2, product.getProName());
				preparedStatement.setDouble(3, product.getProPrice());
				preparedStatement.setString(4, product.getProBrand());
				preparedStatement.setString(5, product.getPromadeIn());
				preparedStatement.setDate(6, product.getPromDate()); 
				preparedStatement.setDate(7, product.getPromeDate());
				preparedStatement.setBytes(8, product.getProImage());
				preparedStatement.setBytes(9,product.getProAudio());
				preparedStatement.setBytes(10,product.getProVideo());
				
				saveResult = preparedStatement.executeUpdate();
		    }
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(preparedStatement!=null)
	                  preparedStatement.close();
				if(connection!=null)
	                 connection.close();			
			}
			return saveResult;
	  	}
	
		 
		 
		public List<Product_data> findAll() {
				
				
				List<Product_data> products=new ArrayList<Product_data>();
				try(Connection connection=DBconnection.createConnection();
						Statement statement=connection.createStatement()){
					//execute the query
					ResultSet resultset=statement.executeQuery("select * from Product_data");
					
					while(resultset.next())
					{
						Product_data product=new Product_data();
					
						product.setProId(resultset.getInt("proId"));
						product.setProName(resultset.getString("proName"));
						product.setProPrice(resultset.getDouble("proPrice"));
						product.setProBrand(resultset.getString("proBrand"));
						product.setPromadeIn(resultset.getString("promadeIn"));
						product.setPromDate(resultset.getDate("promDate"));
						product.setPromeDate(resultset.getDate("promeDate"));
						product.setProImage(resultset.getBytes("proImage"));
						product.setProAudio(resultset.getBytes("proAudio"));
						product.setProVideo(resultset.getBytes("proVideo"));
						
				        products.add(product);
					
				}
					
			}
				catch(SQLException e) {
					e.printStackTrace();
				}
			return products;
	 }
		
		public int deletebyId(int proId ) throws SQLException {
			
				Connection connection=null;
				PreparedStatement preparedStatement=null;
				int deleteResult=0;
				try
				{
					connection=DBconnection.createConnection();	
					preparedStatement=connection.prepareStatement("DELETE from Product_data where proId=?");
					
					preparedStatement.setInt(1,proId);
					
					deleteResult = preparedStatement.executeUpdate();
			    }
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(preparedStatement!=null)
		                  preparedStatement.close();
					if(connection!=null)
		                 connection.close();			
				}
				return deleteResult;
		  	}



		public Product_data findById(int proId)
		{
			
			Product_data pro = null;
			try
			{
				Connection connection = DBconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from product_data1 where proId=?");
				
				
				//set the data from database
				preparedStatement.setInt(1, proId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					pro = new Product_data();
					pro.setProId(resultSet.getInt(1));
					pro.setProName(resultSet.getString(2));
					pro.setProPrice(resultSet.getDouble(3));
					pro.setProBrand(resultSet.getString(4));
					pro.setPromadeIn(resultSet.getString(5));
					pro.setPromDate(resultSet.getDate(6));
					pro.setPromeDate(resultSet.getDate(7));
					pro.setProImage(resultSet.getBytes(8));
					pro.setProAudio(resultSet.getBytes(9));
					pro.setProVideo(resultSet.getBytes(10));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return pro;
		}
		
		public int updateById(Product_data product) {
			int Updateresult=0;
	String sql=	"UPDATE Product_data set proName=?,proPrice=?,proBrand=?,promadeIn=?,promDate=?,promeDate=?,proImage=?,proAudio=?,proVideo=? WHERE proId=?";
		
			try(Connection connection = DBconnection.createConnection())
			{
				
				PreparedStatement pre = connection.prepareStatement(sql);
				pre.setString(1,product.getProName());
				pre.setDouble(2,product.getProPrice());
				pre.setString(3,product.getProBrand());
				pre.setString(4,product.getPromadeIn());
				pre.setDate(5,product.getPromDate());
				pre.setDate(6,product.getPromeDate());
				pre.setBytes(7,product.getProImage());
				pre.setBytes(8,product.getProVideo());
				pre.setBytes(9,product.getProImage());
				pre.setInt(10, product.getProId());
				
				Updateresult=pre.executeUpdate();				
				
				 
			
			
		}
			catch(SQLException e)
			
			{  e.printStackTrace();
				}
			
			return Updateresult;
			}
		
		
	}