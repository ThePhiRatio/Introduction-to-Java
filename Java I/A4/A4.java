//Code Author: Nicholas Soucy
//Code displays multiple data points about weather by location and name of reporter

import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

public class A4 {
	public static void main(String[] args) throws IOException {	
		Scanner filescan = new Scanner (new FileReader ("weather.txt"));
		Scanner filescan_2 = new Scanner (new FileReader ("averages.txt"));
		DecimalFormat fmt = new DecimalFormat("##.##");
		PrintWriter writer = new PrintWriter (new File("weatherout.txt"));
		
		//variable section
		
		String line;                                    //line variable for linescan
		String line_2;                                  //line variable for second linescan
		String city;                                    //city of weather data
		String date = ("xD");                           //date of weather data
		double temp;                                    //temperature of city in F
		double temp_ave;                                //average temperature of data in F
		double maxtemp = 0;                             //maximum temperature of data in F
		double mintemp = 200;                           //minimum temperature of data in F
		String wind_d;                                  //direction of wind
		double wind_s;                                  //speed of wind in mph
		String firstname;                               //first name of weather reporter
		String lastname = ("xD");                       //last name of weather reporter
		String name_code;                               //reporter's name code
		String first_c;                                 //first letter of first name of reporter
		String last_c;                                  //first letter of last name of reporter
		double b_count = 0;                             //amount of Bangors in data 
		double o_count = 0;                             //amount of Oronos in data
		double c_count = 0;                             //amount of Calais in data
		double wind_c;                                  //calculated wind chill 
		double temp_tot = 0;                            //total temperature of data in F
		double count = 0;                               //amount of data entries
		String month;                                   //month of historical average
		double month_temp_ave;                          //historical average temperature in F
		String month_code;                              //month part of date string
		int month_c;                                    //month code converted to number
		String month_str;                               //month of data to compute difference from average
		double month_ave;                               //average temperature of month in F
		double month_ave_calc;                          //difference of data temp average from historical average in F
		
		//input & output section
		
		writer.println("Weather Watch by Nicholas Soucy \n");
		writer.printf("%-60s%-45s%-35s%-25s%-20s%-10s%10s%n","Town","Date","Temp","Direction","Wind Speed","Wind Chill","Reporter");
		while (filescan.hasNextLine())
		{	line = filescan.nextLine();
			Scanner linescan = new Scanner (line);
			count++;
	
			city = linescan.next();
				if (city.equals("Bangor"))
				{	b_count++; }
				if (city.equals("Orono"))
				{	o_count++; }
				if (city.equals("Calais"))
				{	c_count++; }
			
			date = linescan.next();
					
			temp = linescan.nextDouble();
			temp_tot = temp_tot + temp;
			maxtemp = Math.max(maxtemp, temp);
			mintemp = Math.min(mintemp, temp);
			
			wind_d = linescan.next();
					
			wind_s = linescan.nextDouble();
					
			wind_c = 35.74 + (0.6215*(temp))-(35.75*(Math.pow(wind_s, 0.16)))+(0.4275*(temp)*(Math.pow(wind_s, 0.16)));
					
			firstname = linescan.next();
			while (linescan.hasNext())
				{lastname = linescan.next();}
			first_c = firstname.substring(0,1);
			last_c = lastname.substring(0,1);
			name_code = first_c.concat(last_c);
			
			writer.printf("%-60s%-45s%-35.2f%-25s%-20.2f%-10.2f%10s%n",(city.toUpperCase()),date,temp,wind_d,wind_s,wind_c,name_code);
		linescan.close();
		}
		filescan.close();	
		writer.print("\n");
		temp_ave = temp_tot / count;
		writer.printf("%-10s%10.2f%n","Average Temperature: ",temp_ave);
		writer.printf("%-10s%10.2f%n","Maximum Temperature: ",maxtemp);
		writer.printf("%-10s%10.2f%n","Minimum Temperature: ",mintemp);
		writer.print("\n");
		
		writer.println("Number of readings:");
		writer.printf("%-10s%10.0f%n","BANGOR",b_count);
		writer.printf("%-10s%10.0f%n","ORONO",o_count);
		writer.printf("%-10s%10.0f%n%n","CALAIS",c_count);
		
		writer.println("Historical Averages:");
		while (filescan_2.hasNextLine())
		{	line_2 = filescan_2.nextLine();
			Scanner linescan = new Scanner (line_2);
			month = linescan.next();
			month_temp_ave = linescan.nextDouble();
			writer.printf("%-10s%10.2f%n",month,month_temp_ave);
		linescan.close();	
		}
		filescan_2.close();
		month_code = date.substring(0,2);
		month_c = Integer.parseInt(month_code);
		switch (month_c)
		{	case 1: 
			{month_str = ("January"); month_ave = 24.92; break;}
			case 2: 
			{month_str = ("February"); month_ave = 28.70; break;}
			case 3: 
			{month_str = ("March"); month_ave = 45.91;   break;}
			case 4: 
			{month_str = ("April"); month_ave = 52.00;   break;}
			case 5:
			{month_str = ("May"); month_ave = 68.90;    break;}
			case 6: 
			{month_str = ("June"); month_ave = 73.55;    break;}
			case 7: 
			{month_str = ("July"); month_ave = 78.63;    break;}
			case 8: 
			{month_str = ("August"); month_ave = 77.59;  break;}
			case 9: 
			{month_str = ("September"); month_ave = 68.40; break;}
			case 10: 
			{month_str = ("October"); month_ave = 55.70; break;}
			case 11: 
			{month_str = ("November"); month_ave = 45.75; break;}
			case 12: 
			{month_str = ("December"); month_ave = 36.33; break;}
			default: 
			{month_str = ("Ivalid Data Entry"); month_ave = 0;}
		}
		writer.print("\n");
		month_ave_calc = temp_ave - month_ave;
		writer.println("Difference between this "+month_str+" from historical average is "+fmt.format(month_ave_calc));
		writer.close();
	}

}
