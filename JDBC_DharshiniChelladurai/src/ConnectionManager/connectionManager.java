package ConnectionManager;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
public class connectionManager {
		Connection con=null;
 public Connection establishConnection ()throws ClassNotFoundException,SQLException
 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Harshini","root","root");
			 return con;
 }
 public void closeConnection() throws SQLException
 {
	 con.close();
 }

}
