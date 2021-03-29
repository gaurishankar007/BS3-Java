package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public Statement connect() {
		Connection con;
		Statement stmt=null; 
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs27a","root","Mysql@358");
			stmt =   con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
}
