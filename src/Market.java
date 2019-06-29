public class Market implements Paintable    {

    private Money userCash;
    private Inventory userInv;

    public Market(Money cash, Inventory userInv) {
        this.userCash = cash;
        this.userInv = userInv;
    }

    public Money getUserCash()    {
        return userCash;
    }

    public Inventory getUserInv()   {
        return userInv;
    }

    public boolean buySeed(Buyable item)    {
        assert item instanceof Seed;

        if(userCash.withdraw(item.getBuyPrice()))  {
            userInv.addSeed((Seed)item);
            return true;
        }
        return false;
    }

    public boolean sellCrop(Sellable item)  {
        assert item instanceof Crop;

        if(userInv.checkStock((Crop)item))    {
            userInv.removeCrop((Crop)item);
            userCash.deposit(item.getSellPrice());
            return true;
        }
        return false;
    }

    public boolean sellAll()    {
        boolean sold = false;
        Potato potato = new Potato();
        while(sellCrop(potato)) {
            sold = true;
        }
        return sold;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}