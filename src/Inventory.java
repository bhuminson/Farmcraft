import java.util.Map;
import java.util.HashMap;

public class Inventory implements Paintable     {
    public Map<Plant, Integer> seeds;
    public Map<Plant, Integer> crops;

    public Inventory()      {
        seeds = new HashMap<Plant, Integer>();
        crops = new HashMap<Plant, Integer>();
        
        seeds.put(new Potato(), 0);
    }

    public void addSeed(Plant seed)        {
        assert seed.isSeed() == true;

        int count = seeds.get(seed);
        seeds.put(seed, count+1);
    }

    public void removeSeed(Plant seed)        {
        assert seeds.containsKey(seed);

        if(seeds.containsKey(seed)) {
            int count = seeds.get(seed);
            if(count == 1)  {
                seeds.remove(seed);
                return;
            }
            seeds.put(seed, count - 1);
        } else {
            seeds.remove(seed);
        }
    }

    public void addCrop(Plant crop) {
        assert crop.isSeed() == false;

        if(crops.containsKey(crop)) {
            int count = crops.get(crop);
            crops.put(crop, count+1);
        } else {
            crops.put(crop, 1);
        }
    }

    public void removeCrop(Plant crop)  {
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
        if (plantable.isSeed()) {
            return seeds.containsKey(plantable);
        } else {
            return crops.containsKey(plantable);
        }
    }

    @Override
    public void accept(Visitor visitor)     {
        visitor.visit(this);
    }
}