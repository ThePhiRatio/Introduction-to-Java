package A10;

public class Tradebook extends Book {
	
	private String major;			//Major of Tradebook
	
	public Tradebook () {			//POST: Creates empty tradebook
		super ();
		major = "";
	}
	
	public Tradebook (String t, String a, String i, String p, String m) {		//POST: Creates tradebook with title, author, ISBN, price and major
		super(t,a,i,p);
		major = m;
	}
	
	public String getMajor () {					//POST: Returns major
		return major;
	}
	
	public void setMajor (String m) {					//POST: Sets major
		major = m;
	}
	
	public double retailPrice() {					//POST: Returns retail price of tradebook
		return (Double.parseDouble(price) * 1.15); 
	}
	
}
