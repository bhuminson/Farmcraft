import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GraphicsPainter implements Visitor    {

    private GraphicsMode mainFrame;
    private FarmPane farmPane;
    private JPanel mktPane;
    private JPanel invPane;
    static BufferedImage plot;
    static BufferedImage carrotSeedPlot;
    static BufferedImage potatoSeedPlot;
    static BufferedImage beetSeedPlot;
    static BufferedImage carrotPlot;
    static BufferedImage potatoPlot;
    static BufferedImage beetPlot;

    static {
        plot = loadImage(new File("src/sprites/plot.png"));
        carrotSeedPlot = loadImage(new File("src/sprites/carrot_seed_plot.png"));
        potatoSeedPlot = loadImage(new File("src/sprites/potato_seed_plot.png"));
        beetSeedPlot = loadImage(new File("src/sprites/beet_seed_plot.png"));
        carrotPlot = loadImage(new File("src/sprites/carrot_plot.png"));
        potatoPlot = loadImage(new File("src/sprites/potato_plot.png"));
        beetPlot = loadImage(new File("src/sprites/beet_plot.png"));
    }

    GraphicsPainter(GraphicsMode mainFrame)   {
        this.mainFrame = mainFrame;
    }

    @Override
    public void visit(Farm farm) {
        mainFrame.setContentPane(new FarmPane(mainFrame, farm));
    }

    @Override
    public void visit(Plot plot){

    }

    @Override
    public void visit(Potato potato){

    }

    @Override
    public void visit(Carrot carrot){

    }

    @Override
    public void visit(Beet beet){

    }

    @Override
    public void visit(PotatoSeed seed){

    }

    @Override
    public void visit(CarrotSeed carrot){

    }

    @Override
    public void visit(BeetSeed beet){

    }

    @Override
    public void visit(Inventory inv){
        mainFrame.setContentPane(new InvPane(mainFrame, inv));
    }

    @Override
    public void visit(Market mkt){
        mainFrame.setContentPane(new MktPane(mainFrame, mkt));
    }

    private static BufferedImage loadImage(File file)  {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(file);
        } catch(IOException e) {
            System.out.println("Missing game files");
        }
        return sprite;
    }
}