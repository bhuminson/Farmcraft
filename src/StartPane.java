import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartPane extends JPanel   {

    public StartPane(GraphicsMode mainFrame)  {
        JTextField input = new JTextField(20);
        JLabel copyright = new JLabel("Farmer Inc., Copyright 2019, Bhumin Son. All rights reserved.");
        JLabel welcome = new JLabel("Welcome to Farmer Inc.!");
        JLabel inputLabel = new JLabel("Name your farm:");
        add(copyright);
        add(welcome);
        add(inputLabel);
        add(input);

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