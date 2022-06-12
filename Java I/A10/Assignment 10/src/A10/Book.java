package A10;

public abstract class Book {							

	protected String title;         //Title of book
	protected String author;        //Author of book
	protected String isbn;			//ISBN of book
	protected String price;			//Price of book
	
	public Book () {				//POST: Return empty book
		title = "";
		author = "";
		isbn = "";
		price = "";
	}
	
	public Book (String t, String a, String i, String p) {    //POST: Return book with title, author, isbn and price
		title = t;
		author = a;
		isbn = i;
		price = p;
	}
	
	public String getTitle () {							//POST: Returns title
		return title;
	}
	
	public String getAuthor () {						//POST: Returns author
		return author;
	}
	
	public String getISBN () {							//POST: Returns ISBN
		return isbn;
	}
	
	public String getPrice () {							//POST: Returns price
		return price;
	}
	
	public void setTitle (String t) {					//POST: Sets title				
		title = t;
	}
	
	public void setAuthor (String a) {					//POST: Sets author
		author = a;
	}
	
	public void setISBN (String i) {					//POST: Sets ISBN
		isbn = i;
	}
	
	public void setPrice (String p) {					//POST: Sets price
		price = p;
	}
	
	public abstract double retailPrice();				//Creates abstract object for extend classes to overwrite
	
}
