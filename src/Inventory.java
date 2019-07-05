import java.util.Map;
import java.util.HashMap;

public class Inventory implements Paintable     {
    private Map<Seed, Integer> seeds;
    private Map<Crop, Integer> crops;

    public Inventory()      {
        seeds = new HashMap<>();
        crops = new HashMap<>();
        seeds.put(new PotatoSeed(new Day()), 0);
        seeds.put(new CarrotSeed(new Day()), 0);
        seeds.put(new BeetSeed(new Day()), 0);
        crops.put(new Potato(), 0);
        crops.put(new Carrot(), 0);
        crops.put(new Beet(), 0);
    }

    Map getSeeds()   {
        return seeds;
    }

    void addSeed(Seed seed)        {
        int count = seeds.get(seed);
        seeds.put(seed, count+1);
    }

    void removeSeed(Seed seed)        {
        int count = seeds.get(seed);
        seeds.put(seed, count - 1);
    }

    Map getCrops()   {
        return crops;
    }

    void addCrop(Crop crop) {
        int count = crops.get(crop);
        crops.put(crop, count+1);
    }

    void removeCrop(Crop crop)  {
        int count = crops.get(crop);
        crops.put(crop, count - 1);
    }

    boolean checkStock(Plant plantable)  {
        boolean stocked = false;
        
        if (plantable instanceof Seed) {
            stocked = (seeds.get(plantable) != 0);
            
        } else if(plantable instanceof Crop) {
            stocked = (crops.get(plantable) != 0);
        }
        return stocked;
    }

    @Override
    public void accept(Visitor visitor)     {
        visitor.visit(this);
    }
}