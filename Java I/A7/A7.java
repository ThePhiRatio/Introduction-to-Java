//Programmer: Nicholas Soucy
//Program manages inventory

import java.util.Scanner;
import java.io.*;

public class A7 {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Scanner filescan = new Scanner (new FileReader ("inventory.txt"));
		
		final int CAPACITY = 5;                                  //Inital capacity of arrays
		String [] product = new String [CAPACITY];               //String to hold product names 
		String [] amount = new String [CAPACITY];                //String to hold the amount of products
		String [] price = new String [CAPACITY];                 //String to hold the price of products
		int size = 0;                                            //Amount of values in strings
		int resize_cap = 5;                                      //Amount of values in strings for resizing
		String choice = ("xD");                                  //Choice of letters E,I,R,D or Q
		String item;                                             //Item to edit
		int search_index = -1;                                   //For if value wasn't found in array
		String add_amount;                                       //Amount of product to add with + & -
		int adder;                                               //Amount of product to add as String
		int add_num;                                             //Amount of product to add as int
		String i_product;                                        //Product name to insert
		String i_amount;                                         //Product amount to insert
		String i_price;                                          //Price of product to insert
		int i_exist;                                             //If the product is not in array = -1
		String r_product;                                        //Product to be removed
		int r_index;                                             //Index of the removed product
		double sum = 0;                                          //Sum of the products' cost
		
		
		//read section
		while (filescan.hasNext())                               //Reading inventory.txt
		{	if (size == resize_cap)                              //Resize if array is too small
			{	product = ArrayWide(product);
				amount = ArrayWide(amount);
				price = ArrayWide(price);
				resize_cap++;	}
			else
			{	product[size] = filescan.next();
				amount[size] = filescan.next();
				price[size] = filescan.next();
				size++;	}
			}
		filescan.close();
		
		System.out.println("Inventory Manager");
		System.out.println("By: Nicholas Soucy\n");
		
		System.out.println("Select from menu:");
		System.out.println("E - Edit");
		System.out.println("I - Insert");
		System.out.println("R - Remove");
		System.out.println("D - Display Table");
		System.out.println("Q - Quit\n");
		
		//input section
		while (!choice.equals("Q"))                                  //If Q, code is done
		{	System.out.print("Enter letter of choice: ");
			choice = scan.next();	
		
			if (choice.equals("E"))                                 //E = edit
			{	System.out.print("Enter product: ");
				item = scan.next();
				search_index = search(product,size,item);
				if (search_index != -1)
				{	System.out.print("Enter amount to add (+) or subtract (-): ");
					add_amount = scan.next();
					adder = Integer.parseInt(add_amount.substring(1,2));
					add_num = Integer.parseInt(amount[search_index]);
					if (add_amount.startsWith("+"))
						amount[search_index] = Integer.toString(add_num + adder);
					if (add_amount.startsWith("-"))
						amount[search_index] = Integer.toString(add_num - adder);
					System.out.println("Item "+item+" has new amount in stock "+amount[search_index]+"\n");	}
				else
					System.out.println("Item "+item+" is not found!\n");	}
			
			if (choice.equals("I"))                                                //I = insert
			{	System.out.print("Enter new product ID, stock and unit price: ");
				i_product = scan.next();
				i_amount = scan.next();
				i_price = scan.next();
				i_exist = search(product,size,i_product);
				if (i_exist == -1)
				{	product = insert(product,size,i_product);
					amount = insert(amount,size,i_amount);
					price = insert(price,size,i_price);
					size++;	
					System.out.println("Item "+i_product+" is inserted\n");	}
				else
					System.out.println("Item "+i_product+" already exists!\n");	}
				
			if (choice.equals("R"))                                            //R = remove
			{	System.out.print("Enter ID of product to remove: ");
				r_product = scan.next();
				r_index = search(product,size,r_product);
				if (r_index != -1)
				{	size--;
					product = remove(product,r_index,size);
					amount = remove(amount,r_index,size);
					price = remove(price,r_index,size);	
					System.out.println("Item "+r_product+" is removed.\n");	}
				else
					System.out.println("Item "+r_product+" does not exist!\n");	}
			
			if (choice.equals("D"))                                         //D = display
			{	System.out.printf("%-5s%12s%20s%n","ID","Stock","Unit Price");
				for (int k = 0; k < size; k++)
				{	System.out.printf("%-10s%7s%15s%n",product[k],amount[k],price[k]);	}
				for (int i = 0; i < size; i++)
				{	double price_num = Double.parseDouble(price[i]);
					double amount_num = Double.parseDouble(amount[i]);
					sum = sum + (price_num * amount_num);	}
				System.out.printf("%-10s%-5.2f%n","Total Inventory: ",sum);
				sum = 0;
				System.out.print("\n");	}
		}
		
		scan.close();
		
		}
	public static String[] ArrayWide(String[] old) {         //POST: return the string length + 1
		String [] new_array = new String [old.length+1];
		for (int k = 0; k < old.length; k++)
			new_array[k] = old[k];
		return new_array;}
	
	public static int search (String[] product, int size, String item) {    //POST: if found, return index, if false return -1
		for (int k = 0; k < size; k++)
		{	if (product[k].equals(item)) 
				return k;	}
		return -1;	}
	
	public static String[] insert (String[] insert_string, int size, String value) {   //POST: returns a string array with a new value inserted
		insert_string = ArrayWide(insert_string);
		insert_string[size] = value;
		size++;
		return insert_string;	}
		
	public static String[] remove (String[] remove_string, int index, int size) {	//POST: returns a string array without a value
		remove_string[index] = remove_string[size];
	return remove_string;}
}
