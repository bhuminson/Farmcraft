import java.util.List;
import java.util.ArrayList;

public class Farm implements Paintable	{
	public String name;
	public List<Plot> plots;
	//TODO: Add valuation aspect

	public Farm(String name)	{
		this.name = name;
		plots = new ArrayList<Plot>();
	}

	public void addPlot()	{
		plots.add(new Plot());
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
