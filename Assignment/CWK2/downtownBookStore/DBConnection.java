package downtownBookStore;

import java.sql.*;

public class DBConnection {
	
	public Statement connect() {
		Connection DBCon;
		Statement StMt = null;
		
		try {
			DBCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/downtownbookstore","root","Mysql@358");
			StMt = DBCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StMt;
	}

}
