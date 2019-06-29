public abstract class Seed extends Plant implements Buyable, Paintable  {
    int buyPrice;
    int growTime;
    private int dayPlanted;
    private Day dayCount;

    Seed(Day dayCount)   {
        this.dayCount = dayCount;
        dayPlanted = dayCount.getDay();
    }

    @Override
    public int getBuyPrice()    {
        return buyPrice;
    }

    private int getGrowTime()    {
        return growTime;
    }

    private int getDayPlanted()  {
        return dayPlanted;
    }

    boolean isRipe()  {
        return dayCount.getDay() - getDayPlanted() >= getGrowTime();
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