
/**
 * Write a description of class Seed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Seed
{
    private String name;
    private int daysToGrow;
    private int worth;
    public String getName()
    {
    return name;
    }
    
    public void setName(String name)
    {
    this.name = name;
    }
    
    public int daysToGrow()
    {
    return daysToGrow;
    }
    
    public void setDays(int days)
    {
    daysToGrow = days;
    }
    
    public int getWorth()
    {
    return worth;
    }
    
    public void setWorth(int price)
    {
    worth = price;
    }
    
    public void fertilize()
    {
    daysToGrow--;
    }
}
