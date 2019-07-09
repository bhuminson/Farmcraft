import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GraphicsMode implements GUIMode    {

    private final JFrame window = new JFrame("Farmer Inc.");
    private final Visitor graphicsPainter = new GraphicsPainter(window);
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 800;
    private Farm farm;

    @Override
    public void setup() {
        window.setLayout(new GridBagLayout());

        JPanel startPane = new JPanel();
        JTextField input = new JTextField(20);
        JLabel copyright = new JLabel("Farmer Inc., Copyright 2019, Bhumin Son. All rights reserved.");
        JLabel welcome = new JLabel("Welcome to Farmer Inc.!");
        JLabel inputLabel = new JLabel("Name your farm:");
        startPane.add(copyright);
        startPane.add(welcome);
        startPane.add(inputLabel);
        startPane.add(input);
        window.add(startPane);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        input.addActionListener((ActionEvent e) -> {
            String name = input.getText();
            if(name == null)    {
                return;
            }
            window.remove(startPane);
            farm = new Farm(name);
            nextScreen();
            farm.accept(graphicsPainter);
        });
    }

    @Override
    public void nextScreen(){
        window.repaint();
    }
}
