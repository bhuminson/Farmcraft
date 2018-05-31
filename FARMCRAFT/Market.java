import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Market extends JFrame
{
    public Market(int day, int cash)
    {
        //OPENS MARKET WINDOW WHEN CLICKED
        JFrame marketWindow = new JFrame();
        marketWindow.setTitle("Market");//makes window titled Farmcraft
        marketWindow.setSize(600, 600);  //sets size of window 600px by 600px
        marketWindow.setVisible(true); //makes the window pop up on screen
        marketWindow.setResizable(false); //prevents user from resizing window
        marketWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes X button close the window and stop program
        marketWindow.setLocationRelativeTo(null);

        // MAKES GREEN PANEL CONTENT OF WINDOW
        JPanel contentPanel = new JPanel(null); //makes a JPanel with no layout
        contentPanel.setBackground(new Color(0,204,102)); //makes panel forest green
        marketWindow.setContentPane(contentPanel); //sets content pane of frame to be this Jpanel

        // TEXT ON SCREEN
        JLabel title = new JLabel("Market"); //Makes FARMCRAFT textbox
        title.setFont(new Font("Verdana",1,32)); //sets fonts
        contentPanel.add(title); //adds text to frame
        title.setBounds(235,00,500,80); //positions text in frame

        // CROP LABEL
        JLabel crop = new JLabel("Crop");
        crop.setFont(new Font("Verdana",1,20)); //sets fonts
        contentPanel.add(crop); //adds text to frame
        crop.setBounds(35,100,100,80); //positions text in frame

        // INVENTORY LABEL
        JLabel inv = new JLabel("Inventory");
        inv.setFont(new Font("Verdana",1,20)); //sets fonts
        contentPanel.add(inv); //adds text to frame
        inv.setBounds(225,100,200,80); //positions text in frame

        //BUY BUTTONS
        JButton buyCorn = new JButton("Buy"); //makes button
        buyCorn.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    //INCREASE CORN IN INVENTORY BY ONE
                }
            }); //button becomes source of ActionEvent
        contentPanel.add(buyCorn); //adds playbutton to frame
        buyCorn.setBounds(400,150,80,40); //positions button in frame
        
        JButton buyBeet = new JButton("Buy"); //makes button
        buyBeet.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    //INCREASE BEET IN INVENTORY BY ONE
                }
            }); //button becomes source of ActionEvent
        contentPanel.add(buyBeet); //adds playbutton to frame
        buyBeet.setBounds(400,230,80,40); //positions button in frame
        
        JButton buyTomato = new JButton("Buy"); //makes button
        buyTomato.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    //INCREASE TOMATO IN INVENTORY BY ONE
                }
            }); //button becomes source of ActionEvent
        contentPanel.add(buyTomato); //adds playbutton to frame
        buyTomato.setBounds(400,330,80,40); //positions button in frame

        // CORN LABEL
        JLabel corn = new JLabel("Corn - $4");
        corn.setFont(new Font("Verdana",1,20)); //sets fonts
        contentPanel.add(corn); //adds text to frame
        corn.setBounds(35,130,200,80); //positions text in frame

        //CORN STOCK
        JTextField cornStock = new JTextField("" + 0);//TO BE CHANGED TO INV VALUE);
        cornStock.setEditable(false);
        cornStock.setFont(new Font("Verdana",1,26)); //sets fonts
        contentPanel.add(cornStock);
        cornStock.setBounds(275,130,100,80);
        cornStock.setBackground(new Color(0,204,102));
        cornStock.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        //BEET LABEL
        JLabel beet = new JLabel("Beet - $6");
        beet.setFont(new Font("Verdana",1,20)); //sets fonts
        contentPanel.add(beet); //adds text to frame
        beet.setBounds(35,210,500,80); //positions text in frame

        //BEET STOCK
        JTextField beetStock = new JTextField(""+0);//TO BE CHANGED TO INV VALUE);
        beetStock.setEditable(false);
        beetStock.setFont(new Font("Verdana",1,26)); //sets fonts
        contentPanel.add(beetStock);
        beetStock.setBounds(275,210,500,80);
        beetStock.setBackground(new Color(0,204,102));
        beetStock.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        //TOMATO LABEL
        JLabel tomato = new JLabel("Tomato - $7" );
        tomato.setFont(new Font("Verdana",1,20)); //sets fonts
        contentPanel.add(tomato); //adds text to frame
        tomato.setBounds(35,310,500,80); //positions text in frame
        //TOMATO STOCK
        JTextField tomatoStock = new JTextField(""+0);//TO BE CHANGED TO INV VALUE);
        tomatoStock.setEditable(false);
        tomatoStock.setFont(new Font("Verdana",1,26)); //sets fonts
        contentPanel.add(tomatoStock);
        tomatoStock.setBounds(275,310,500,80);
        tomatoStock.setBackground(new Color(0,204,102));
        tomatoStock.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        //DAY COUNT DISPLAY
        JTextField daycount = new JTextField("Day " + day);
        daycount.setEditable(false);
        daycount.setFont(new Font("Verdana",1,26)); //sets fonts
        contentPanel.add(daycount);
        daycount.setBounds(10,0,110,50);
        daycount.setBackground(new Color(0,204,102));
        daycount.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        //CASH ON TOP RIGHT
        JTextField money = new JTextField("$"+ cash);
        money.setFont(new Font("Verdana",1,26)); //sets fonts
        money.setEditable(false);
        contentPanel.add(money);
        money.setBounds(510,0,300,50);
        money.setBackground(new Color(0,204,102));
        money.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        //CLOSE DOEST WORK
        JButton close = new JButton("CLOSE"); //makes button
        close.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            }); //button becomes source of ActionEvent
        contentPanel.add(close); //adds playbutton to frame
        close.setBounds(250,500,100,40); //positions button in frame
    }

}
