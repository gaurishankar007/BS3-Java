package downtownBookStore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SortingTest {

	@Test
	void test() {
		AuthorData bikash = new AuthorData("bikash", "5");
		AuthorData samit = new AuthorData("samit", "5");
		AuthorData gauri = new AuthorData("gauri", "5");
		AuthorData gaurav = new AuthorData("gaurav", "5");
		AuthorData aman = new AuthorData("aman", "5");
		
		ArrayList<AuthorData> notDescending = new ArrayList<>();
		ArrayList<AuthorData> descending = new ArrayList<>();
		
		notDescending.add(bikash);
		notDescending.add(samit);
		notDescending.add(gauri);
		notDescending.add(gaurav);
		notDescending.add(aman);		
		

		descending.add(samit);
		descending.add(gauri);
		descending.add(gaurav);
		descending.add(bikash);
		descending.add(aman);
		
		ArrayList<AuthorData> actualOutput = Author.descending(notDescending);
		
		assertEquals(descending, actualOutput);
	}

}
