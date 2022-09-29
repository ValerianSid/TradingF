/**
 *
 */
module myapplication{
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires javafx.base;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;


    opens myapplication to javafx.fxml;
    exports myapplication;
}
