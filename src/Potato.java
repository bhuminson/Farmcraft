import java.util.Objects;

public final class Potato implements Plant	{
	private int buyPrice = 5;
    private int sellPrice = 7;
    private final int growTime = 10;
    private final String id = "Potato";
    private boolean isSeed = true;
    private boolean isRipe = false;
    private boolean isWithered = false;
    private int dayPlanted;
    private Day dayCount;

    public Potato() {
        ;
    }

    public Potato(int dummy)        {
        isSeed = false;
    }

    public Potato(Day dayCount) {
        this.dayCount = dayCount;
        dayPlanted = dayCount.getDay();
    }

    @Override
    public void testRipe()    {
        if(dayCount.getDay() - dayPlanted >= growTime)  {
            isSeed = false;
            isRipe = true;
        }
    }

    @Override
    public boolean isRipe() {
        return isRipe;
    }

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
        return Objects.hash(id);
    }
}