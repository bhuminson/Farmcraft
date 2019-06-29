public final class Potato extends Crop	{

    Potato() {
        sellPrice = 7;
        id = "Potato";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}