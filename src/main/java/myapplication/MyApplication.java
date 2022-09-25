package myapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader= new FXMLLoader(MyApplication.class.getResource("myView.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),500,500 );
        stage.setTitle("* My TradingF * ver. 1.0.0");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

