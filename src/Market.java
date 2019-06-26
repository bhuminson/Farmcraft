public class Market implements Paintable    {
    public Money userCash;
    public Inventory userInv;
    public Inventory mktInv;

    public Market(Money cash, Inventory userInv) {
        this.userCash = cash;
        this.userInv = userInv;
        mktInv = new Inventory();
    }

    public boolean buySeed(Purchasable item)    {
        assert item instanceof Plant;

        if(userCash.withdraw(item.getBuyPrice()))  {
            userInv.addSeed((Plant)item);
            return true;
        }
        return false;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}