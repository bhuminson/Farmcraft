public class Plot implements Paintable {

	private static final String[] grades = {"F", "D", "C", "B", "A", "S", "SS"
											, "SSS", "4S", "5S", "X"};
	private boolean planted;
	private Plant plant; 
	private int number;
	private int gradeIndex;

	Plot(int number)	{
		planted = false;
		gradeIndex = 0;
		this.number = number;
	}

	void upgrade()	{
		if(gradeIndex < grades.length - 1)	{ 
			gradeIndex++;
		}
	}

	int getNumber()	{
		return number;
	}

	int getGradeIndex()	{
		return gradeIndex;
	}

	String getGrade()	{
		return grades[gradeIndex];
	}

	boolean isEmpty()	{
		return !planted;
	}

	void setPlant(Plant plant)	{
		planted = true;
		this.plant = plant;
	}

	Plant getPlant()	{
		return plant;
	}

	void removePlant()	{
		planted = false;
		this.plant = null;
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}