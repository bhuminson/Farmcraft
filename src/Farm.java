import java.util.List;
import java.util.ArrayList;

public class Farm implements Paintable	{
	public String name;
	public List<Plot> plots;
	public int cash;
	public Day dayCount;
    public Inventory inv;
    public Market mkt;

	public Farm(String name)	{
		this.name = name;
		plots = new ArrayList<Plot>();
		dayCount = new Day();
		cash = 300;
		inv = new Inventory();
		mkt = new Market();
	}

	public boolean canAfford(Purchasable item)	{
		return cash >= item.getPrice();
	}

	public void advance()	{
		dayCount.nextDay();
	}

	public boolean addPlot()	{
		Plot newPlot = new Plot();
		if(!canAfford(newPlot))	{
			return false;
		}
		plots.add(newPlot);
		cash -= 100;
		return true;
	}

	public boolean removePlot()	{
		if(plots.size() == 0)	{
			return false;
		}
		plots.remove(plots.size() - 1);
		return true;
	}

	public boolean buySeed(Plant seed)    {
        if(!canAfford(seed))   {
            return false;
        }
        inv.addSeed(seed);
        return true;
	}

	public boolean plant(Plant seed)	{
		if(plots.isEmpty())	{
			return false;
		}
		for(int i = 0; i < plots.size(); i++)  {
            Plot curPlot = plots.get(i);
            if(curPlot.planted == false)  {
                curPlot.setPlant(new Potato());
                return true;
            }
            if(i == farm.plots.size() - 1)  {
            	return false;
            }
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}
