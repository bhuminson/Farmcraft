import java.util.Objects;

public final class Potato implements Plant	{
	private final int price = 5;
    private final int growTime = 10;
    private final String id = "Potato";
    public boolean isSeed = true;

    @Override
    public boolean isSeed()     {
        return isSeed;
    }

	@Override
	public int getPrice()	{
		return price;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object other)     {
        return other instanceof Potato;
    }

    @Override
    public int hashCode()       {
        return 2;
    }
}