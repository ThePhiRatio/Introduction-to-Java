//Programmer: Nicholas Soucy
//Program takes a set of midterm and final grades and calculates letter grade

import java.util.Scanner;
import java.io.*;

public class A6 {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		
		String text_doc;                     //Name of file to be scanned
		String students;                     //Number of students as string
		int student_num;                     //Number of students as integer
		String line;                         //Line to be scanned
		String [] student_ID;                //Array of student ID numbers
		double [] midterm;                   //Array of midterm grades
		double [] final_grade;               //Array of final grades
		double midterm_mean;                 //Mean of midterm grades
		double final_mean;                   //Mean of final grades
		double midterm_devi;                 //Standard deviation of midterm grades
		double final_devi;					 //Standard deviation of final grades
		String [] letter_mid;				 //Counting array for midterm 
		String [] letter_final;              //Counting array for final
		String letter_m;                     //Counting letter midterm
		String letter_f;                     //Counting letter final
		int [] counts_mid = new int [5];     //Counting for midterm letter grades
		int [] counts_final = new int [5];   //Counting for final letter grades
		
		//input section
		System.out.println("Grade Roster by Nicholas Soucy\n");
		System.out.print("Enter name of file: ");
		text_doc = scan.next();
		Scanner filescan = new Scanner (new FileReader (text_doc));
		students = filescan.nextLine();
		student_num = Integer.parseInt(students);
		student_ID = new String [student_num];
		midterm = new double [student_num];
		final_grade = new double [student_num];
		for (int k = 0; k < student_num; k++)
		{	line = filescan.nextLine();
			Scanner linescan = new Scanner (line);
			student_ID[k] = linescan.next();
			midterm[k] = linescan.nextDouble();
			final_grade[k] = linescan.nextDouble();
			linescan.close();	}
		filescan.close();
		scan.close();
		
		//processing section
		midterm_mean = arith_mean(midterm);
		final_mean = arith_mean(final_grade);
		midterm_devi = stand_dev(midterm, midterm_mean);
		final_devi = stand_dev(final_grade, final_mean);
		letter_mid = letter_grade(midterm, midterm_mean, midterm_devi);
		letter_final = letter_grade(final_grade, final_mean, final_devi);
		for (int x = 0; x < letter_mid.length; x++)                         //Counting amount of X grade in midterm
		{	letter_m = letter_mid[x];
			char let_m = letter_m.charAt(0); 
			counts_mid[(int)let_m-65]++;	}
		for (int y = 0; y < letter_final.length; y++)                       //Counting amount of X grade in final
		{	letter_f = letter_final[y];
			char let_f = letter_f.charAt(0);
			counts_final[(int)let_f-65]++;	}
		
		//output section
		System.out.printf("%n%-18s%-17s%-15s%-10s%10s%n","Student","Midterm","Grade","Final","Grade");
		System.out.println("-----------------------------------------------------------------------");
		for (int i = 0; i < student_num; i++)
			System.out.printf("%-18s%-17.0f%-15s%-10.0f%6s%n",student_ID[i],midterm[i],letter_mid[i],final_grade[i],letter_final[i]);
		System.out.println("\n");
		
		System.out.println("Midterm Analysis");
		System.out.printf("%-10s%5.1f%n","Mean:",midterm_mean);
		System.out.printf("%-10s%5.1f%n","Std Dev:",midterm_devi);
		letter_count(counts_mid);
		System.out.println("\n");
		
		System.out.println("Final Analysis");
		System.out.printf("%-10s%5.1f%n","Mean:",final_mean);
		System.out.printf("%-10s%5.1f%n","Std Dev:",final_devi);
		letter_count(counts_final);
	}
	public static double arith_mean (double[] grade) {               //POST: returns the arithmetic mean of a double array of grades
		double grade_mean;
		double grade_sum = 0;
		for (int k = 0; k < grade.length; k++)
			grade_sum = grade[k] + grade_sum;
		grade_mean = grade_sum / grade.length;
	return grade_mean;}
	
	public static double stand_dev (double[] grade, double mean) {     //POST: returns the standard deviation given a set of grades and mean for the grade set
		double stand_dev;
		double top = 0;
		for (int k = 0; k < grade.length; k++)
			top = (Math.pow((grade[k]-mean), 2)) + top;
		stand_dev = Math.sqrt(top/(grade.length-1));
	return stand_dev;}
	
	public static String[] letter_grade (double[] grade, double m, double s) {    //POST: returns letter grade of test for x student by the grading on the curve algorithm 
		String[] letter_grade = new String[grade.length];
		for (int k = 0; k < grade.length; k++)
		{	if (grade[k] >= m + 1.5*s)
				letter_grade[k] = "A";
			if (grade[k] >= m + 0.5*s && grade[k] < m + 1.5*s)
				letter_grade[k] = "B";
			if (grade[k] >= m - 0.5*s && grade[k] < m + 0.5*s)
				letter_grade[k] = "C";
			if (grade[k] >= m - 1.5*s && grade[k] < m - 0.5*s)
				letter_grade[k] = "D";
			if (grade[k] < m - 1.5*s)
				letter_grade[k] = "E";	}
	return letter_grade;}

	public static void letter_count (int [] counts) {               //POST: displays letter grade and the number of stars equal to the amount of grades of a grade
		String [] letter_grade = {"A","B","C","D","E"};
		char mychar = '*';
		int count;
		for (int n = 0; n < counts.length; n++)
			{System.out.print(letter_grade[n]+"  ");
			count = counts[n];
			while(count > 0)
			{	System.out.print(mychar);
				count--;	}
			System.out.print("\n");}	}
}

