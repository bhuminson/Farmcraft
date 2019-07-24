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
        setLayout(new GridBagLayout());
        setBackground(Color.ORANGE);
        JLabel mktWelcome = new JLabel("Welcome to Farm Depot!");
        JLabel usrCash = new JLabel("" + mkt.getUserCash());

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

        JLabel result = new JLabel("");
        result.setPreferredSize(new Dimension(180,25));

        JButton backToFarm = new JButton("Back to Farm");

        buyPotatoSeed.addActionListener((ActionEvent e) -> {
            if(mkt.buySeed(potatoSeed)){
                potatoSeedsLabel.setText("Potato seeds (" + mkt.getUserInv().getSeeds().get(potatoSeed) + ")");
                usrCash.setText("" + mkt.getUserCash());
                result.setText("Potato seed bought");
            } else {
                result.setText("You need more money...");
            }
        });

        buyCarrotSeed.addActionListener((ActionEvent e) -> {
            if(mkt.buySeed(carrotSeed)){
                carrotSeedsLabel.setText("Carrot seeds (" + mkt.getUserInv().getSeeds().get(carrotSeed) + ")");
                usrCash.setText("" + mkt.getUserCash());
                result.setText("Carrot seed bought");
            } else {
                result.setText("You need more money...");
            }
        });

        buyBeetSeed.addActionListener((ActionEvent e) -> {
            if(mkt.buySeed(beetSeed)){
                beetSeedsLabel.setText("Beet seeds (" + mkt.getUserInv().getSeeds().get(beetSeed) + ")");
                usrCash.setText("" + mkt.getUserCash());
                result.setText("Beet seed bought");
            } else {
                result.setText("You need more money...");
            }
        });

        sellAll.addActionListener((ActionEvent e) -> {
            if(mkt.sellAll()) {
                usrCash.setText("" + mkt.getUserCash());
                result.setText("You sold all your crops");
            } else {
                result.setText("You don't have anything to sell...");
            }
        });

        backToFarm.addActionListener((ActionEvent e) -> {
            mainFrame.showFarm();
            mainFrame.refresh();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        add(mktWelcome, gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(usrCash, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(buy, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(potatoSeedsLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        add(buyPotatoSeed, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(carrotSeedsLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        add(buyCarrotSeed, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(beetSeedsLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        add(buyBeetSeed, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(sell, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        add(potatoesLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 6;
        add(potatoPrice, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(carrotsLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 7;
        add(carrotPrice, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        add(beetsLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 8;
        add(beetPrice, gbc);

        gbc.gridx = 3;
        gbc.gridy = 9;
        add(sellAll, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(result, gbc);

        //Dummy component
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(new JLabel(""), gbc);

        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(backToFarm, gbc);
    }
}