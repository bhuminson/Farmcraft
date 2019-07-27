public final class CarrotSeed extends Seed {

    CarrotSeed(Day dayCount) {
        super(dayCount);
        buyPrice = 6;
        growTime = 6;
        id = "CarrotSeed";
    }

    public Crop transform() {
        return new Carrot();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}