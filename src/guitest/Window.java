import javax.swing.JFrame;

public class Window extends JFrame	{

	public Window(int width, int height, String name)	{
		super(name);
		setSize(width, height);
		setVisible(true);
		setResizable(false);
	}
}