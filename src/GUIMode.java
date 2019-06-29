public interface GUIMode  {

    void setup();
    void nextScreen();
    void gameLoop();

    void farmTutorial();
    void invTutorial();
    void mktTutorial();


    void showFarm();
    void showInventory();
    void showMarket();
}