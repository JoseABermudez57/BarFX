package com.example.barfx.threads;

import com.example.barfx.models.Monitor;
import javafx.scene.shape.Rectangle;

public class Receptionist implements Runnable{

    private Monitor monitor;
    private Boolean state;
    private Rectangle rectangle;

    public Receptionist (Monitor monitor, Rectangle rectangle){
        this.rectangle = rectangle;
    }
    @Override
    public void run() {
        moveRectangleToClientLine();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        moveRectangleToInitialPosition();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void moveRectangleToClientLine(){
        this.rectangle.setLayoutX(458);
        this.rectangle.setLayoutY(277);
    }

    public void moveRectangleToInitialPosition(){
        this.rectangle.setLayoutX(543);
        this.rectangle.setLayoutY(248);
    }
}
