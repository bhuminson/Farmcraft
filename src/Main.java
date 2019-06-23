import java.util.Scanner;

public class Main {

	public static void printControls()	{
		System.out.println("Controls:");
		System.out.println("\tPress 'a' to add a plot");
		System.out.println("\tPress 'r' to remove a plot");
        System.out.println("\tPress 'p' to plant a potato");
        System.out.println("\tPress 'q' to quit");
        System.out.println("\tPress any other key for help");
		System.out.println("\n");
	}

    public static void clearScreen() {  
        try     { 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e) {
            System.out.println(e);
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
        boolean quit = false;

		while(!quit)	{
			String input = scan.nextLine();
            boolean help = false;
            String result = null;

            switch(input)   {
                case "q":
                    quit = true;
                    result = "Goodbye!";
                    break;

                case "a":
                    result = "Plot added.";
                    farm.addPlot();
                    break;

                case "r":
                    if(farm.removePlot())   {
                        result = "Plot removed.";
                    } else {
                        result = "You don't have any plots!";
                    }
                    break;

                case "p":
                    for(int i = 0; i < farm.plots.size(); i++)  {
                        Plot curPlot = farm.plots.get(i);
                        if(curPlot.planted == false)  {
                            curPlot.setPlant(new Potato());
                            result = "Potato planted on plot " + (i + 1);
                            break;
                        }
                        if(i == farm.plots.size() - 1)  {
                            result = "You need more land!";
                        }
                    }
                    break;

                default:
                    help = true;
                    break;
            }

            clearScreen();
			farm.accept(consolePainter);
            if(help)    {
                printControls();
                continue;
            }

            System.out.println(result);
		}
	}
}