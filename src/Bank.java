public class Bank  {
    
    private double cash;

    Bank(int startAmt)  {
        cash = startAmt;
    }

    private double getCash()    {
        return cash;
    }

    boolean withdraw(int amt)    {
        if(cash < amt)  {
            return false;
        }
        cash -= amt;
        return true;
    }

    void deposit(int amt) {
        cash += amt;
    }

    boolean canAfford(Buyable item)  {
        return cash >= item.getBuyPrice();
    }

    public String toString()    {
        return "$" + String.format("%.2f", getCash());
    }
}