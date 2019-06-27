public class ConsolePainter implements Visitor  {

    private static final int PLOT_WIDTH = 9;
    private static final int PLOT_HEIGHT = 5;

    @Override
    public void visit(Farm farm)    {
        System.out.println("______________________________________________________");
        System.out.println(farm.name);
        System.out.println(farm.cash);
        System.out.println(farm.dayCount);
        System.out.println("");
        for(Plot plot: farm.plots)  {
            plot.accept(this);
        }
        System.out.println("______________________________________________________");
    }

    @Override
    public void visit(Plot plot)    {
        String token;
        if(!plot.planted) {
            for(int i = 0; i < PLOT_HEIGHT; i++)    {
                for(int j = 0; j < PLOT_WIDTH; j++) {
                    System.out.print("-");
                }
                System.out.println("");
            }
        } else {
            for(int i = 0; i < PLOT_HEIGHT; i++)    {
                for(int j = 0; j < PLOT_WIDTH; j++) {
                    plot.getPlant().accept(this);
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }

    @Override
    public void visit(Potato potato)    {
        if(potato.isSeed())
            System.out.print("p");
        if(potato.isRipe())
            System.out.print("P");
    }

    @Override
    public void visit(Inventory inv)        {
        Potato potato = new Potato();
        Potato potatogrown = new Potato(3);
        System.out.println("**************** INVENTORY ****************");
        System.out.println("\n             *** SEEDS ***\n");
        System.out.println("           Potato seeds: " + inv.seeds.get(potato));
        System.out.println("\n             *** CROPS ***\n");
        System.out.println("           Potatoes: " + inv.crops.get(potatogrown));
        System.out.println("*******************************************");
    }

    @Override
    public void visit(Market mkt)  {
        Potato potato = new Potato();
        Potato potatogrown = new Potato(3);
        System.out.println("+++++++++++++++ MARKET +++++++++++++++");
        System.out.println("\nCash: " + mkt.userCash);
        System.out.println("\n             +++ BUY +++\n");
        System.out.println("           Potato seeds: ");
        System.out.println("              Price: $" + potato.getBuyPrice());
        System.out.println("              Your stock: " + mkt.userInv.seeds.get(potato));
        System.out.println("\n             +++ SELL +++\n");
        System.out.println("           Potato: ");
        System.out.println("              Price: $" + potato.getSellPrice());
        System.out.println("              Your stock: " + mkt.userInv.crops.get(potatogrown));
        System.out.println("\n++++++++++++++++++++++++++++++++++++++");
    }
} 