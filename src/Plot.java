public class Plot implements Paintable	{

	public boolean planted;
	public Plant plant; 

	public Plot()	{
		planted = false;
	}

	public void plant(Plant plant)	{
		planted = true;
		this.plant = plant;
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