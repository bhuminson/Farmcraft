public interface Plant extends Purchasable {
    boolean isSeed();
	int getPrice();
    void accept(Visitor visitor);
}