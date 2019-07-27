import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class PlantMenu extends JFrame {

    private Plot plot;
    private Farm farm;
    static final int WIDTH = 300;
    static final int HEIGHT = 150;

    public PlantMenu(Farm farm, GraphicsMode mainFrame, Plot plot) {
        this.plot = plot;
        this.farm = farm;
        setLayout(new GridBagLayout());
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel feedback = new JLabel("");
        JLabel menuLabel = new JLabel("Plant");
        JButton plantPotato = new JButton("Potato");
        plantPotato.addActionListener((ActionEvent e) -> {
            int result = plantSpecific(new PotatoSeed(farm.getDayCount()), plot);
            if(result  == 2)  {
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                mainFrame.showFarm();
                mainFrame.refresh();
            } else if (result == 1) {
                feedback.setText("Something's growing here");
            } else {
                feedback.setText("Out of stock...");
            }
        });

        JButton plantCarrot = new JButton("Carrot");
        plantCarrot.addActionListener((ActionEvent e) -> {
            int result = plantSpecific(new CarrotSeed(farm.getDayCount()), plot);
            if(result  == 2)  {
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                mainFrame.showFarm();
                mainFrame.refresh();
            } else if (result == 1) {
                feedback.setText("Something's growing here");
            } else {
                feedback.setText("Out of stock...");
            }
        });

        JButton plantBeet = new JButton("Beet");
        plantBeet.addActionListener((ActionEvent e) -> {
            int result = plantSpecific(new BeetSeed(farm.getDayCount()), plot);
            if(result  == 2)  {
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                mainFrame.showFarm();
                mainFrame.refresh();
            } else if (result == 1) {
                feedback.setText("Something's growing here");
            } else {
                feedback.setText("Out of stock...");
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(menuLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(plantPotato, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(plantCarrot, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(plantBeet, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(feedback, gbc);
    }

    private int plantSpecific(Seed seed, Plot plot) {
        if(!farm.accessInv().checkStock(seed))   {
            return 0; // no seeds
        }
        if(!plot.isEmpty()) {
            return 1; // occupied
        }
        plot.setPlant(seed);
        farm.accessInv().removeSeed(seed);
        return 2; //success
    }
}