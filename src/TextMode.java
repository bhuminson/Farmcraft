import java.util.Scanner;

public class TextMode implements GUIMode    {

    Scanner scan = new Scanner(System.in);
    Visitor consolePainter = new ConsolePainter();
    boolean quit = false;
    Farm farm;

    @Override
    public void invTutorial()       {
        System.out.println("\nPress 'i' to go back to the farm\n");
    }

    @Override
    public void farmTutorial()  {
        System.out.println("Controls:");
        System.out.println("\tPress 'a' to add a plot ($100)");
        System.out.println("\tPress 'r' to remove a plot");
        System.out.println("\tPress 'p' to plant a potato");
        System.out.println("\tPress 'i' to open your inventory");
        System.out.println("\tPress 'm' to go to the market");
        System.out.println("\tPress 's' to sleep");
        System.out.println("\tPress 'h' to harvest any ripe crops");
        System.out.println("\tPress 'q' to quit");
        System.out.println("\n");
    }

    @Override
    public void mktTutorial()   {
        System.out.println("\nWelcome to Farm Depot!\n");
        System.out.println("Press 'p' to buy potato seeds");
        System.out.println("Press 'm' to go back to the farm\n");
    }

    @Override
    public void showFarm()  {
        nextScreen();
        farmTutorial();
        farm.accept(consolePainter);
    }

    @Override
    public void showInventory()     {
        nextScreen();
        invTutorial();
        farm.inv.accept(consolePainter);
    }

    public void invLoop()    {
        while(true)    {
            if(scan.nextLine().equals("i"))    {
                break;
            }
            showInventory();
        }
    }

    @Override
    public void showMarket()   {
        nextScreen();
        mktTutorial();
        farm.mkt.accept(consolePainter);
    }

    public void mktLoop()   {
        boolean exit = false;
        while(!exit)    {
            String input = scan.nextLine().toLowerCase();
            String result = null;
            switch(input)   {
                case "m":
                    exit = true;
                    break;
                case "p":
                    if(farm.mkt.buySeed(new PotatoSeed()))   {
                        result = "Thank you for your purchase.";
                        break;
                    } else {
                        result = "Insufficient funds.";
                        break;
                    }
                default:
                    result = "Unrecognized command.";
            }
            showMarket();
            System.out.println(result);
        }
    }

    @Override
    public void gameLoop()  {

        while(!quit)    {
            scan.reset();
            String input = scan.nextLine().toLowerCase();
            String result;

            switch(input)   {
                case "q":
                    quit = true;
                    result = "Goodbye!";
                    break;

                case "a":
                    if(farm.addPlot())  {
                        result = "Plot added.";
                    } else {
                        result = "You need more money!";
                    }
                    break;

                case "r":
                    if(farm.removePlot())   {
                        result = "Plot removed.";
                    } else {
                        result = "You don't have any plots!";
                    }
                    break;

                case "p":
                    int val = farm.plant(new PotatoSeed(farm.dayCount));
                    if(val == 0)    {
                        result = "Potato planted.";
                    } else if(val == 1) {
                        result = "You need more potato seeds!";
                    } else {
                        result = "You need more land!";
                    }
                    break;

                case "s":
                    farm.advance();
                    result = "You slept well.";
                    break;

                case "i":
                    showInventory();
                    invLoop();
                    result = "Welcome back!";
                    break;

                case "m":
                    showMarket();
                    mktLoop();
                    result = "Welcome back!";
                    break;

                case "h":
                    if(farm.harvestAll())  {
                        result = "Harvest success!";
                    } else {
                        result = "You have nothing to harvest...";
                    }
                    break;

                default:
                    result = "Unrecognized command.";
                    break;
            }

            showFarm();
            System.out.println(result);
        }
    }

    @Override
    public void nextScreen() {  
        try     { 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
 
    @Override
    public void setup() {
        nextScreen();
        System.out.println("Farmer Inc., Copyright 2019, Bhumin Son. All rights reserved.\n");
        System.out.println("Welcome to Farmer Inc.!\n");
        System.out.print("Name your farm: ");
        String name = scan.nextLine();
        farm = new Farm(name);
        showFarm();
    }
}