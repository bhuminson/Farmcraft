import java.util.List;
import java.util.ArrayList;

public class Farm	{
	public String name;
	public int numPlots;
	public List<Plot> plots;
	//TODO: Add valuation aspect

	public Farm(String name)	{
		this.name = name;
		numPlots = 0;
		plots = new ArrayList<Plot>();
	}

	public void addPlot()	{
		numPlots ++;
		plots.add(new Plot());
	}

	public void removePlot()	{
		numPlots --;
		plots.remove(-1);
	}

	public void paint()	{
		System.out.println("______________________________________________________");
		System.out.println(name);
		System.out.println("");
		for(Plot plot: plots)	{
			plot.paint();
		}
		System.out.println("______________________________________________________");
	}
}
