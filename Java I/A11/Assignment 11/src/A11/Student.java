package A11;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Student {

	String fName;											// first name
	String lName;											// last name
	String studentID;										// student identification number
	int currentCreditHours;									// current credit hours
	double currentQualityPoints;							// current quality points
	ArrayList<Course> courseList;	
	DecimalFormat fmt = new DecimalFormat ("#.00");
	
	public Student ( )										// POST: empty student
	{	fName = "";
		lName = "";
		studentID = "";
		courseList = new ArrayList<Course> ( );
		currentCreditHours = 0;
		currentQualityPoints = 0.0;
	}

	// accessors and mutators
	public String getfName() {	return fName;	}
	public void setfName(String fName) {this.fName = fName;	}
	public String getlName() {	return lName;	}
	public void setlName(String lName) { this.lName = lName;	}
	public String getStudentID() {	return studentID;	}
	public void setStudentID(String studentID) { this.studentID = studentID;	}
	public ArrayList<Course> getCourseList() {	return courseList;	}
	public void setCourseList(ArrayList<Course> courseList) {	this.courseList = courseList;	}
	public int getCurrentCreditHours() { return currentCreditHours;	}
	public void setCurrentCreditHours(int currentCreditHours) {	this.currentCreditHours = currentCreditHours;	}
	public double getCurrentQualityPoints() { return currentQualityPoints;	}
	public void setCurrentQualityPoints(double currentQualityPoints) {	this.currentQualityPoints = currentQualityPoints;	}
	
	public int getTotalCreditH() 							//POST: returns total credit hours of semester for a student
	{	int total_cred = 0;    //total credit hours of semester
		for (int j = 0; j < courseList.size(); j++)   //loop to add all credit hours in courselist
		{	total_cred = total_cred + this.courseList.get(j).getCreditHours(); }
		return total_cred;
	}
	
	public double getTotalQP() 								//POST: returns total quality points of semester for a student
	{	double tot_qp = 0;    //total quality points of semester
		for (int k = 0; k < courseList.size(); k++)       //loop to add all of quality points in courselist
		{	tot_qp = tot_qp + this.courseList.get(k).qualityPoints();	}
		return tot_qp; }
	
	public double getCurrentGPA()							//POST: returns the current GPA of student before semester
	{	return this.getCurrentQualityPoints() / this.getCurrentCreditHours();
	}
	
	public String toString ( )								// POST: return string of data
	{	return fName + " " + lName + " " + studentID + "\nCurrent GPA " + fmt.format(this.getCurrentGPA()) + "\nSemester Courses: " + courseList.toString() + "\nSemester GPA: " + fmt.format(this.semesterGPA()) + "\nNew GPA: " + fmt.format(this.cumulativeGPA()) + "\n\n";  
	}
	
	public void addCourse (Course c)						// POST: add course list of courses
	{	courseList.add(c);
															
	}
		
	public double semesterGPA ( )							// POST: return semester GPA
	{	return this.getTotalQP() / this.getTotalCreditH();	}
	
	
	public double cumulativeGPA ( )							// POST: return new cumulative GPA factoring in this semester
	{	double tot_qp = this.getCurrentQualityPoints() + this.getTotalQP();
		int tot_ch = this.getTotalCreditH() + this.getCurrentCreditHours();
		return tot_qp / tot_ch;
	}
}

