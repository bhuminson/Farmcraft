public class Market implements Paintable    {

    private Money userCash;
    private Inventory userInv;
    private Inventory mktInv;

    public Market(Money cash, Inventory userInv) {
        this.userCash = cash;
        this.userInv = userInv;
        mktInv = new Inventory();
    }

    public Money getUserCash()    {
        return userCash;
    }

    public Inventory getUserInv()   {
        return userInv;
    }

    public Inventory mktInv()   {
        return mktInv;
    }

    public boolean buySeed(Buyable item)    {
        assert item instanceof Seed;

        if(userCash.withdraw(item.getBuyPrice()))  {
            userInv.addSeed((Seed)item);
            return true;
        }
        return false;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}