package downtownBookStore;

public class BookData {
	String isbn, title, language, genre, author, publisher, publicationYear, edition, price, availableBooks, soldBooks;
	
	BookData(String isbn, String title, String language, String genre, String author, 
			String publisher, String publicationYear, String edition, String price, String availableBooks, String soldBooks){
		this.isbn=isbn;
		this.title=title;
		this.language=language;
		this.genre=genre;
		this.author=author;
		this.publisher=publisher;
		this.publicationYear=publicationYear;
		this.edition=edition;
		this.price=price;
		this.availableBooks=availableBooks;
		this.soldBooks=soldBooks;
	}

}
