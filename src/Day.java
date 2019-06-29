public class Day {
    
    private int day;

    public Day() {
        day = 0;
    }

    public int getDay() {
        return day;
    }

    public void nextDay() {
        day++;
    }

    public String toString()    {
        return "Day " + day;
    }
}