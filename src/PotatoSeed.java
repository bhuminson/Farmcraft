public final class PotatoSeed extends Seed {

    PotatoSeed(Day dayCount) {
        super(dayCount);
        buyPrice = 5;
        growTime = 5;
        id = "PotatoSeed";
    }

    public Crop transform() {
        return new Potato();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}