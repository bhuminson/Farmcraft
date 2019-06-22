public class Plot	{

	public boolean planted;
	public Plant plant; 

	public Plot()	{
		planted = false;
	}

	public void plant(Plant plant)	{
		planted = true;
		this.plant = plant;
	}

	public void harvest()	{
		planted = false;
		this.plant = null;
	}

	public void paint()	{
		if(!planted) {
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