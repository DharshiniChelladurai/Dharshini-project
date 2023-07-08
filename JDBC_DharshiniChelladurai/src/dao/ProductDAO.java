package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.connectionManager;
import model.Product;

public class ProductDAO {
	public void addproduct(Product product)throws ClassNotFoundException, SQLException
	{
		connectionManager conn=new connectionManager();
		Connection con = conn.establishConnection();
		
		String sql =" insert into product (product Id,productName,minSellQuantity,price,quantity)values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, product.getproductId());
		ps.setString(2, product.getProductName());
		ps.setInt(3, product.getMinSellQuantity());
		ps.setInt(4,product.getprice());
		ps.setInt(5,product.getQuantity());
		ps.executeUpdate();
		
		conn.closeConnection();
	}
	public void display() throws ClassNotFoundException,SQLException
	{
		connectionManager conn = new connectionManager();
		Connection con = conn.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		
		while(rs.next())
		{
			System.out.println("_____________________________");
			System.out.println(rs.getInt("productId")+ "|" + rs.getString("productName")+"|" + rs.getInt("minSellQuantity")+"|" +rs.getInt("price")+ "|" +rs.getInt("quantity"));
		}
		conn.closeConnection();
	}

}
