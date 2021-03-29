package swing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.sql.Statement;

class ConnectonTesting {

	@Test
	void test() {
		DBConnection db = new DBConnection();
		Statement actualOutput = db.connect(); 
		
		assertEquals(null, actualOutput);
	}

}
