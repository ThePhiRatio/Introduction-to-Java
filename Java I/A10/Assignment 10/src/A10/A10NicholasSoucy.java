//Programmer: Nicholas Soucy
//Program designates book into textbooks and tradebooks. For a given major, code outputs name and cost of books needed

package A10;

import java.util.Scanner;
import java.io.*;
import java.text.NumberFormat;

public class A10NicholasSoucy {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Scanner filescan = new Scanner (new FileReader ("books.txt"));
		NumberFormat fmtC = NumberFormat.getCurrencyInstance();
		
		final int CAPACITY = 50;                     //Capacity of the array of books
		Book [] books = new Book [CAPACITY];		 //Creating empty book array 
		int size = 0;								 //size of array 
		int resize_cap = 50;						 //tells code if array needs to be resized
		String [] courses = new String [5];			 //Array of courses the user takes
		String major;								 //Major of the user
		String course = "xD";						 //Course in question
		int search_index;							 //An index used for searching tradebooks
		double tot_price_text = 0;					 //Total price of textbooks

		int k = 0;
		while (filescan.hasNext())
		{	if (size == resize_cap)
			{	books = ArrayWide(books);
				resize_cap++;	}
			{	switch(0) {
				case 0:
					if (filescan.nextLine().equals("Textbook"))
						books[k] = new Textbook ();
					else
						books [k] = new Tradebook ();
				case 1:
					books[k].setTitle(filescan.nextLine());
				case 2:
					books[k].setAuthor(filescan.nextLine());
				case 3:
					books[k].setISBN(filescan.nextLine());
				case 4:
					books[k].setPrice(filescan.nextLine());
				case 5: 
					if (books[k] instanceof Textbook)
						((Textbook) books[k]).setCourse(filescan.nextLine());
					else
						((Tradebook) books[k]).setMajor(filescan.nextLine());	}	
				k++;	}	}
		filescan.close();
		
		System.out.print("Enter your major: ");
		major = scan.next();
		System.out.print("\n");
		int j = 0;                                                       //Counter of the amount of courses taken by user
		while (!course.contentEquals("xxx"))
		{	System.out.print("Enter course name: (xxx to quit): ");
			course = scan.next();
			if (!course.equals("xxx"))
			{	courses [j] = course;
				j++;	}	}
		scan.close();
		System.out.print("\n");
		System.out.println("List of textbooks:");
		for (int p = 0; p < j; p++)
		{	search_index = SearchText(books, books.length, courses[p]);
			if (search_index != -1)
			{	System.out.printf("%-8s%-50s%-20s%-7s%n",courses[p],books[search_index].getTitle(),books[search_index].getAuthor(),fmtC.format(((Textbook) books[search_index]).retailPrice()));	}
				tot_price_text = tot_price_text + (((Textbook)books[search_index]).retailPrice());	}	
		System.out.printf("%-78s%-7s%n","Sum of retail textbook prices:",fmtC.format(tot_price_text));
		System.out.print("\n");
		System.out.println("List of tradebooks:");
		search_index = 0;
		while (search_index != -1)
		{	search_index = SearchTrade(books, books.length, major, search_index);
			{	if (search_index != -1)
				{	System.out.printf("%-58s%-20s%-7s%n",books[search_index].getTitle(),books[search_index].getAuthor(),fmtC.format(((Tradebook) books[search_index]).retailPrice()));	}
					if (search_index != -1)
					{	search_index++;	}	
					else
					{	search_index = -1;	}	}	}
	}
	
	public static Book[] ArrayWide(Book[] old) {         //POST: return the book [] length + 1
		Book [] new_array = new Book [old.length+1];
		for (int k = 0; k < old.length; k++)
			new_array[k] = old[k];
		return new_array;}
	
	public static int SearchText (Book[] books, int size, String course) {    //POST: if found, return index, if false return -1
		for (int k = 0; k < size; k++)
			if (books[k] instanceof Textbook)
			{	if ((((Textbook)books[k]).getCourse()).equals(course)) 
					return k;	}	
		return -1;	}
		
	public static int SearchTrade (Book[] books, int size, String major, int search_start) {	//POST: if found, return index, if false return -1
		for (; search_start < size; search_start++)
			if (books[search_start] instanceof Tradebook)
			{	if ((((Tradebook)books[search_start]).getMajor()).equals(major)) 
					return search_start;	}		
		return -1;	}
}
