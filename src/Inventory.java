public class Inventory implements Paintable     {

    public Inventory()      {
    }

    public void addSeed(Plant seed)        {
        assert seed.isSeed() == true;
    }

    @Override
    public void accept(Visitor visitor)     {
        visitor.visit(this);
    }
}