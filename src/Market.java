public class Market implements Paintable    {

    private Bank userCash;
    private Inventory userInv;

    public Market(Bank cash, Inventory userInv) {
        this.userCash = cash;
        this.userInv = userInv;
    }

    Bank getUserCash()    {
        return userCash;
    }

    Inventory getUserInv()   {
        return userInv;
    }

    boolean buySeed(Buyable item)    {
        assert item instanceof Seed;

        if(userCash.withdraw(item.getBuyPrice()))  {
            userInv.addSeed((Seed)item);
            return true;
        }
        return false;
    }

    private boolean sellCrop(Sellable item)  {
        assert item instanceof Crop;

        if(userInv.checkStock((Crop)item))    {
            userInv.removeCrop((Crop)item);
            userCash.deposit(item.getSellPrice());
            return true;
        }
        return false;
    }

    boolean sellAll()    {
        boolean sold = false;
        Potato potato = new Potato();
        Carrot carrot = new Carrot();
        Beet beet = new Beet();
        while(sellCrop(potato) || sellCrop(carrot) || sellCrop(beet)) {
            sold = true;
        }
        return sold;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}