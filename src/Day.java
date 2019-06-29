public class Day {
    
    private int day;

    Day() {
        day = 0;
    }

    int getDay() {
        return day;
    }

    void nextDay() {
        day++;
    }

    public String toString()    {
        return "Day " + day;
    }
}