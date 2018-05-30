import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Game extends JFrame implements ActionListener
{
    private String propertyName;

    public Game()
    {
    start();
    }
    
    public void start()
    {
        // CREATES THE WINDOW
        setTitle("Farmcraft");//makes window titled Farmcraft
        setSize(600, 600);  //sets size of window 600px by 600px
        setVisible(true); //makes the window pop up on screen
        setResizable(false); //prevents user from resizing window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes X button close the window and stop program
        setLocationRelativeTo(null);//makes window appear in middle of screen

        // MAKES GREEN PANEL CONTENT OF WINDOW
        JPanel contentPanel = new JPanel(null); //makes a JPanel with no layout
        contentPanel.setBackground(new Color(0,204,102)); //makes panel forest green
        setContentPane(contentPanel); //sets content pane of frame to be this Jpanel

        // TEXT ON SCREEN
        JLabel title = new JLabel("FARMCRAFT"); //Makes FARMCRAFT textbox
        title.setFont(new Font("Verdana",1,55)); //sets fonts
        contentPanel.add(title); //adds text to frame
        title.setBounds(110,200,500,100); //positions text in frame

        // PLAY BUTTON
        JButton playButton = new JButton("Play"); //makes button
        playButton.addActionListener(this); //button becomes source of ActionEvent
        contentPanel.add(playButton); //adds playbutton to frame
        playButton.setBounds(250,350,100,40); //positions button in frame
    }

    public void actionPerformed(ActionEvent evt)
    {
        getContentPane().removeAll();
        repaint();

        JLabel title = new JLabel("Name your farm:"); //Makes FARMCRAFT textbox
        title.setFont(new Font("Verdana",1,32)); //sets fonts
        getContentPane().add(title); //adds text to frame
        title.setBounds(150,200,500,100); //positions text in frame

        JTextField namer = new JTextField();
        namer.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    propertyName = namer.getText();
                    setVisible(false);
                    dispose();
                    new Farm(propertyName);
                }
            });

        add(namer); //adds playbutton to frame
        namer.setBounds(250,350,100,40); //positions button in frame
    }

    public String getPropertyName()
    {
        return propertyName;
    }
    // private Thread thread;
    // private boolean running = false;
    // public void start() //entire game is going to run thru this. single thread
    // {
    // thread = new Thread(this);
    // thread.start(); //calls run method
    // running = true;
    // }
}
