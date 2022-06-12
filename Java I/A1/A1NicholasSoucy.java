// Program made by: Nicholas Soucy
// This program computes a budget 

import java.util.Scanner;

public class AlNicholasSoucy {

	public static void main(String[] args) {
		
		//variable section
		double hour_rate = 15.50;		                          // Hourly Rate in USD
		double work_w1;                                           // Hours worked in week 1
		double work_w2;                                           // Hours worked in week 2 
		double work_w3;                                           // Hours worked in week 3
		double work_w4;                                           // Hours worked in week 4
		double car_pay = 325.75;                                  // Cost of car payment in USD
		double rent;                                              // Rent cost in USD
		double utilities;                                         // Utility cost in USD
		double transportation;                                    // Transportation cost in USD
		double food;                                              // Food cost in USD
		Scanner scan = new Scanner(System.in);                    // Keyboard input
		
		//input section 
		System.out.print("Enter the number of hours worked during week one: ");
		work_w1 = scan.nextDouble();
		System.out.print("Enter the number of hours worked during week two: ");
		work_w2 = scan.nextDouble();
		System.out.print("Enter the number of hours worked during week three: ");
		work_w3 = scan.nextDouble();
		System.out.print("Enter the number of hours worked during week four: ");
		work_w4 = scan.nextDouble();
		System.out.println("\n");
		System.out.print("Enter cost of rent: ");
		rent = scan.nextDouble();
		System.out.print("Enter cost of utilities: ");
		utilities = scan.nextDouble();
		System.out.print("Enter cost of transportation: ");
		transportation = scan.nextDouble();
		System.out.print("Enter cost of food: ");
		food = scan.nextDouble();
		scan.close();                                                          //close Scanner object after input
		
		//processing section 
		double work_total = work_w1 + work_w2 + work_w3 + work_w4;             // Total hours worked over 4 weeks
		double total_pay = work_total*hour_rate;                               // Total money earned over 4 weeks in USD
		double total_exp = car_pay + rent + utilities + transportation + food; // Total of all expenses in USD
		double left_amount = total_pay - total_exp;                            // Leftover amount of money after payments in USD
		double car_per = (car_pay/total_exp)*100;                              // Percent of budget towards car payment
		double rent_per = (rent/total_exp)*100;                                // Percent of budget towards rent
		double utilities_per = (utilities/total_exp)*100;                      // Percent of budget towards utilities
		double trans_per = (transportation/total_exp)*100;                     // Percent of budget towards transportation
		double food_per = (food/total_exp)*100;                                // Percent of budget towards food
		System.out.println("\n");
		
		//output section
		System.out.println("Budget chart for Nicholas Soucy");
		System.out.printf("%-20s %-10s %12s%n","Expense","Amount $","Percent %");
		System.out.printf("%-20s %-10.2f %12.2f%n","Car Payment",+car_pay,+car_per);
		System.out.printf("%-20s %-10.2f %12.2f%n","Rent",+rent,+rent_per);
		System.out.printf("%-20s %-10.2f %12.2f%n","Utilities",+utilities,+utilities_per);
		System.out.printf("%-20s %-10.2f %12.2f%n","Transportation",+transportation,+trans_per);
		System.out.printf("%-20s %-10.2f %12.2f%n","Food",+food,+food_per);
		System.out.println("\n");
		System.out.printf("%-20s %-10.2f%n","Total Pay",+total_pay);
		System.out.printf("%-20s %-10.2f%n","Total Expenses",+total_exp);
		System.out.printf("%-20s %-10.2f%n","Leftover Amount",+left_amount);
	}

}
