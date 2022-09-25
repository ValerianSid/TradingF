package myapplication;

import data.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.CurrencyPair;

import java.util.List;

public class MyViewController {
    private final DataSource dataSource;


    public MyViewController(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @FXML
    private Label labelText;
private TextField  textField;
    @FXML
    protected void currencyById(ActionEvent actionEvent) {

        List<CurrencyPair> currencyPairs = dataSource.getPairById(Integer.valueOf(String.valueOf(textField)));
        labelText.setText(String.valueOf(currencyPairs));
    }
}
