import java.util.Map;
import java.util.HashMap;

public class Inventory implements Paintable     {
    public Map<Seed, Integer> seeds;
    public Map<Crop, Integer> crops;

    public Inventory()      {
        seeds = new HashMap<Seed, Integer>();
        crops = new HashMap<Crop, Integer>();
        seeds.put(new PotatoSeed(new Day()), 0);
        crops.put(new Potato(), 0);
    }

    public void addSeed(Seed seed)        {
        int count = seeds.get(seed);
        seeds.put(seed, count+1);
    }

    public void removeSeed(Seed seed)        {
        int count = seeds.get(seed);
        seeds.put(seed, count - 1);
    }

    public void addCrop(Crop crop) {
        int count = crops.get(crop);
        crops.put(crop, count+1);
    }

    public void removeCrop(Crop crop)  {
        assert crops.containsKey(crop);

        if(crops.containsKey(crop)) {
            int count = crops.get(crop);
            if(count == 1)  {
                crops.remove(crop);
                return;
            }
            crops.put(crop, count - 1);
        } else {
            crops.remove(crop);
        }
    }

    public boolean checkStock(Plant plantable)  {
        boolean stocked;
        if (plantable instanceof Seed) {
            stocked = (seeds.get(plantable) == 0) ? false: true;
            
        } else {
            stocked = (crops.get(plantable) == 0) ? false: true;
        }
        return stocked;
    }

    @Override
    public void accept(Visitor visitor)     {
        visitor.visit(this);
    }
}