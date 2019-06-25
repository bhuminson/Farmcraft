public class Plot implements Paintable, Purchasable{
	public int price = 100;
	public boolean planted;
	private Plant plant; 

	public Plot()	{
		planted = false;
	}

	public int getPrice()	{
		return price;
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