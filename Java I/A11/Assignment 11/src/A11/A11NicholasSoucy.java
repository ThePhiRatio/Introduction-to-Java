//Programmer: Nicholas Soucy
//This program will read student data and report semester and cumulative GPA values

package A11;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;

public class A11NicholasSoucy {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		
		String scan_file;                                         //file name of student data
		String line_a; 											  //line_a is the first line of data in file
		String line_b;                                            //line_b is the second line of data in file
		Scanner filescan = null;                                  //initializing filescan for try-catch loop
		ArrayList<Student>students = new ArrayList<Student>();    //ArrayList of students 
		
		//input section
		
		do     //do loop to catch FileNotFoundException
		{	System.out.print("Enter the name of student file: ");
			scan_file = scan.next();
			FileReader fileReader = null;
				try 
				{	fileReader = new FileReader (scan_file);
					filescan = new Scanner (fileReader);	}
				catch  (FileNotFoundException e)
				{	System.out.print("File "+scan_file+" is not found. Try again.\n");
					scan_file = "";	}
			}	while(scan_file.isEmpty());
		scan.close();
		
		//file read section
		
		while (filescan != null && filescan.hasNextLine())
		{	line_a = filescan.nextLine();
			Scanner linescan = new Scanner (line_a);	//first line to scan..
			Student a = new Student();					//a is temp variable of type Student for insertion 
			a.setlName(linescan.next());
			a.setfName(linescan.next());
			a.setStudentID(linescan.next());
			a.setCurrentCreditHours(linescan.nextInt());
			a.setCurrentQualityPoints(linescan.nextDouble());
			students.add(a);
			line_b = filescan.nextLine();
			Scanner linescan_b = new Scanner (line_b);		//second line to scan..
			while (linescan_b.hasNext())
			{	Course c = new Course();				//c is temp variable of type Course for insertion
				a.addCourse(c);
				c.setCourseName(linescan_b.next());
				c.setLetterGrade(linescan_b.next());
				c.setCreditHours(linescan_b.nextInt());		}	
			linescan.close();	linescan_b.close();}
		filescan.close();
			
		//print section
		
		System.out.println("\nProgrammer: Nicholas Soucy");
		System.out.println("GPA Tracker\n");
			
		for (int k = 0; k < students.size(); k++)
		{	System.out.print(students.get(k).toString());	}
			
			
		
		

	}

}
