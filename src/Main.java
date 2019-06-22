import java.util.Scanner;

public class Main {

	public static void printControls()	{
		System.out.println("Controls:");
		System.out.println("\tPress 't' to add a plot");
		System.out.println("\tPress 'r' to remove a plot");
		System.out.println("\n");
	}

    public static void clearScreen() {  
        try     { 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e) {
            ;
        }
   }

	public static void main(String[] args) {
        clearScreen();
		System.out.println("Farmer Inc., Copyright 2019, Bhumin Son. All rights reserved.\n");
		System.out.println("Welcome to Farmer Inc.!\n");
		printControls();

		Scanner scan = new Scanner(System.in);
		System.out.println("Name your farm:");
        String name = scan.nextLine();
        Farm farm = new Farm(name);
        clearScreen();

        Visitor consolePainter = new ConsolePainter();
		farm.accept(consolePainter);

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
			else if(input.equals("r"))	{
				if(farm.removePlot())	{
					System.out.println("Plot removed.");
				}
			}
			else 	{
				printControls();
			}
            clearScreen();
			farm.accept(consolePainter);
		}
	}
}