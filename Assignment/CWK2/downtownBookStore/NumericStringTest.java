package downtownBookStore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumericStringTest {

	@Test
	void test() {
		boolean actualOutput = Home.isNumeric("123456789");
		
		assertEquals(true, actualOutput);
	}

}
