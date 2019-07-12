import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class GraphicsPainter implements Visitor    {

    private JFrame window;
    private JPanel farmPane;
    private JPanel mktPane;
    private JPanel invPane;

    private final PotatoSeed potatoSeed = new PotatoSeed(new Day());
    private final CarrotSeed carrotSeed = new CarrotSeed(new Day());
    private final BeetSeed beetSeed = new BeetSeed(new Day());
    private final Potato potato = new Potato();
    private final Carrot carrot = new Carrot();
    private final Beet beet = new Beet();

    GraphicsPainter(JFrame window)   {
        this.window = window;
        farmPane = new JPanel();
        mktPane = new JPanel();
        invPane = new JPanel();
    }

    @Override
    public void visit(Farm farm) {
        farmPane.setBackground(Color.GREEN);

        JLabel farmName = new JLabel(farm.getName());
        JLabel dayCount = new JLabel("" + farm.getDayCount());
        JLabel money = new JLabel("" + farm.getFinances());
        JLabel result = new JLabel();

        JButton sleep = new JButton("Sleep");
        sleep.addActionListener((ActionEvent e) ->  {
            farm.advance();
            dayCount.setText("" + farm.getDayCount());
        });

        JButton market = new JButton("Market");
        market.addActionListener((ActionEvent e) -> {
            window.setContentPane(mktPane);
            refresh();
        });

        JButton inv = new JButton("Inventory");
        inv.addActionListener((ActionEvent e) -> {
            window.setContentPane(invPane);
            refresh();
        });

        JButton harvester = new JButton("Harvest");
        harvester.addActionListener((ActionEvent e) -> {
            farm.harvestAll();
        });


        farmPane.add(sleep);
        farmPane.add(farmName);
        farmPane.add(dayCount);
        farmPane.add(money);
        farmPane.add(harvester);
        farmPane.add(result);
        farmPane.add(market);
        farmPane.add(inv);

        window.add(farmPane);
        refresh();
    }

    @Override
    public void visit(Plot plot){

    }

    @Override
    public void visit(Potato potato){

    }

    @Override
    public void visit(Carrot carrot){

    }

    @Override
    public void visit(Beet beet){

    }

    @Override
    public void visit(PotatoSeed seed){

    }

    @Override
    public void visit(CarrotSeed carrot){

    }

    @Override
    public void visit(BeetSeed beet){

    }

    @Override
    public void visit(Inventory inv){
        invPane.setBackground(Color.CYAN);
        JLabel invLabel = new JLabel("Inventory");

        JLabel seedLabel = new JLabel("Seeds");
        JLabel potatoSeedsLabel = new JLabel("Potato seeds (" + inv.getSeeds().get(potatoSeed) + ")");
        JLabel carrotSeedsLabel = new JLabel("Carrot seeds (" + inv.getSeeds().get(carrotSeed) + ")");
        JLabel beetSeedsLabel = new JLabel("Beet seeds (" + inv.getSeeds().get(beetSeed) + ")");

        JLabel cropLabel = new JLabel("Crops");
        JLabel potatoesLabel = new JLabel("Potatoes (" + inv.getCrops().get(potato) + ")");
        JLabel carrotsLabel = new JLabel("Carrots (" + inv.getCrops().get(carrot) + ")");
        JLabel beetsLabel = new JLabel("Beets (" + inv.getCrops().get(beet) + ")");

        JButton backToFarm = new JButton("Back to Farm");
        backToFarm.addActionListener((ActionEvent e) -> {
            window.setContentPane(farmPane);
        });

        invPane.add(invLabel);
        invPane.add(seedLabel);
        invPane.add(potatoSeedsLabel);
        invPane.add(carrotSeedsLabel);
        invPane.add(beetSeedsLabel);
        invPane.add(cropLabel);
        invPane.add(potatoesLabel);
        invPane.add(carrotsLabel);
        invPane.add(beetsLabel);
        invPane.add(backToFarm);
    }

    @Override
    public void visit(Market mkt){
        mktPane.setBackground(Color.ORANGE);
        JLabel mktWelcome = new JLabel("Welcome to Farm Depot!");

        JLabel buy = new JLabel("Buy");
        JLabel potatoSeedsLabel = new JLabel("Potato seeds (" + mkt.getUserInv().getSeeds().get(potatoSeed) + ")");
        JButton buyPotatoSeed = new JButton("$" + potatoSeed.getBuyPrice());
        JLabel carrotSeedsLabel = new JLabel("Carrot seeds (" + mkt.getUserInv().getSeeds().get(carrotSeed) + ")");
        JButton buyCarrotSeed = new JButton("$" + carrotSeed.getBuyPrice());
        JLabel beetSeedsLabel = new JLabel("Beet seeds (" + mkt.getUserInv().getSeeds().get(beetSeed) + ")");
        JButton buyBeetSeed = new JButton("$" + beetSeed.getBuyPrice());

        JLabel sell = new JLabel("Sell");
        JLabel potatoesLabel = new JLabel("Potatoes (" + mkt.getUserInv().getCrops().get(potato) + ")");
        JLabel potatoPrice = new JLabel("$" + potato.getSellPrice());
        JLabel carrotsLabel = new JLabel("Carrots (" + mkt.getUserInv().getCrops().get(carrot) + ")");
        JLabel carrotPrice = new JLabel("$" + carrot.getSellPrice());
        JLabel beetsLabel = new JLabel("Beets (" + mkt.getUserInv().getCrops().get(beet) + ")");
        JLabel beetPrice = new JLabel("$" + beet.getSellPrice());
        JButton sellAll = new JButton("Sell All Crops");

        JButton backToFarm = new JButton("Back to Farm");

        buyPotatoSeed.addActionListener((ActionEvent e) -> {
            mkt.buySeed(potatoSeed);
            potatoSeedsLabel.setText("Potato seeds (" + mkt.getUserInv().getSeeds().get(potatoSeed) + ")");
        });

        buyCarrotSeed.addActionListener((ActionEvent e) -> {
            mkt.buySeed(carrotSeed);
            carrotSeedsLabel.setText("Carrot seeds (" + mkt.getUserInv().getSeeds().get(carrotSeed) + ")");
        });

        buyBeetSeed.addActionListener((ActionEvent e) -> {
            mkt.buySeed(beetSeed);
            beetSeedsLabel.setText("Beet seeds (" + mkt.getUserInv().getSeeds().get(beetSeed) + ")");

        });

        sellAll.addActionListener((ActionEvent e) -> {
            mkt.sellAll();
        });

        backToFarm.addActionListener((ActionEvent e) -> {
            window.setContentPane(farmPane);
        });

        mktPane.add(mktWelcome);

        mktPane.add(buy);
        mktPane.add(potatoSeedsLabel);
        // mktPane.add(potatoSeedSLabeltock);
        mktPane.add(buyPotatoSeed);
        mktPane.add(carrotSeedsLabel);
        // mktPane.add(carrotSeedSLabeltock);
        mktPane.add(buyCarrotSeed);
        mktPane.add(beetSeedsLabel);
        // mktPane.add(beetSeedSLabeltock);
        mktPane.add(buyBeetSeed);

        mktPane.add(sell);
        mktPane.add(potatoesLabel);
        mktPane.add(potatoPrice);
        // mktPane.add(potatoStock);
        mktPane.add(carrotsLabel);
        mktPane.add(carrotPrice);
        // mktPane.add(carrotStock);
        mktPane.add(beetsLabel);
        mktPane.add(beetPrice);
        // mktPane.add(beetStock);
        mktPane.add(sellAll);

        mktPane.add(backToFarm);
    }

    private void refresh()   {
        window.invalidate();
        window.validate();
        window.repaint();
    }
}