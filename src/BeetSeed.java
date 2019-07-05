public final class BeetSeed extends Seed {

    BeetSeed(Day dayCount) {
        super(dayCount);
        buyPrice = 7;
        growTime = 7;
        id = "Beet";
    }

    public Crop transform() {
        return new Beet();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}