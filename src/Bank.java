public class Bank  {
    
    private double cash;

    Bank(int startAmt)  {
        cash = startAmt;
    }

    private double getCash()    {
        return cash;
    }

    boolean withdraw(double amt)    {
        if(cash < amt)  {
            return false;
        }
        cash -= amt;
        return true;
    }

    void deposit(double amt) {
        cash += amt;
    }

    boolean canAfford(Buyable item)  {
        return cash >= item.getBuyPrice();
    }

    boolean canAfford(double price)  {
        return cash >= price;
    }

    public String toString()    {
        return "$" + String.format("%.2f", getCash());
    }
}