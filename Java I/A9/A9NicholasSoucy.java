package assignment9;

import java.util.Scanner;
import java.text.NumberFormat;

public class A9NicholasSoucy {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		NumberFormat fmtC = NumberFormat.getCurrencyInstance();
		
		double packing_vol = 0.0023;                              //price of packing materials per cubic inch
		double packing_area = 0.0012;                             //price of plastic wrap per square inch
		int length = 1;                                           //length of box in inches
		int width = 1;                                            //width of box in inches
		int height = 1;                                           //height of box in inches
		double cost = 0;                                          //cost of box in USD
		int snow_di = 0;                                          //dimension of snow globe cube in inches
		double snow_vol;                                          //volume of snow globe cube in inches
		int snow_num = 1;                                         //number of snow globe to be shipped
		int box_need;                                             //amount of boxes to be shipped for amount of snow globes
		double box_cost;                                          //total cost of boxes in USD
		double tot_pack_vol;                                      //total cost of packing materials used in USD
		double tot_pack_area;                                     //total cost of plastic wrap used in USD
		double tot_cost;                                          //total cost of shipping in USD
				
		while (length % 4 != 0 || width % 4 != 0 || height % 4 != 0)
		{	System.out.print("Enter length, width, height of ship box: ");
			length = scan.nextInt();
			width = scan.nextInt();
			height = scan.nextInt();	}
		
		
		Box b = new Box(length, width, height);
		
		while (cost <= 0)
		{	System.out.print("Enter box cost: ");
			cost = scan.nextDouble();	}
		
		
		while (snow_di <= 0 || ((snow_di*snow_di*snow_di) > b.getVolume()) || snow_di % 4 != 0)
		{	System.out.print("Enter dimension of snow globe: ");
			snow_di = scan.nextInt();	}
		
		snow_vol = snow_di*snow_di*snow_di;
		
		while (snow_num != 0)
		{	System.out.print("Enter number of snow globes to ship (0 to quit): ");
			snow_num = scan.nextInt();
			if (snow_num != 0)
			{	System.out.print("\n");
				System.out.println("Number of snow globes: "+snow_num);
				System.out.println("-----------------------------------------");
				box_need = 0;
				while ((b.getVolume() * box_need)<(snow_vol*snow_num))
				{	box_need++;	}
				System.out.println("Number of shipping box(es) needed: "+box_need);
				box_cost = (cost * box_need);
				System.out.println("Cost of box(es): "+fmtC.format(box_cost));
				tot_pack_vol = ((b.getVolume()*box_need) - (snow_vol*snow_num))*packing_vol;
				System.out.println("Cost of packing material: "+fmtC.format(tot_pack_vol));
				tot_pack_area = (b.getArea()*packing_area)*box_need;
				System.out.println("Cost of plastic wrap: "+fmtC.format(tot_pack_area));
				tot_cost = box_cost + tot_pack_vol + tot_pack_area;
				System.out.println("Total Cost: "+fmtC.format(tot_cost));
				System.out.print("\n");	}}
		scan.close();

	}

}
