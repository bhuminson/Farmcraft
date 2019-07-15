public class Farm implements Paintable	{
	private String name;
	private Plot[][] plots;
	private Bank finances;
	private Day dayCount;
    private Inventory inv;
    private Market mkt;
    private int upgradeCount;
    private int upgradeLvl;

	public Farm(String name)	{
		this.name = name;
        upgradeCount = 0;
        upgradeLvl = 1;
        plots = new Plot[3][3];
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                plots[i][j] = new Plot(3 * i + (j + 1));
            }
        }
		dayCount = new Day();
		finances = new Bank(9999);
		inv = new Inventory();
		mkt = new Market(finances, inv);
	}

	String getName() {
        return name;
    }

    Plot[][] getPlots()    {
        return plots;
    }

	Bank getFinances()  {
        return finances;
    }

    Day getDayCount()    {
        return dayCount;
    }

    Inventory accessInv()    {
        return inv;
    }

    Market visitMkt() {
        return mkt;
    }

    boolean upgradePlot()  {
        double price = nextUpgradeCost();
        if(!finances.canAfford(price))  {
            return false;
        }

        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                if(plots[i][j].getGradeIndex() < upgradeLvl)    {
                    plots[i][j].upgrade();
                    finances.withdraw(price);
                    if(i == 2 && j == 2) {
                        upgradeLvl++;
                    }
                    upgradeCount++;
                    return true;
                }
            }
        }
        return false;
    }

    double nextUpgradeCost()   {
        return 120 + 0.5 * (upgradeCount * upgradeCount);
    }

    void advance()	{
		dayCount.nextDay();
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                Plot curPlot = plots[i][j];
                Plant plant = curPlot.getPlant();
                if(plant instanceof Seed)	{
                    Seed seed = (Seed)plant;
                	if(seed.isRipe())   {
                        curPlot.setPlant(seed.transform());
                    }
                }
            }
        }
	}

	boolean harvestAll()	{
        boolean harvested = false;

        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                Plot curPlot = plots[i][j];
                Plant plant = curPlot.getPlant();
                if(plant instanceof Crop)	{
                	inv.addCrop((Crop)plant);
                	curPlot.removePlant();
            		harvested = true;
                }
            }
        }
        return harvested;
	}

	int plant(Seed seed)	{
		if(!inv.checkStock(seed))	{
			return 1; // no seeds
		}

        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                Plot curPlot = plots[i][j];
                if(curPlot.isEmpty())  {
                    curPlot.setPlant(seed);
                    inv.removeSeed(seed);
                    return 0; //success
                }
            }
        }
        return 2; // no land
	}

	@Override
	public void accept(Visitor visitor)	{
		visitor.visit(this);
	}
}
