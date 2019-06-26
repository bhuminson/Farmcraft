public interface Plant extends Purchasable {
    boolean isSeed();
    int getBuyPrice();
    int getSellPrice();
    void accept(Visitor visitor);
}