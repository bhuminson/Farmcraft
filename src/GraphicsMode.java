import javax.swing.*;

public class GraphicsMode implements GUIMode    {

    private JFrame window;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 800;
    private JPanel farmPane;

    @Override
    public void setup() {
        window = new JFrame("Farmer Inc.");
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(false);
    }
    @Override
    public void nextScreen(){}
    
    @Override
    public void gameLoop(){}
    
    @Override
    public void farmTutorial(){}
    
    @Override
    public void invTutorial(){}
    
    @Override
    public void mktTutorial(){}
    
    @Override
    public void showFarm(){}
    
    @Override
    public void showInventory(){}
    
    @Override
    public void showMarket(){}

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
