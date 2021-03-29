package swing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginTest {

	@Test
	void test() {
		Login lg = new Login();
		boolean actualOutput = lg.userLogin("A", "A");
		
		assertEquals(true, actualOutput);
	}
}
