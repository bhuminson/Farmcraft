public interface Visitor	{
	void visit(Farm farm);
	void visit(Plot plot);
    void visit(Potato potato);
    void visit(Inventory inv);
    void visit(Market mkt);
}