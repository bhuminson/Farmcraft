public interface Plant	{
    boolean isSeed();
	int getPrice();
    void accept(Visitor visitor);
    boolean equals(Object other);
    int hashCode(); 
}