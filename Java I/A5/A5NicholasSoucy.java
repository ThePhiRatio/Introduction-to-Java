//Program Author: Nicholas Soucy
//Code checks ISBN values for validity and says how many books to order for course

import java.util.Scanner;
import java.io.*;

public class A5 {
	public static void main(String[] args) throws IOException {
		Scanner filescan = new Scanner (new FileReader ("bookorders.txt"));
		
		int count = 0;
		String [] title = new String [0];              //title of book
		String [] isbn_dash = new String [0];          //ISBN number with dashes
		String [] course = new String [0];             //Course number
		String [] enrolled = new String [0];           //Number of people enrolled
		String [] isbn;                                //ISBN number without dashes
		boolean[] isbn_valid;                          //If ISBN number is valid, = true
		int[] order;                                   //Number of books to order
		
		//input section
		while (filescan.hasNext())                     //Reading input from bookorders.txt
		{	title = ArrayWide(title);                  //Widening the array +1 each pass
			isbn_dash = ArrayWide(isbn_dash);
			course = ArrayWide(course);
			enrolled = ArrayWide(enrolled);
			title[count] = filescan.nextLine();
			isbn_dash[count] = filescan.nextLine();
			course[count] = filescan.nextLine();
			enrolled[count] = filescan.nextLine();
			count++;
		}
		filescan.close();	
		
		//processing section
		isbn = stripdashes(isbn_dash);                  //Removing dashes from ISBN
		
		isbn_valid = isValid(isbn);                     //Calculating if ISBN is valid
		
		order = numberToOrder(course, enrolled);        //Number of books to order
		
		//output section
		System.out.println("Book Order Program by Nicholas Soucy\n");
		System.out.printf("%-50s%-30s%-20s%-10s%15s%n","Title","ISBN","Course","Enrollment","# To Order");
		for (int k = 0; k < title.length; k++)
		{	if (isbn_valid[k] != true)
				System.out.printf("%-50s%-30s%-20s%-10s%10d%n",title[k],"INVALID ISBN",course[k],enrolled[k],order[k]);	
			else
				System.out.printf("%-50s%-30s%-20s%-10s%10d%n",title[k],isbn[k],course[k],enrolled[k],order[k]);}
	}
	public static String[] ArrayWide(String[] old)          //POST: return the string length + 1
	{	String [] new_array = new String [old.length+1];
		for (int k = 0; k < old.length; k++)
			new_array[k] = old[k];
		return new_array;}
	
	public static String[] stripdashes (String[] isbn_in) {   //POST: Return string with all dashes removed
		String isbn_num = "xD";
		String [] isbn_out = new String [isbn_in.length];
		for (int k = 0; k < isbn_in.length; k++)
			{isbn_num = isbn_in[k];
			isbn_out[k] = isbn_num.replaceAll("-","");}
		return isbn_out;}
	
	public static boolean[] isValid (String[] isbn) {                //POST: return TRUE if isbn is a valid ISBN number; else false
		int count = 0;
		boolean[] isbn_valid = new boolean[isbn.length];
		for (String entry: isbn)
		{	if (entry.length() != 13)                                //Check if ISBN is correct length
				isbn_valid[count] = false;
			else
			{	char[] isbn_char = entry.toCharArray();
				{for (int i=0; i<isbn_char.length; i++)
				{	if (Character.isDigit(isbn_char[i]))             //Check to see if ISBN is only digits, no characters
						isbn_valid[count] = true;}}
					if (isbn_valid[count] = true)
					{	String last_digit = entry.substring(12, 13);
						double last_digit_num = Double.parseDouble(last_digit);
						String first_digits = entry.substring(0, 12);
						double sum = 0;
						double value = 0;
						for (int k=0; k < 12; k = k+2)               //Compute last ISBN digit and see if the last digit is valid
						{	double one = Double.parseDouble(first_digits.substring(k, k+1));
							double three = Double.parseDouble(first_digits.substring(k+1, k+2));
							value = one + (three*3);
							sum = sum + value;}
						double mod = sum % 10;
						if (last_digit_num != (10-mod))
							isbn_valid[count] = false;
						else 
							isbn_valid[count] = true;}}
			count++;}
		return isbn_valid;}
	
	public static int[] numberToOrder(String[] course, String[] enroll) {   //POST: return the number of books to order as maximum of current and historical enrollment  
		int enroll_num;
		int[] enroll_num_a = new int[enroll.length];
		int[] order_amount = new int[enroll.length];
		for (int k=0; k < enroll.length; k++)
		{	enroll_num = Integer.parseInt(enroll[k]);
			enroll_num_a[k] = enroll_num;}
		for (int i=0; i < course.length; i++)
		{	String code = course[i];
			switch (code)
			{	case "COS103": order_amount[i] = Math.max(50, enroll_num_a[i]);  break;
				case "COS120": order_amount[i] = Math.max(48, enroll_num_a[i]);  break;
				case "COS125": order_amount[i] = Math.max(110, enroll_num_a[i]); break;
				case "COS213": order_amount[i] = Math.max(96, enroll_num_a[i]);  break;
				case "COS220": order_amount[i] = Math.max(100, enroll_num_a[i]); break;
				case "COS221": order_amount[i] = Math.max(40, enroll_num_a[i]);  break;
				case "COS235": order_amount[i] = Math.max(85, enroll_num_a[i]);  break;
				case "COS312": order_amount[i] = Math.max(45, enroll_num_a[i]);  break;
				case "COS331": order_amount[i] = Math.max(50, enroll_num_a[i]);  break;
			}
		}
	return order_amount;}
	}


