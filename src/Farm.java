import java.util.List;
import java.util.ArrayList;

public class Farm implements Paintable	{
	public String name;
	public List<Plot> plots;
	public int cash;
	public int day;
    public Inventory inv;

	public Farm(String name)	{
		this.name = name;
		plots = new ArrayList<Plot>();
		day = 0;
		cash = 300;
		inv = new Inventory();
	}

	public void advance()	{
		day++;
	}

	public boolean addPlot()	{
		if(cash < 100)	{
			return false;
		}
		plots.add(new Plot());
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
        if(cash < seed.getPrice())    {
            return false;
        }
        inv.addSeed(seed);
        return true;
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}
