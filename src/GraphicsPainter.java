import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class GraphicsPainter implements Visitor    {

    private JFrame window;
    private JPanel farmPane;
    private JPanel marketPane;

    private final PotatoSeed potatoSeed = new PotatoSeed(new Day());
    private final CarrotSeed carrotSeed = new CarrotSeed(new Day());
    private final BeetSeed beetSeed = new BeetSeed(new Day());
    private final Potato potato = new Potato();
    private final Carrot carrot = new Carrot();
    private final Beet beet = new Beet();

    GraphicsPainter(JFrame window)   {
        this.window = window;
        farmPane = new JPanel();
        marketPane = new JPanel();
    }

    @Override
    public void visit(Farm farm) {
        window.getContentPane().setBackground(Color.GREEN);

        JLabel farmName = new JLabel(farm.getName());
        JLabel dayCount = new JLabel(""+farm.getDayCount());
        JLabel money = new JLabel(""+farm.getFinances());
        JLabel result = new JLabel();

        JButton sleep = new JButton("Sleep");
        sleep.addActionListener((ActionEvent e) ->  {
            farm.advance();
            dayCount.setText("" + farm.getDayCount());
        });

        JButton market = new JButton("Market");
        market.addActionListener((ActionEvent e) -> {
            visit(farm.visitMkt());
        });

        JButton inv = new JButton("Inventory");
        inv.addActionListener((ActionEvent e) -> {
            visit(farm.accessInv());
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
        farmPane.add(market);

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

    }

    @Override
    public void visit(Market mkt){
        window.getContentPane().setBackground(Color.ORANGE);

        JLabel potatoSeeds = new JLabel("Potato seeds ($" + potatoSeed.getBuyPrice() + ")");
        JLabel potatoStock = new JLabel("Your stock: " + mkt.getUserInv().getSeeds().get(potatoSeed));
        JButton buyPotato = new JButton("Buy");
        JLabel carrotSeeds = new JLabel("Carrot seeds ($" + carrotSeed.getBuyPrice() + ")");
        JLabel carrotStock = new JLabel("Your stock: " + mkt.getUserInv().getSeeds().get(carrotSeed));
        JButton buyCarrot = new JButton("Buy");
        JLabel beetSeeds = new JLabel("Beet seeds ($" + beetSeed.getBuyPrice() + ")");
        JLabel beetStock = new JLabel("Your stock: " + mkt.getUserInv().getSeeds().get(beetSeed));
        JButton buyBeet = new JButton("Buy");

        JButton backToFarm = new JButton("Farm");
        backToFarm.addActionListener((ActionEvent e) -> {
            window.setContentPane(farmPane);
            refresh();
        });

        marketPane.add(potatoSeeds);
        marketPane.add(potatoStock);
        marketPane.add(buyPotato);
        marketPane.add(carrotSeeds);
        marketPane.add(carrotStock);
        marketPane.add(buyCarrot);
        marketPane.add(beetSeeds);
        marketPane.add(beetStock);
        marketPane.add(buyBeet);
        marketPane.add(backToFarm);

        window.setContentPane(marketPane);
        refresh();
    }

    private void refresh()   {
        window.invalidate();
        window.validate();
        window.repaint();
    }
}