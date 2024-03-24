package ProductTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ProductDetails {

	public static void main(String[] args) {
		public int save(Product details) throws SQLException {
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
				//read the data from product object and set to perameter
				
				  preparedstatement.setInt(1,Product.getproductid());
				  preparedstatement.setString(2,Product.getName());
				  preparedstatement.setDouble(3,Product.getPrize());
				 
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

			public Product findById(int empId) {
				Product Product = null;

				// try with resource

				try (Connection Connection = DbConnection.createConnection()) {
					PreparedStatement preparedStatement = Connection.prepareStatement("select * from product where productid=?");

					// set the data to perameter
					preparedStatement.setInt(1, productId);

					// execute the qurry
					ResultSet resultset1 = preparedStatement.executeQuery();

					// if the record is present execute the below code if the record
					// is not present it returns null

					if (resultset1.next())
						;
					{
						// reading the data from resultset setting to product
						Product = new Product();
						Product.setId(resultset1.getInt(1));
						Product.setName(resultset1.getString(2));
						Product.setPrize(resultset1.getDouble(3));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return Product;
			}

			public int deleteById(int productid) {
				int count = 0;
				{
					try (Connection connection = DbConnection.createConnection())

					{
						PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where productid=?");
						preparedStatement.setInt(1, productid);
						count=preparedStatement.executeUpdate();
						
					}catch(SQLException e) {
						e.printStackTrace();
						
					}
					return count;
				}

			}
			// deleteById prize
			public int deleteByprize(double produtPrize) {
				int count=0;
				try(Connection connection=DbConnection.createConnection()) {
					PreparedStatement ps=connection.prepareStatement("Delete from product where prize=?");
					ps.setDouble(1, produtPrize);
					count=ps.executeUpdate();
				} catch (SQLException  e) {
					e.printStackTrace();
				}
				return count;
			
		


	}

}
