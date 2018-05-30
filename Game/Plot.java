import java.awt.*;
import javax.swing.*;
public class Plot extends JFrame
{
    private Seed plant;
    private String seedName;
    private String status;
    private int age;
    private boolean pickable;
    public Plot(JPanel contentPane,int pos) 
    {
        JButton plot = new JButton();
        contentPane.add(plot); //adds playbutton to frame
        plot.setBounds(pos*200-140,250,80,80); //positions button in frame
        plot.setBackground(new Color(160,82,45)); 
        
        // JButton plot = new JButton(seedName);
        
        // getContentPane().add(plot);
        // status = "empty";
    }    

    //sets Plot's seedname to name of plant
    public void plant(Seed seed)
    {
        plant = seed;
        seedName = seed.getName();
        age = 0;
        status = "unripe";
        pickable = false;
    }

    public void nextDay()
    {
        age++;
        isRipe();
    }

    public void isRipe()
    {
        if(this.age >= plant.daysToGrow())
        {
            status = "ripe";
            pickable = true;
        }
    }
    //removes plant from plot and stores in inventory
    public void pick()
    {

    }
}
