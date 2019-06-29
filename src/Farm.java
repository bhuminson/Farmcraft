import java.util.List;
import java.util.ArrayList;

public class Farm implements Paintable	{
	private String name;
	private List<Plot> plots;
	private Money cash;
	private Day dayCount;
    private Inventory inv;
    private Market mkt;

	public Farm(String name)	{
		this.name = name;
		plots = new ArrayList<Plot>();
		dayCount = new Day();
		cash = new Money(350);
		inv = new Inventory();
		mkt = new Market(cash, inv);
	}

    public String getName() {
        return name;
    }

    public List<Plot> getPlots()    {
        return plots;
    }

    public Money getCash()  {
        return cash;
    }

    public Day getDayCount()    {
        return dayCount;
    }

    public Inventory accessInv()    {
        return inv;
    }

    public Market visitMkt() {
        return mkt;
    }

	public void advance()	{
		dayCount.nextDay();

		for(int i = 0; i < plots.size(); i++)  {
            Plot curPlot = plots.get(i);
            Plant plant = curPlot.getPlant();
            if(plant instanceof Seed)	{
                Seed seed = (Seed)plant;
            	if(seed.isRipe())   {
                    curPlot.setPlant(seed.transform());
                }
            }
        }
	}

	public boolean harvestAll()	{
        boolean harvested = false;

		for(int i = 0; i < plots.size(); i++)  {
            Plot curPlot = plots.get(i);
            Plant plant = curPlot.getPlant();
            if(plant instanceof Crop)	{
            	inv.addCrop((Crop)plant);
            	curPlot.removePlant();
        		harvested = true;
            }
        }
        return harvested;
	}

	public boolean addPlot()	{
		Plot newPlot = new Plot();
		if(!cash.canAfford(newPlot))	{
			return false;
		}

		plots.add(newPlot);
		cash.withdraw(newPlot.getBuyPrice());
		return true;
	}

	public boolean removePlot()	{
		if(plots.size() == 0)	{
			return false;
		}

		plots.remove(plots.size() - 1);
        Plot temp = new Plot();
        cash.deposit(temp.getSellPrice());
		return true;
	}

	public int plant(Seed seed)	{
		if(!inv.checkStock(seed))	{
			return 1; // no seeds
		}

		for(int i = 0; i < plots.size(); i++)  {
            Plot curPlot = plots.get(i);
            if(!curPlot.isPlanted())  {
                curPlot.setPlant(seed);
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
