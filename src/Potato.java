import java.util.Objects;

public final class Potato implements Plant	{
	private int buyPrice = 5;
    private int sellPrice = 7;
    private final static int growTime = 10;
    private final String id = "Potato";
    public boolean isSeed = true;

    @Override
    public boolean isSeed()     {
        return isSeed;
    }

	@Override
	public int getBuyPrice()	{
		return buyPrice;
	}

    @Override
    public int getSellPrice()    {
        return sellPrice;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object other)     {
        if(!(other instanceof Potato))  {
            return false;
        }
        Potato temp = (Potato)other;
        return temp.isSeed == this.isSeed;
    }

    @Override
    public int hashCode()       {
        return Objects.hash(id, isSeed);
    }
}