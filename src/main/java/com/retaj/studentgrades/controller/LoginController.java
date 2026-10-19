package com.retaj.studentgrades.controller;

import com.retaj.studentgrades.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    private void login() {
        if (usernameField.getText().equals("admin") && passwordField.getText().equals("1234")) {
            SceneManager.switchScene("dashboard.fxml", "Dashboard");
        } else {
            messageLabel.setText("Wrong username or password");
        }
    }
}
