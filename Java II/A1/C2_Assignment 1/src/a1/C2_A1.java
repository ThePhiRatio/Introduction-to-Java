//Programmer: Nicholas Soucy
//Program creates a 20x20 rectangle, then randomly places four 4x4 rectangles inside of it, with no overlap

package a1;

import java.util.Random;
import java.io.*;

public class C2_A1 {
	
	public static void main(String[] args) throws IOException {
		
		
		boolean flag;
		//variables and objects
		
		Random random = new Random();		//Creation of random 
		Rectangle2D [] inner_rec = new Rectangle2D [4];  //Array that holds the 4 inner rectangles
		Point plot_1 = new Point(random.nextInt(16),random.nextInt(16));  //first inner rectangle2d point; 16 because it would be inside the large rectange and have room to expand
		Rectangle2D rec_1 = new Rectangle2D(plot_1.getX(),plot_1.getY(),3.0,3.0);  //first inner rectangle2d
		inner_rec [0] = rec_1;
		for (int k = 1; k < 4; k++)
		{	inner_rec[k] = new Rectangle2D (random.nextInt(16), random.nextInt(16), 3.0, 3.0);
			flag = true;		
		
			while(flag)
			{
				flag = false;		
				inner_rec[k] = new Rectangle2D (random.nextInt(16), random.nextInt(16), 3.0, 3.0);
				for(int j = 0; j < k; j++)
				{
					if(inner_rec[k].overlaps(inner_rec[j])) flag = true;
				}

			}
		}
		
		//print section
		
		System.out.println("Programmer: Nicholas Soucy\n");
		
		System.out.println("Plot 1: " +inner_rec[0].getPoint().toString());
		System.out.println("Plot 2: " +inner_rec[1].getPoint().toString());
		System.out.println("Plot 3: " +inner_rec[2].getPoint().toString());
		System.out.println("Plot 4: " +inner_rec[3].getPoint().toString()+("\n"));
		
		for (int y = 0; y < 20; y++)
		{	for (int x = 0; x < 20; x++)
			{ 	flag = true;
				for (int i = 0; i < 4; i++)
				if ( inner_rec[i].contains(new Point(x,y)))
					{System.out.print("P");
					flag = false;
					}
					if(flag) System.out.print(".");
			}
			System.out.print("\n");
		}
				
		

	}

}
