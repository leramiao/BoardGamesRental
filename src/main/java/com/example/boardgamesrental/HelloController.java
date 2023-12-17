package com.example.boardgamesrental;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to login login Application!");
    }
    @FXML
    protected void onHelloButtonClick2() {
        welcomeText.setText("Welcome to login2 login2 Application!");
    }
}