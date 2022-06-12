// Program made by: Nicholas Soucy
// This program checks to see if a ski is at friction standards

import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class A3NicholasSoucy {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		final double MAX_FRICTION = 1.23;                                           //Max allowed friction coefficient
		final double RC_COST = 21.99;                                               //Component cost of RC models in USD
		final double ED_COST = 24.99;                                               //Component cost of ED models in USD
		String RC = "RC";
		String ED = "ED";
		String data_points;                                                         //Number of skis being scrutinized as string
		String co_fric;                                                             //Coefficient of friction for ski as string
		String ski_ID;                                                              //ID of ski as string
		String ski_class;                                                           //First two letters of ski ID
		double data_point_num;                                                      //Number of data points as int
		double co_fric_num = 0;                                                     //Coefficient of friction as double
		double fric_sum = 0;                                                        //Sum of all the coefficents of friction
		double reject_sum = 0;                                                      //Number of skis rejected
		double reject_cost = 0;                                                     //Total cost of rejected skis
		double ave_fric;                                                            //Average coefficient or friction
		double per_rej;                                                             //Percent of skis that were rejected
		
		
		//input section
		NumberFormat fmtC = NumberFormat.getCurrencyInstance();
		System.out.println("Programmer: Nicholas Soucy\n");
		do
			{System.out.print("Enter number of data points: ");
			data_points = scan.next();
			data_point_num = Double.parseDouble(data_points);}
			while (data_point_num<0);
		int count;                                                 //Create counter for loop
		for (count = (int) data_point_num; count > 0; count--)
		{do 
			{System.out.print("Enter ski ID: ");
			ski_ID = scan.next();
			ski_class = (ski_ID.substring(0,2)); }
			while ((!RC.equals(ski_class))&&(!ED.equals(ski_class)));
		do
			{System.out.print("Enter friction coefficient for ski "+ski_ID+": ");
			co_fric = scan.next();
			co_fric_num = Double.parseDouble(co_fric);}
			while (co_fric_num < 0);
			{	fric_sum = fric_sum + co_fric_num;}
			if (RC.equals(ski_class))
			{System.out.print("Component cost for ski "+ski_ID+": "+fmtC.format(RC_COST));}
			else
				{System.out.print("Component cost for ski "+ski_ID+": "+fmtC.format(ED_COST));}
			if (co_fric_num > MAX_FRICTION)
				{reject_sum++;
				System.out.print("  <-- REJECT\n\n");
				if (RC.equals(ski_class))
					{reject_cost = reject_cost + RC_COST;}
					if (ED.equalsIgnoreCase(ski_class))
						{reject_cost = reject_cost + ED_COST;}}
			else 
				System.out.print("\n\n");}
		//output section
		NumberFormat fmtP = NumberFormat.getPercentInstance();
		DecimalFormat fmtD = new DecimalFormat ("#");
		DecimalFormat fmtD2 = new DecimalFormat ("#.##");
		System.out.print("\n");
		System.out.println("Number of Data Points: "+fmtD.format(data_point_num));
		ave_fric = fric_sum/data_point_num;
		System.out.println("Average Friction Coefficient: "+fmtD2.format(ave_fric));
		System.out.println("Number of rejected skis: "+fmtD.format(reject_sum));
		per_rej = (reject_sum/data_point_num);
		System.out.println("Percentage of rejected skis: "+fmtP.format(per_rej));
		System.out.println("Cost of rejected skis: "+fmtC.format(reject_cost));
	}

}
