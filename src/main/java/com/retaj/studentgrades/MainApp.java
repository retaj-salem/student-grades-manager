package com.retaj.studentgrades;

import com.retaj.studentgrades.util.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneManager.setStage(primaryStage);
        SceneManager.switchScene("login.fxml", "Login Screen");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
