import java.util.Map;
import java.util.HashMap;

public class Inventory implements Paintable     {
    public Map<Plant, Integer> seeds;
    public Map<Plant, Integer> crops;

    public Inventory()      {
        seeds = new HashMap<Plant, Integer>();
        crops = new HashMap<Plant, Integer>();
    }

    public void addSeed(Plant seed)        {
        assert seed.isSeed() == true;

        if(seeds.containsKey(seed)) {
            int count = seeds.get(seed);
            seeds.put(seed, count+1);
        } else {
            seeds.put(seed, 1);
        }
    }

    public void removeSeed(Plant seed)        {
        assert seeds.containsKey(seed);

        if(seeds.containsKey(seed)) {
            int count = seeds.get(seed);
            seeds.put(seed, count - 1);
        } else {
            seeds.remove(seed);
        }
    }

    @Override
    public void accept(Visitor visitor)     {
        visitor.visit(this);
    }
}