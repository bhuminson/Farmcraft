public class Money  {
    
    private int cash;

    public Money(int startAmt)  {
        cash = startAmt;
    }

    public int getCash()    {
        return cash;
    }

    public boolean withdraw(int amt)    {
        if(cash < amt)  {
            return false;
        }
        cash -= amt;
        return true;
    }

    public void deposit(int amt) {
        cash += amt;
    }

    public boolean canAfford(Buyable item)  {
        return cash >= item.getBuyPrice();
    }

    public String toString()    {
        return "$" + cash;
    }
}