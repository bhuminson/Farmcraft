public class Main {

    public static GUIMode gui = new TextMode();

	public static void main(String[] args) {
        gui.setup();
        gui.gameLoop();
	}
}