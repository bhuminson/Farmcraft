import java.util.List;
import java.util.ArrayList;

public class Farm implements Paintable	{
	public String name;
	public List<Plot> plots;
	public int cash;
	public int day;

	public Farm(String name)	{
		this.name = name;
		plots = new ArrayList<Plot>();
		day = 0;
		cash = 300;
	}

	public boolean addPlot()	{
		if(cash < 100)	{
			return false;
		}
		plots.add(new Plot());
		cash -= 100;
		return true;
	}

	public void advance()	{
		day++;
	}

	public boolean removePlot()	{
		if(plots.size() == 0)	{
			return false;
		}
		plots.remove(plots.size() - 1);
		return true;
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}
