// Programmer: Nicholas Soucy
// Program runs a simulation of a tree farm fire of a user specified capacity and density

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class A8 {
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
	
		String [] [] tree_farm;			//2D array of trees in a tree farm 
		int tree_num = 0;				//Dimension of square 2D array tree farm 
		double tree_den = 0;			//Density of tree farm
		Random ran = new Random();		//Creation of random 
		int r_tree = 0;					//Random number between 0, 99. If smaller than density, add T for tree to index
		int T_num = 0;					//Number of Trees in 2D array tree farm
		double tree_pop;				//Percent of tree farm populated with trees
		String [] [] tree_burn;			//Creation of the burned tree farm
		int burn_amount;				//Amount of trees burned
		double burn_percent;			//Percent of trees burned
		boolean burn_through;			//If the fire reached the bottom row, value is true
		String quit_key = "xD";			//If quit_key = 'Q', the program stops looping
		
		//input section
		while (quit_key != "Q")
		{	tree_num = 0;
			tree_den = 0;
			while (tree_num < 10 || tree_num > 30)
			{	System.out.print("Enter number of trees: ");
				tree_num = scan.nextInt();	}
			while (tree_den < 0.20 || tree_den > 0.80)
			{	System.out.print("Enter density: ");
				tree_den = scan.nextDouble();	}
			
			tree_farm = new String [tree_num] [tree_num];
			for (int r = 0; r < tree_num; r++) {
				for (int c = 0; c < tree_num; c++) {
					r_tree = ran.nextInt(99);
					if (r_tree < (tree_den*100))
					{	tree_farm [r][c] = "T";
						T_num = T_num + 1;	}
					else
						tree_farm [r][c] = ".";	}	}
			tree_pop = ((double)T_num / (tree_num * tree_num))*100;
						
			System.out.print("\n");
			
			//output section
			System.out.println("The original forest: ");
			for (int i = 0; i < tree_num; i++) {
				for (int k = 0; k < tree_num; k++) {
					System.out.print(" "+tree_farm[i][k]+" ");	}
				System.out.print("\n");}
			System.out.println("Percent populated: "+tree_pop+"%\n");
			tree_burn = treeburn(tree_farm,tree_den,tree_num);
			System.out.println("The final forest:");
			for (int f = 0; f < tree_num; f++) {
				for (int h = 0; h < tree_num; h++) {
					System.out.print(" "+tree_burn[f][h]+" ");	}
				System.out.print("\n");}
			burn_amount = burnamount(tree_burn,tree_num);
			burn_percent = ((double)burn_amount / (tree_num * tree_num))*100;
			burn_through = burnthrough(tree_burn,tree_num);
			System.out.println("Percent burned: "+burn_percent+"%");
			if (burn_through == false)
				System.out.println("Fire burned out.\n");
			else
				System.out.println("Fire burned through.\n");
			System.out.print("Press any key to continue or enter 'Q' to quit: ");
			quit_key = scan.next();	
			System.out.print("\n");}
		scan.close();
	}
		
	public static String [] [] treeburn (String [] [] treefarm, double density, int tree_num)	{		//PRE: density,tree_num > 0
		String [] [] treeburn = treefarm;																//POST: returns the burning of the tree farm.
		for (int c = 0; c < tree_num; c++) 
		{	if (treeburn [0][c] == "T")
				treeburn [0][c] = "B";	}
		for (int j = 0; j < tree_num - 1; j++)
		{	if (treeburn [j][0] == "B")
			{	if (treeburn [j+1][0] == "T")
					treeburn [j+1][0] = "B";
				if (treeburn [j+1][1] == "T")
					treeburn [j+1][1] = "B";	}
			if (treeburn [j][tree_num - 1] == "B")
			{	if (treeburn [j+1][tree_num-1] == "T")
					treeburn [j+1][tree_num-1] = "B";
				if (treeburn [j+1][tree_num - 2] == "T")
					treeburn [j+1][tree_num -2] = "B";	}
			for (int i = 1; i < tree_num - 1; i++)
			{	if (treeburn [j][i] == "B")
				{	if (treeburn [j+1][i-1] == "T")
						treeburn [j+1][i-1] = "B";
					if (treeburn [j+1][i] == "T")
						treeburn [j+1][i] = "B";
					if (treeburn [j+1][i+1] == "T")
						treeburn [j+1][i+1] = "B";	}	}	}	
	return treeburn;	}
	
	public static int burnamount (String [] [] treeburn, int tree_num) {		//PRE: tree_num > 0
		int burn_amount = 0;													//POST: takes burned treefarm and counts how many burned trees there is, then returns value
		for (int r = 0; r < tree_num; r++)
			for (int c = 0; c < tree_num; c++)
				if (treeburn[r][c] == "B")
					burn_amount = burn_amount + 1;
	return burn_amount;}
	
	public static boolean burnthrough (String [] [] treeburn, int tree_num) {		//PRE: tree_num > 0
		for (int c = 0; c < tree_num; c++)											//POST: takes the burned treefarm and checks to see if last row has burned trees, returns true.
		{	if (treeburn[tree_num - 1][c] == "B")
				return true;	}
	return false;}
}
