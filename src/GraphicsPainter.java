import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class GraphicsPainter implements Visitor    {

    private JFrame window;

    GraphicsPainter(JFrame window)   {
        this.window = window;
    }

    @Override
    public void visit(Farm farm){
        JPanel farmPane = new JPanel();
        JLabel farmName = new JLabel(farm.getName());
        JLabel dayCount = new JLabel(""+farm.getDayCount());
        JLabel money = new JLabel(""+farm.getFinances());
        JLabel result = new JLabel();
        JButton sleep = new JButton("Sleep");
        JButton harvester = new JButton("Harvest");

        sleep.addActionListener((ActionEvent e) ->  {
            farm.advance();
            dayCount.setText("" + farm.getDayCount());
        });

        farmPane.add(sleep);
        farmPane.add(farmName);
        farmPane.add(dayCount);
        farmPane.add(money);
        farmPane.add(harvester);
        farmPane.add(result);

        window.add(farmPane);
        refresh();
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

    }

    @Override
    public void visit(Market mkt){

    }

    private void refresh()   {
        window.invalidate();
        window.validate();
        window.repaint();
    }
}