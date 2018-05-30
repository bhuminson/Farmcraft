import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class Farm extends Game
{
    JPanel contentPanel;
    private static int day;
    private int cash;
    private ArrayList<Plot> plots;
    //initializes name of farm, creates farm with 5 plots
    public Farm(String name)
    {
        //MAKES GREEN PANEL CONTENT OF WINDOW
        JPanel contentPanel = new JPanel(null); //makes a JPanel with no layout
        contentPanel.setBackground(new Color(0,204,102)); //makes panel forest green
        setContentPane(contentPanel); //sets content pane of frame to be this Jpanel

        //FARM NAME ON TOP CENTER
        JLabel intro = new JLabel(name);
        intro.setFont(new Font("Verdana",1,26)); //sets fonts
        contentPanel.add(intro);
        intro.setBounds(230,00,300,50);

        //CASH ON TOP RIGHT
        cash = 10;
        JTextField money = new JTextField("$"+cash);
        money.setFont(new Font("Verdana",1,26)); //sets fonts
        money.setEditable(false);
        contentPanel.add(money);
        money.setBounds(510,0,300,50);
        money.setBackground(new Color(0,204,102));
        money.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        //DAY COUNTER ON TOP LEFT
        day = 1;
        JTextField daycount = new JTextField("Day " + day);
        daycount.setEditable(false);
        daycount.setFont(new Font("Verdana",1,26)); //sets fonts
        contentPanel.add(daycount);
        daycount.setBounds(10,0,110,50);
        daycount.setBackground(new Color(0,204,102));
        daycount.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        //SLEEP BUTTON
        JButton sleep = new JButton("Sleep"); //makes button
        sleep.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    day++;
                    daycount.setText("Day " + day);
                }
            }); //button becomes source of ActionEvent
        contentPanel.add(sleep); //adds playbutton to frame
        sleep.setBounds(250,500,100,40); //positions button in frame

        //MAKES FARM PLOTS
        new Plot(contentPanel,1);
        new Plot(contentPanel,2);
        new Plot(contentPanel,3);
    }

    public void makePlots()
    {

    }

    //advances next day
    public void nextDay()
    {
        day++;
    }

}
