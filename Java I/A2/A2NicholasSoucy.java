// Program by: Nicholas Soucy
// Program produces catering bill

import java.util.Scanner;

public class A2NicholasSoucy {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		final double BEEF = 12.95;                                 //Cost of beef meal in USD
		final double CHICKEN = 10.95;                              //Cost of chicken meal in USD
		final double VEGAN = 8.95;                                 //Cost of vegan meal in USD
		final double ROOM_1 = 250;                                 //Cost of room 1 in USD
		final double ROOM_2 = 200;                                 //Cost of room 2 in USD
		final double ROOM_3 = 100;                                 //Cost of room 3 in USD 
		final double ROOM_4 = 50;                                  //Cost of room 4 in USD 
		final double GRATUITY = 0.18;                              //Cost of gratuity of food as percent
		final double TAX_ROOM = 0.065;                             //Cost of state tax on room cost as percent
		double num_b;                                              //Number of beef meals
		double num_c;                                              //Number of chicken meals
		double num_v;                                              //Number of vegan meals
		
		
		//input section 
		System.out.print("Enter number of beef meals: ");
		num_b = scan.nextDouble();
		System.out.print("Enter number of chicken meals: ");
		num_c = scan.nextDouble();
		System.out.print("Enter number of vegan meals: ");
		num_v = scan.nextDouble();
		
		final double TOT_MEALS = num_b + num_c + num_v;                  //Total number of meals and customers
		if (num_b < 0 || num_c < 0 || num_v < 0)
		{	System.out.println("Invalid data");
			System.exit(1);         }
		if (TOT_MEALS > 200)
		{	System.out.println("Cannot fit");
			System.exit(1);         }
		
		scan.close();
		
		//processing section
		double room_choice;                                        //Room chosen based on number of customers
		if (TOT_MEALS >= 1 && TOT_MEALS <= 30)
			room_choice = ROOM_4;
			else
				if (TOT_MEALS > 30 && TOT_MEALS <= 100)
					room_choice = ROOM_3;
					else
						if (TOT_MEALS > 100 && TOT_MEALS <= 150)
							room_choice = ROOM_2;
						else
							room_choice = ROOM_1;
		final double ROOM_TAX = room_choice * TAX_ROOM;                         //Room tax calculated in USD
		final double ROOM_COST = room_choice + ROOM_TAX;                  //Room cost in USD
		final double BEEF_COST = num_b * BEEF;                            //Cost of beef dinners in USD
		final double CHICK_COST = num_c * CHICKEN;                        //Cost of chicken dinners in USD
		final double VEGAN_COST = num_v * VEGAN;                          //Cost of vegan dinners in USD
		final double FOOD_TOTAL = BEEF_COST + CHICK_COST + VEGAN_COST;    //Total cost of food in USD 
		final double FOOD_TIP = FOOD_TOTAL * GRATUITY;                    //Total cost of food tip in USD
		final double FOOD_COST = FOOD_TOTAL + FOOD_TIP;                   //Total cost of food, including tip, in USD
		final double TOTAL = ROOM_COST + FOOD_COST;                       //Total expense for the customer
		System.out.println("\n");
		
		//output section
		System.out.println("Catering by Nicholas Soucy");
		System.out.printf("%-20s %19.0f%n","Number in party:",+TOT_MEALS);
		System.out.printf("%-20s %11s %7.2f%n","Room Cost:","$",+room_choice);
		System.out.printf("%-20s %11s %7.2f%n","Room Tax","$",+ROOM_TAX);
		if (num_b > 0)
			System.out.printf("%-20s %16.0f %n %-19s %9s %7.2f%n","Number of beef dinners:",+num_b,"Cost of beef dinners:","$",+BEEF_COST);
		else
			System.out.print("\n");
		if (num_c > 0)
			System.out.printf("%-20s %13.0f %n %-19s %6s %7.2f%n","Number of chicken dinners:",+num_c,"Cost of chicken dinners:","$",+CHICK_COST);
		else
			System.out.print("\n");
		if (num_v > 0)
			System.out.printf("%-20s %15.0f %n %-19s %8s %7.2f%n","Number of vegan dinners:",+num_v,"Cost of vegan dinners:","$",+VEGAN_COST);
		else
			System.out.print("\n");
		System.out.printf("%-20s %11s %7.2f%n","Food Gratuity:","$",+FOOD_TIP);
		System.out.println("------------------------------------------");
		System.out.printf("%-20s %11s %6.2f%n","Total:","$",+TOTAL);	
	}

}
