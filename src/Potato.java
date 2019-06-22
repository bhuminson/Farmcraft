public final class Potato implements Plant	{
	private final int price = 5;

	@Override
	public int getPrice()	{
		return price;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}