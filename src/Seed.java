import java.util.Objects;

public abstract class Seed extends Plant implements Buyable, Paintable  {
    protected int buyPrice;
    protected int growTime;
    protected int dayPlanted;
    protected Day dayCount;

    public Seed(){}

    public Seed(Day dayCount)   {
        this.dayCount = dayCount;
        dayPlanted = dayCount.getDay();
    }

    @Override
    public int getBuyPrice()    {
        return buyPrice;
    }

    public int getGrowTime()    {
        return growTime;
    }

    public int getDayPlanted()  {
        return dayPlanted;
    }

    public boolean isRipe()  {
        if(dayCount.getDay() - getDayPlanted() >= getGrowTime())    {
            return true;
        }
        return false;
    }

    public abstract Crop transform();

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Seed))    {
            return false;
        }
        Seed temp = (Seed)other;
        return temp.getID().equals(getID());
    }
}