import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class GraphicsPainter implements Visitor    {

    private GraphicsMode mainFrame;
    private FarmPane farmPane;
    private JPanel mktPane;
    private JPanel invPane;

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
}