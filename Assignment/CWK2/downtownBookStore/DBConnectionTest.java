package downtownBookStore;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Statement;

import org.junit.jupiter.api.Test;

class DBConnectionTest {

	@Test
	void test() {
		DBConnection db = new DBConnection();
		Statement actualOutput = db.connect(); 
		
		assertEquals(null, actualOutput);
	}

}
