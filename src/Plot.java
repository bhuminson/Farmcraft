public class Plot implements Paintable	{

	public boolean planted;
	private Plant plant; 

	public Plot()	{
		planted = false;
	}

	public void setPlant(Plant plant)	{
		planted = true;
		this.plant = plant;
	}

	public Plant getPlant()	{
		return plant;
	}

	public void harvest()	{
		planted = false;
		this.plant = null;
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}