import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class FarmPane extends JPanel   {

    public FarmPane(GraphicsMode mainFrame, Farm farm)  {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(new Color(0, 180, 0));

        JLabel farmName = new JLabel(farm.getName());
        JLabel dayCount = new JLabel("" + farm.getDayCount());
        JLabel money = new JLabel("" + farm.getFinances());
        JLabel result = new JLabel("", SwingConstants.CENTER);
        result.setPreferredSize(new Dimension(170,25));

        JButton sleep = new JButton("Sleep");
        sleep.addActionListener((ActionEvent e) ->  {
            farm.advance();
            dayCount.setText("" + farm.getDayCount());
            result.setText("You slept well");
            mainFrame.showFarm();
            mainFrame.refresh();
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
            if(farm.harvestAll())   {
                result.setText("Harvest Success!");
            } else {
                result.setText("You have nothing to harvest...");
            }
            mainFrame.showFarm();
            mainFrame.refresh();
        });

        JButton quit = new JButton("Quit");
        quit.addActionListener((ActionEvent e) -> {
            mainFrame.dispose();
            System.exit(0);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(dayCount, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        add(farmName, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(money, gbc);

        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        add(harvester, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(result, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(sleep, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(market, gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(inv, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        add(quit, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 3; j++)  {
                JButton plotButton = null;
                Plot plot = farm.getPlot(i, j);

                if(plot.isEmpty()) {
                    plotButton = new JButton(new ImageIcon(GraphicsPainter.plot));
                } else {
                    Plant plant = plot.getPlant();
                    if(plant.getID().equals("PotatoSeed"))  {
                        plotButton = new JButton(new ImageIcon(GraphicsPainter.potatoSeedPlot));
                    }
                    if(plant.getID().equals("Potato"))  {
                        plotButton = new JButton(new ImageIcon(GraphicsPainter.potatoPlot));
                    }
                    if(plant.getID().equals("CarrotSeed"))  {
                        plotButton = new JButton(new ImageIcon(GraphicsPainter.carrotSeedPlot));
                    }
                    if(plant.getID().equals("Carrot"))  {
                        plotButton = new JButton(new ImageIcon(GraphicsPainter.carrotPlot));
                    }
                    if(plant.getID().equals("BeetSeed"))  {
                        plotButton = new JButton(new ImageIcon(GraphicsPainter.beetSeedPlot));
                    }
                    if(plant.getID().equals("Beet"))  {
                        plotButton = new JButton(new ImageIcon(GraphicsPainter.beetPlot));
                    }
                }

                plotButton.setOpaque(false);
                plotButton.setContentAreaFilled(false);
                plotButton.setBorderPainted(false);

                plotButton.addActionListener((ActionEvent e) -> {
                    PlantMenu menu = new PlantMenu(farm, mainFrame, plot);
                });

                gbc.gridx = i + 1;
                gbc.gridy = j + 1;
                add(plotButton, gbc);
            }
        }
    }

    
}