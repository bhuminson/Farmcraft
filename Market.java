import java.util.Map;
import java.util.HashMap;

public class Market implements Paintable    {
    public Map<Plant, Integer> seeds;
    public Map<Plant, Integer> crops;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}