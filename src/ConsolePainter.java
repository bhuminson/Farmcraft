public class ConsolePainter implements Visitor  {

    private static final int PLOT_WIDTH = 9;
    private static final int PLOT_HEIGHT = 5;

    @Override
    public void visit(Farm farm)    {
        System.out.println("______________________________________________________");
        System.out.println(farm.getName());
        System.out.println(farm.getFinances());
        System.out.println(farm.getDayCount());
        System.out.println();
        for(Plot plot: farm.getPlots())  {
            plot.accept(this);
        }
        System.out.println("______________________________________________________");
    }

    @Override
    public void visit(Plot plot)    {
        if(plot.isEmpty()) {
            for(int i = 0; i < PLOT_HEIGHT; i++)    {
                for(int j = 0; j < PLOT_WIDTH; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        } else {
            for(int i = 0; i < PLOT_HEIGHT; i++)    {
                for(int j = 0; j < PLOT_WIDTH; j++) {
                    Plant plant = plot.getPlant();
                    if(plant instanceof Seed)   {
                        ((Seed)plant).accept(this);
                    } else {
                        ((Crop)plant).accept(this);
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    @Override
    public void visit(Potato potato)    {
        System.out.print("P");
    }

    @Override
    public void visit(PotatoSeed seed)    {
        System.out.print("p");
    }

    @Override
    public void visit(Inventory inv)        {
        PotatoSeed potatoSeed = new PotatoSeed(new Day());
        Potato potato = new Potato();
        System.out.println("**************** INVENTORY ****************");
        System.out.println("\n             *** SEEDS ***\n");
        System.out.println("           Potato seeds: " + inv.getSeeds().get(potatoSeed));
        System.out.println("\n             *** CROPS ***\n");
        System.out.println("           Potatoes: " + inv.getCrops().get(potato));
        System.out.println("\n*******************************************");
    }

    @Override
    public void visit(Market mkt)  {
        PotatoSeed potatoSeed = new PotatoSeed(new Day());
        Potato potato = new Potato();
        System.out.println("+++++++++++++++ MARKET +++++++++++++++");
        System.out.println("\nCash: " + mkt.getUserCash());
        System.out.println("\n             +++ BUY +++\n");
        System.out.println("           Potato seeds: ");
        System.out.println("              Price: $" + potatoSeed.getBuyPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getSeeds().get(potatoSeed));
        System.out.println("\n             +++ SELL +++\n");
        System.out.println("           Potato: ");
        System.out.println("              Price: $" + potato.getSellPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getCrops().get(potato));
        System.out.println("\n++++++++++++++++++++++++++++++++++++++");
    }
} 