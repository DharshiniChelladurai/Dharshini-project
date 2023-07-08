package dao;
import java.sql.*;
import ConnectionManager.connectionManager;
import model.Login;
public class LoginDAO {
	public boolean validate(Login login)throws ClassNotFoundException,SQLException
	{
		String username=login.getusername();
		String password=login.getpassword();

        connectionManager conn=new connectionManager();
		Connection con=conn.establishConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from login");
		while(rs.next())
		{
			if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password")))
			{
				conn.closeConnection();
				return true;
			}
		}
		conn.closeConnection();
		return false;
	}
}