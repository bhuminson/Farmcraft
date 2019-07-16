import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartPane extends JPanel   {

    public StartPane(GraphicsMode mainFrame)  {
        setLayout(new GridBagLayout());
        JTextField input = new JTextField(20);
        JLabel copyright = new JLabel("Farmer Inc., Copyright 2019, Bhumin Son. All rights reserved.");
        JLabel welcome = new JLabel("Welcome to Farmer Inc.!");
        JLabel inputLabel = new JLabel("Name your farm:");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        add(welcome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(inputLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        add(input, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(copyright, gbc);
        

        input.addActionListener((ActionEvent e) -> {
            String name = input.getText();
            if(name == null)    {
                return;
            }
            Farm farm = new Farm(name);

            mainFrame.createGame(farm);
            mainFrame.showFarm();
            mainFrame.refresh();
        });
    }
}