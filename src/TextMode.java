import java.util.Scanner;

public class TextMode implements GUIMode    {

    private Scanner scan = new Scanner(System.in);
    private Visitor consolePainter = new ConsolePainter();
    private boolean quit = false;
    private Farm farm;

    public void invTutorial()       {
        System.out.println("\nPress 'i' to go back to the farm\n");
    }

    public void farmTutorial()  {
        System.out.println("Controls:");
        System.out.println("\tPress 'p' to plant a potato");
        System.out.println("\tPress 'c' to plant a carrot");
        System.out.println("\tPress 'b' to plant a beet");
        System.out.println("\tPress 'i' to open your inventory");
        System.out.println("\tPress 'm' to go to the market");
        System.out.println("\tPress 's' to sleep");
        System.out.println("\tPress 'h' to harvest any ripe crops");
        System.out.println("\tPress 'u' to upgrade a plot");
        System.out.println("\tPress 'q' to quit");
        System.out.println("\n");
    }

    public void mktTutorial()   {
        System.out.println("\nWelcome to Farm Depot!\n");
        System.out.println("Press 'p' to buy potato seeds");
        System.out.println("Press 'c' to buy carrot seeds");
        System.out.println("Press 'b' to buy beet seeds");
        System.out.println("Press 's' to sell all your crops");
        System.out.println("Press 'm' to go back to the farm\n");
    }

    @Override
    public void showFarm()  {
        refresh();
        farmTutorial();
        farm.accept(consolePainter);
    }

    @Override
    public void showInventory()     {
        refresh();
        invTutorial();
        farm.accessInv().accept(consolePainter);
    }

    private void invLoop()    {
        while(true)    {
            if(scan.nextLine().equals("i"))    {
                break;
            }
            showInventory();
        }
    }

    @Override
    public void showMarket()   {
        refresh();
        mktTutorial();
        farm.visitMkt().accept(consolePainter);
    }

    private void mktLoop()   {
        boolean exit = false;
        while(!exit)    {
            String input = scan.nextLine().toLowerCase();
            String result = null;
            switch(input)   {
                case "m":
                    exit = true;
                    break;

                case "p":
                    if(farm.visitMkt().buySeed(new PotatoSeed(new Day())))   {
                        result = "Thank you for your purchase.";
                    } else {
                        result = "Insufficient funds.";
                    }
                    break;

                case "c":
                    if(farm.visitMkt().buySeed(new CarrotSeed(new Day())))   {
                        result = "Thank you for your purchase.";
                    } else {
                        result = "Insufficient funds.";
                    }
                    break;

                case "b":
                    if(farm.visitMkt().buySeed(new BeetSeed(new Day())))   {
                        result = "Thank you for your purchase.";
                    } else {
                        result = "Insufficient funds.";
                    }
                    break;

                case "s":
                    if (farm.visitMkt().sellAll())  {
                        result = "Thank you for your business.";
                    } else {
                        result = "You have nothing to sell...";
                    }
                    break;

                default:
                    result = "Unrecognized command.";
            }
            showMarket();
            System.out.println(result);
        }
    }

    public void gameLoop()  {

        while(!quit)    {
            scan.reset();
            String input = scan.nextLine().toLowerCase();
            String result;
            Seed seed;
            int val;

            switch(input)   {
                case "q":
                    quit = true;
                    result = "Goodbye!";
                    break;

                case "p":
                    seed = new PotatoSeed(farm.getDayCount());
                    val = farm.plantNext(seed);
                    if(val == 0)    {
                        result = "Potato planted.";
                    } else if(val == 1) {
                        result = "You need more potato seeds!";
                    } else {
                        result = "All your plots are full!";
                    }
                    break;

                case "c":
                    seed = new CarrotSeed(farm.getDayCount());
                    val = farm.plantNext(seed);
                    if(val == 0)    {
                        result = "Carrot planted.";
                    } else if(val == 1) {
                        result = "You need more carrot seeds!";
                    } else {
                        result = "All your plots are full!";
                    }
                    break;

                case "b":
                    seed = new BeetSeed(farm.getDayCount());
                    val = farm.plantNext(seed);
                    if(val == 0)    {
                        result = "Beet planted.";
                    } else if(val == 1) {
                        result = "You need more beet seeds!";
                    } else {
                        result = "All your plots are full!";
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

                case "u":
                    if(farm.upgradePlot())  {
                        result = "Plot upgraded.";
                    }   else   {
                        result = "You need more money! Upgrade costs $" + farm.nextUpgradeCost(); 
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
    public void refresh() {  
        try     { 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
 
    @Override
    public void setup() {
        refresh();
        System.out.println("Farmer Inc., Copyright 2019, Bhumin Son. All rights reserved.\n");
        System.out.println("Welcome to Farmer Inc.!\n");
        System.out.print("Name your farm: ");
        String name = scan.nextLine();
        farm = new Farm(name);
        showFarm();
        gameLoop();
    }
}