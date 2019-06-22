import java.awt.Color;
import javax.swing.JFrame;

/*
 * This class represents the virtual world.
 */

public final class Simulation extends Canvas implements Runnable	{

	private static Window window;
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 800;

	public static void run()	{
		window = new Window(WIDTH, HEIGHT, "Farmer Inc.");
		setup();
	}

	public static void setup()	{
		window.setBackground(Color.GREEN);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes X button close the window and stop program
        window.setLocationRelativeTo(null);//makes window appear in middle of screen
        window.add(this, BorderLayout.CENTER);
        window.setVisible(true); 
	}

}
