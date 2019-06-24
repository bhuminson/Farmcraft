public class ConsolePainter implements Visitor	{

	private static final int PLOT_WIDTH = 9;
	private static final int PLOT_HEIGHT = 5;

	@Override
	public void visit(Farm farm)	{
		System.out.println("______________________________________________________");
		System.out.println(farm.name);
		System.out.println("$" + farm.cash);
		System.out.println("Day " + farm.day);
		System.out.println("");
		for(Plot plot: farm.plots)	{
			plot.accept(this);
		}
		System.out.println("______________________________________________________");
	}

	@Override
	public void visit(Plot plot)	{
		String token;
		if(!plot.planted) {
			for(int i = 0; i < PLOT_HEIGHT; i++)	{
				for(int j = 0; j < PLOT_WIDTH; j++)	{
					System.out.print("-");
				}
				System.out.println("");
			}
		} else {
			for(int i = 0; i < PLOT_HEIGHT; i++)	{
				for(int j = 0; j < PLOT_WIDTH; j++)	{
					plot.getPlant().accept(this);
				}
				System.out.println("");
			}
		}
		System.out.println("");
	}

	@Override
	public void visit(Potato potato)	{
		System.out.print("P");
	}
} 