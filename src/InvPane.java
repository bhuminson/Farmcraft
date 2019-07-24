import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvPane extends JPanel   {
    
    private final PotatoSeed potatoSeed = new PotatoSeed(new Day());
    private final CarrotSeed carrotSeed = new CarrotSeed(new Day());
    private final BeetSeed beetSeed = new BeetSeed(new Day());
    private final Potato potato = new Potato();
    private final Carrot carrot = new Carrot();
    private final Beet beet = new Beet();

    public InvPane(GraphicsMode mainFrame, Inventory inv)  {
        setLayout(new GridBagLayout());
        setBackground(Color.CYAN);
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
            mainFrame.showFarm();
            mainFrame.refresh();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        add(invLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(seedLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(potatoSeedsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(carrotSeedsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(beetSeedsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(cropLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(potatoesLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        add(carrotsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        add(beetsLabel, gbc);

        //Dummy for column 2
        gbc.gridx = 2;
        add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(backToFarm, gbc);
    }
}