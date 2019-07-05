public final class Beet extends Crop  {

    Beet() {
        sellPrice = 11;
        id = "Beet";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}