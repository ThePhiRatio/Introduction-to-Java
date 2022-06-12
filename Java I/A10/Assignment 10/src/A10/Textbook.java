package A10;

public class Textbook extends Book {
	
	private String course;        //Course of Textbook
	
	public Textbook() {				//POST: Creates empty textbook
		super ();
		course = "";
	}
	
	public Textbook (String t, String a, String i, String p, String c) {		//POST: Creates texbook with title, author, ISBN, price and course
		super (t,a,i,p);
		course = c;
	}
	
	public String getCourse () {					//POST: Returns course
		return course;
	}
	
	public void setCourse (String c) {					//POST: Sets course
		course = c;
	}
	
	public double retailPrice () {						//POST: Returns retail price of textbook
		return (Double.parseDouble(price) * 1.10); 
	}
}
