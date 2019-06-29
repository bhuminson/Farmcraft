public class Plot implements Paintable, Buyable, Sellable {

	private int buyPrice;
	private int sellPrice;
	private boolean planted;
	private Plant plant; 

	Plot()	{
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

	boolean isEmpty()	{
		return !planted;
	}

	void setPlant(Plant plant)	{
		planted = true;
		this.plant = plant;
	}

	Plant getPlant()	{
		return plant;
	}

	void removePlant()	{
		planted = false;
		this.plant = null;
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}