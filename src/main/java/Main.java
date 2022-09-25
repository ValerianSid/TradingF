import exсeption.NoEnoughMoneyException;
import manager.ForexApp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NoEnoughMoneyException, IOException {
        ForexApp forexApp = new ForexApp();
        forexApp.run();
    }
}
