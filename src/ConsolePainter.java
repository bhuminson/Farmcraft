public class ConsolePainter implements Visitor	{

	@Override
	public void visit(Farm farm)	{
		System.out.println("______________________________________________________");
		System.out.println(farm.name);
		System.out.println("");
		for(Plot plot: farm.plots)	{
			plot.accept(this);
		}
		System.out.println("______________________________________________________");
	}

	@Override
	public void visit(Plot plot)	{
		if(!plot.planted) {
			System.out.println("---------");
			System.out.println("---------");
			System.out.println("---------");
			System.out.println("---------");
			System.out.println("---------\n");
			return;
		}
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********\n");
	}
}