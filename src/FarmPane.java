import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FarmPane extends JPanel   {

    public FarmPane(GraphicsMode mainFrame, Farm farm)  {
        setBackground(Color.GREEN);

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
            mainFrame.showMarket();
            mainFrame.refresh();
        });

        JButton inv = new JButton("Inventory");
        inv.addActionListener((ActionEvent e) -> {
            mainFrame.showInventory();
            mainFrame.refresh();
        });

        JButton harvester = new JButton("Harvest");
        harvester.addActionListener((ActionEvent e) -> {
            farm.harvestAll();
        });


        add(sleep);
        add(farmName);
        add(dayCount);
        add(money);
        add(harvester);
        add(result);
        add(market);
        add(inv);
    }
}