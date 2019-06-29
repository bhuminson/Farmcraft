import java.util.List;
import java.util.ArrayList;

public class Farm implements Paintable	{
	private String name;
	private List<Plot> plots;
	private Bank finances;
	private Day dayCount;
    private Inventory inv;
    private Market mkt;

	public Farm(String name)	{
		this.name = name;
		plots = new ArrayList<>();
		dayCount = new Day();
		finances = new Bank(350);
		inv = new Inventory();
		mkt = new Market(finances, inv);
	}

	String getName() {
        return name;
    }

    List<Plot> getPlots()    {
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

    void advance()	{
		dayCount.nextDay();

		for(Plot plot: plots)  {
            Plant plant = plot.getPlant();
            if(plant instanceof Seed)	{
                Seed seed = (Seed)plant;
            	if(seed.isRipe())   {
                    plot.setPlant(seed.transform());
                }
            }
        }
	}

	boolean harvestAll()	{
        boolean harvested = false;

		for(Plot plot: plots)  {
            Plant plant = plot.getPlant();
            if(plant instanceof Crop)	{
            	inv.addCrop((Crop)plant);
            	plot.removePlant();
        		harvested = true;
            }
        }
        return harvested;
	}

	boolean addPlot()	{
		Plot newPlot = new Plot();
		if(!finances.canAfford(newPlot))	{
			return false;
		}

		plots.add(newPlot);
		finances.withdraw(newPlot.getBuyPrice());
		return true;
	}

	boolean removePlot()	{
		if(plots.size() == 0)	{
			return false;
		}

		plots.remove(plots.size() - 1);
        Plot temp = new Plot();
        finances.deposit(temp.getSellPrice());
		return true;
	}

	int plant(Seed seed)	{
		if(!inv.checkStock(seed))	{
			return 1; // no seeds
		}

		for(Plot plot: plots)  {
            if(plot.isEmpty())  {
                plot.setPlant(seed);
                inv.removeSeed(seed);
                return 0; //success
            }
        }
        return 2; // no land
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}
