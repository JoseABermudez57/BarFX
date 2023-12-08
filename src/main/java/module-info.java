module com.example.barfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.barfx to javafx.fxml;
    exports com.example.barfx;
    exports com.example.barfx.controllers;
    opens com.example.barfx.controllers to javafx.fxml;
}