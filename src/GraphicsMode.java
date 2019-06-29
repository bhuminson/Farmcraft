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
    public void nextScreen(){}
    public void gameLoop(){}

    public void farmTutorial(){}
    public void invTutorial(){}
    public void mktTutorial(){}

    public void showFarm(){}
    public void showInventory(){}
    public void showMarket(){}

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
