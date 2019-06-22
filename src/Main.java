import java.util.Scanner;

public class Main {

	public static void printControls()	{
		System.out.println("Controls:");
		System.out.println("\tPress 't' to add a plot\n");
	}

	public static void main(String[] args)	{
		System.out.println("Farmer Inc., Copyright 2019, Bhumin Son. All rights reserved.\n");
		System.out.println("Welcome to Farmer Inc.!\n");
		printControls();
		Scanner scan = new Scanner(System.in);
		System.out.println("Name your farm:");
		String name = scan.nextLine();
		Farm farm = new Farm(name);
		farm.paint();

		while(true)	{
			String input = scan.nextLine();
			if(input.equals("q"))	{
				System.out.println("Goodbye!");
				break;
			}
			else if(input.equals("t"))	{
				System.out.println("Plot added.");
				farm.addPlot();
			}
			else 	{
				printControls();
			}
			
			farm.paint();
		}
	}
}