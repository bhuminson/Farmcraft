// import java.util.List;
// import java.util.ArrayList;

public class Farm implements Paintable	{
	private String name;
	private Plot[][] plots;
	private Bank finances;
	private Day dayCount;
    private Inventory inv;
    private Market mkt;

	public Farm(String name)	{
		this.name = name;
		// plots = new ArrayList<>();
        plots = new Plot[3][3];
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                plots[i][j] = new Plot(3 * i + (j + 1));
            }
        }
		dayCount = new Day();
		finances = new Bank(350);
		inv = new Inventory();
		mkt = new Market(finances, inv);
	}

	String getName() {
        return name;
    }

    Plot[][] getPlots()    {
        return plots;
    }

	Bank getFinances()  {
        return finances;
    }

    Day getDayCount()    {
        return dayCount;
    }

    Inventory accessInv()    {
        return inv;
    }

    Market visitMkt() {
        return mkt;
    }

    void upgradePlot()  {
        
    }

    void advance()	{
		dayCount.nextDay();
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
		// for(Plot plot: plots)  {
                Plot curPlot = plots[i][j];
                Plant plant = curPlot.getPlant();
                if(plant instanceof Seed)	{
                    Seed seed = (Seed)plant;
                	if(seed.isRipe())   {
                        curPlot.setPlant(seed.transform());
                    }
                }
            }
        }
	}

	boolean harvestAll()	{
        boolean harvested = false;

		// for(Plot plot: plots)  {
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                Plot curPlot = plots[i][j];
                Plant plant = curPlot.getPlant();
                if(plant instanceof Crop)	{
                	inv.addCrop((Crop)plant);
                	curPlot.removePlant();
            		harvested = true;
                }
            }
        }
        return harvested;
	}

	// boolean addPlot()	{
	// 	Plot newPlot = new Plot();
	// 	if(!finances.canAfford(newPlot))	{
	// 		return false;
	// 	}

	// 	plots.add(newPlot);
	// 	finances.withdraw(newPlot.getBuyPrice());
	// 	return true;
	// }

	// boolean removePlot()	{
	// 	if(plots.size() == 0)	{
	// 		return false;
	// 	}

	// 	plots.remove(plots.size() - 1);
 //        Plot temp = new Plot();
 //        finances.deposit(temp.getSellPrice());
	// 	return true;
	// }

	int plant(Seed seed)	{
		if(!inv.checkStock(seed))	{
			return 1; // no seeds
		}

		// for(Plot plot: plots)  {
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                Plot curPlot = plots[i][j];
                if(curPlot.isEmpty())  {
                    curPlot.setPlant(seed);
                    inv.removeSeed(seed);
                    return 0; //success
                }
            }
        }
        return 2; // no land
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}
