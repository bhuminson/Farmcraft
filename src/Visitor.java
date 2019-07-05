public interface Visitor	{
    
	void visit(Farm farm);
	void visit(Plot plot);
    void visit(Potato potato);
    void visit(Carrot carrot);
    void visit(Beet beet);
    void visit(PotatoSeed seed);
    void visit(CarrotSeed carrot);
    void visit(BeetSeed beet);
    void visit(Inventory inv);
    void visit(Market mkt);
}