public interface Plant extends Purchasable {
    boolean isSeed();
    boolean isRipe();
    int getBuyPrice();
    int getSellPrice();
    void testRipe();
    void accept(Visitor visitor);
}