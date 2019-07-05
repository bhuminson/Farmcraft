public final class Main {

    private static final GUIMode gui = new TextMode();

	public static void main(String[] args) {
        gui.setup();
        gui.gameLoop();
	}
}