package com.example.barfx.controllers;

import com.example.barfx.models.Monitor;
import com.example.barfx.threads.Client;
import com.example.barfx.threads.Receptionist;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    private Rectangle firstBartender;

    @FXML
    private Rectangle receptionist;

    @FXML
    private Rectangle secondBartender;

    @FXML
    void endSimulation(MouseEvent event) {

    }

    @FXML
    void startSimulation(MouseEvent event) {
        System.out.println("Hola");
        Monitor monitor = new Monitor();
        Receptionist receptionist1 = new Receptionist(monitor, receptionist);
        receptionist1.run();
    }
}