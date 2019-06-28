public class Plot implements Paintable, Buyable, Sellable {
	public int buyPrice;
	public int sellPrice;
	public boolean planted;
	private Plant plant; 

	public Plot()	{
		planted = false;
		buyPrice = 100;
		sellPrice = 70;
	}

	@Override
	public int getBuyPrice()	{
		return buyPrice;
	}

	@Override
	public int getSellPrice()	{
		return sellPrice;
	}

	public void setPlant(Plant plant)	{
		planted = true;
		this.plant = plant;
	}

	public Plant getPlant()	{
		return plant;
	}

	public void removePlant()	{
		planted = false;
		this.plant = null;
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}