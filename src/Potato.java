public final class Potato extends Crop	{

    public Potato() {
        sellPrice = 7;
        id = "Potato";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}