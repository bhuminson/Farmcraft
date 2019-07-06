public class ConsolePainter implements Visitor  {

    private static final int PLOT_WIDTH = 9;
    private final PotatoSeed potatoSeed = new PotatoSeed(new Day());
    private final CarrotSeed carrotSeed = new CarrotSeed(new Day());
    private final BeetSeed beetSeed = new BeetSeed(new Day());
    private final Potato potato = new Potato();
    private final Carrot carrot = new Carrot();
    private final Beet beet = new Beet();

    @Override
    public void visit(Farm farm)    {
        System.out.println("____________________________________________________________________________________");
        System.out.println(farm.getName());
        System.out.println(farm.getFinances());
        System.out.println(farm.getDayCount());
        System.out.println();
        int count = 0;
        for(Plot[] triplet: farm.getPlots())    {
            for(Plot plot: triplet) {
                plot.accept(this);
                System.out.print("<Plot " + plot.getNumber() + "|Grade " + plot.getGrade() + ">    ");
            }
            count++;
            if(count != 3)    {
                System.out.println("\n\n\n");
            }
            else    {
                System.out.println("\n");
            }
        }
        // for(Plot plot: farm.getPlots())  {
        //     plot.accept(this);
        // }
        // for(int i = 0; i < farm.getPlots().size; i++) {
        //     farm.getPlots().get(i).accept(this);
        //     if(i % 3 == 0)  {
        //         System.out.println();
        //     }
        // }
        System.out.println("____________________________________________________________________________________");
    }

    @Override
    public void visit(Plot plot)    {
        if(plot.isEmpty()) {
            for(int i = 0; i < PLOT_WIDTH; i++)    {
                // for(int j = 0; j < PLOT_WIDTH; j++) {
                System.out.print("-");
                // }
                // System.out.println();
            }
        } else {
            for(int i = 0; i < PLOT_WIDTH; i++)    {
                // for(int j = 0; j < PLOT_WIDTH; j++) {
                Plant plant = plot.getPlant();
                if(plant instanceof Seed)   {
                    ((Seed)plant).accept(this);
                } else {
                    ((Crop)plant).accept(this);
                }
                // System.out.println();
            }
        }
        // System.out.println();
    }

    @Override
    public void visit(Potato potato)    {
        System.out.print("P");
    }

    @Override
    public void visit(Carrot carrot)    {
        System.out.print("C");
    }

    @Override
    public void visit(Beet beet)    {
        System.out.print("B");
    }

    @Override
    public void visit(PotatoSeed seed)    {
        System.out.print("p");
    }

    @Override
    public void visit(CarrotSeed seed)    {
        System.out.print("c");
    }

    @Override
    public void visit(BeetSeed seed)    {
        System.out.print("b");
    }

    @Override
    public void visit(Inventory inv)        {
        System.out.println("**************** INVENTORY ****************");
        System.out.println("\n             *** SEEDS ***");
        System.out.println("\n             Potato seeds: " + inv.getSeeds().get(potatoSeed));
        System.out.println("             Carrot seeds: " + inv.getSeeds().get(carrotSeed));
        System.out.println("             Beet seeds: " + inv.getSeeds().get(beetSeed));
        System.out.println("\n             *** CROPS ***");
        System.out.println("\n             Potatoes: " + inv.getCrops().get(potato));
        System.out.println("             Carrots: " + inv.getCrops().get(carrot));
        System.out.println("             Beets: " + inv.getCrops().get(beet));
        System.out.println("\n*******************************************");
    }

    @Override
    public void visit(Market mkt)  {
        System.out.println("+++++++++++++++ MARKET +++++++++++++++");
        System.out.println("\nCash: " + mkt.getUserCash());

        System.out.println("\n           +++++ BUY +++++");
        System.out.println("\n           Potato seeds: ");
        System.out.println("              Price: $" + potatoSeed.getBuyPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getSeeds().get(potatoSeed));
        System.out.println("\n           Carrot seeds: ");
        System.out.println("              Price: $" + carrotSeed.getBuyPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getSeeds().get(carrotSeed));
        System.out.println("\n           Beet seeds: ");
        System.out.println("              Price: $" + beetSeed.getBuyPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getSeeds().get(beetSeed));

        System.out.println("\n           +++++ SELL +++++");
        System.out.println("\n           Potato: ");
        System.out.println("              Price: $" + potato.getSellPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getCrops().get(potato));
        System.out.println("\n           Carrot: ");
        System.out.println("              Price: $" + carrot.getSellPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getCrops().get(carrot));
        System.out.println("\n           Beet: ");
        System.out.println("              Price: $" + beet.getSellPrice());
        System.out.println("              Your stock: " + mkt.getUserInv().getCrops().get(beet));
        System.out.println("\n++++++++++++++++++++++++++++++++++++++");
    }
} 