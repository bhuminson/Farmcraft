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

        add(invLabel);
        add(seedLabel);
        add(potatoSeedsLabel);
        add(carrotSeedsLabel);
        add(beetSeedsLabel);
        add(cropLabel);
        add(potatoesLabel);
        add(carrotsLabel);
        add(beetsLabel);
        add(backToFarm);
    }
}