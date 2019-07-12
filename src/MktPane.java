import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MktPane extends JPanel   {

    private final PotatoSeed potatoSeed = new PotatoSeed(new Day());
    private final CarrotSeed carrotSeed = new CarrotSeed(new Day());
    private final BeetSeed beetSeed = new BeetSeed(new Day());
    private final Potato potato = new Potato();
    private final Carrot carrot = new Carrot();
    private final Beet beet = new Beet();

    public MktPane(GraphicsMode mainFrame, Market mkt)  {
        setBackground(Color.GREEN);
        setBackground(Color.ORANGE);
        JLabel mktWelcome = new JLabel("Welcome to Farm Depot!");
        JLabel usrCash = new JLabel("$" + mkt.getUserCash());

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
            usrCash.setText("$" + mkt.getUserCash());
        });

        buyCarrotSeed.addActionListener((ActionEvent e) -> {
            mkt.buySeed(carrotSeed);
            carrotSeedsLabel.setText("Carrot seeds (" + mkt.getUserInv().getSeeds().get(carrotSeed) + ")");
            usrCash.setText("$" + mkt.getUserCash());
        });

        buyBeetSeed.addActionListener((ActionEvent e) -> {
            mkt.buySeed(beetSeed);
            beetSeedsLabel.setText("Beet seeds (" + mkt.getUserInv().getSeeds().get(beetSeed) + ")");
            usrCash.setText("$" + mkt.getUserCash());
        });

        sellAll.addActionListener((ActionEvent e) -> {
            mkt.sellAll();
        });

        backToFarm.addActionListener((ActionEvent e) -> {
            mainFrame.showFarm();
            mainFrame.refresh();
        });

        add(mktWelcome);
        add(usrCash);

        add(buy);
        add(potatoSeedsLabel);
        add(buyPotatoSeed);
        add(carrotSeedsLabel);
        add(buyCarrotSeed);
        add(beetSeedsLabel);
        add(buyBeetSeed);

        add(sell);
        add(potatoesLabel);
        add(potatoPrice);
        add(carrotsLabel);
        add(carrotPrice);
        add(beetsLabel);
        add(beetPrice);
        add(sellAll);

        add(backToFarm);
    }
}