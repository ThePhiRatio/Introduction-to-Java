package A11;

public class Course {
	
	String courseName;									// name of course (ex. COS225)
	String letterGrade;									// letter grade (ex. A)
	int creditHours;									// number of credit hours (ex. 4)
	
	public Course ( )									// POST: construct empty course
	{	courseName = "";
		letterGrade = "";
		creditHours = 0;	}
	
	public Course (String co, String let, int cr )		// PRE: let is A - E, 1 <= cr <= 4
	{	courseName = co;								// POST: construct course from parameters
		letterGrade = let;
		creditHours = cr;	}

	public String getCourseName() {						// POST: return course name
		return courseName;	}

	public void setCourseName(String courseName) {		// POST: set course name
		this.courseName = courseName;	}

	public String getLetterGrade() {					// POST: return letter grade
		return letterGrade;	}

	public void setLetterGrade(String let) {			// PRE: let is A - E
		letterGrade = let;	}							// POST: set letter grade
	
	public int getCreditHours() {						// POST: return credit hours
		return creditHours;	}

	public void setCreditHours(int creditHours) {		// PRE: 1 <= creditHours <= 4 
		this.creditHours = creditHours;					// POST: set credit hours
	}
	
	public String toString ()							// POST: return string on course data
	{	return courseName + " " + letterGrade + " " +  creditHours; }
	
	public double qualityPoints ()						// POST: return quality points 
	{	switch (this.getLetterGrade())    //switch statement to get correct quality points for a given letter
		{	case "F": 
				return 0.00 * getCreditHours();	
			case "D-": 
				return 0.70 * getCreditHours();
			case "D": 
				return 1.00 * getCreditHours();
			case "D+": 
				return 1.33 * getCreditHours();
			case "C-": 
				return 1.67 * getCreditHours();
			case "C": 
				return 2.00 * getCreditHours();
			case "C+": 
				return 2.33 * getCreditHours();
			case "B-": 
				return 2.67 * getCreditHours();
			case "B": 
				return 3.00 * getCreditHours();	
			case "B+": 
				return 3.33 * getCreditHours();
			case "A-": 
				return 3.67 * getCreditHours();
			case "A": 
				return 4.00 * getCreditHours();		}
		return 0.0;										
	}
	
	
}
