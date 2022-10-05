import exсeption.NoEnoughMoneyException;
import javafx.application.Application;
import manager.ForexApp;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) throws NoEnoughMoneyException, IOException {
        ForexApp forexApp = new ForexApp();
        forexApp.run();
        //Application.launch();
    }
}
