package downtownBookStore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginTest {

	@Test
	void test() {
		Login obj = new Login();
		boolean actualOutput = obj.userLogin("gaurishankar007", "Downtown@159");
		
		assertEquals(true, actualOutput);
	}

}
