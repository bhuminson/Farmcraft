public final class Carrot extends Crop  {

    Carrot() {
        sellPrice = 9;
        id = "Carrot";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}