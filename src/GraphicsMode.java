import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GraphicsMode extends JFrame implements GUIMode    {

    private final Visitor graphicsPainter = new GraphicsPainter(this);
    static final int WIDTH = 1280;
    static final int HEIGHT = 800;
    private Farm farm;

    public GraphicsMode()   {
        super("Farmer Inc.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    void createGame(Farm farm)   {
        this.farm = farm;
    }

    @Override
    public void setup() {
        setContentPane(new StartPane(this));
        refresh();
    }

    @Override
    public void refresh(){
        invalidate();
        validate();
        repaint();
        setVisible(true);
        // pack();
    }

    @Override
    public void showFarm()  {
        farm.accept(graphicsPainter);
    }

    @Override
    public void showMarket()    {
        farm.visitMkt().accept(graphicsPainter);
    }

    @Override
    public void showInventory() {
        farm.accessInv().accept(graphicsPainter);
    }
}
