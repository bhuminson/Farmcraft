import java.util.List;
import java.util.ArrayList;

public class Farm implements Paintable	{
	public String name;
	public List<Plot> plots;
	public Money cash;
	public Day dayCount;
    public Inventory inv;
    public Market mkt;

	public Farm(String name)	{
		this.name = name;
		plots = new ArrayList<Plot>();
		dayCount = new Day();
		cash = new Money(350);
		inv = new Inventory();
		mkt = new Market(cash, inv);
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
		cash.withdraw(100);
		return true;
	}

	public boolean removePlot()	{
		if(plots.size() == 0)	{
			return false;
		}

		plots.remove(plots.size() - 1);
		return true;
	}

	public int plant(Seed seed)	{
		if(inv.checkStock(seed) == false)	{
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
