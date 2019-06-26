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

	public boolean canAfford(Purchasable item)	{
		return cash.getCash() >= item.getBuyPrice();
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

	public int plant(Plant seed)	{
		if(inv.checkStock(seed) == false)	{
			return 1; // no seeds
		}
		for(int i = 0; i < plots.size(); i++)  {
            Plot curPlot = plots.get(i);
            if(curPlot.planted == false)  {
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
