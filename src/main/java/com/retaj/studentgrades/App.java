package com.retaj.studentgrades;

import com.retaj.studentgrades.util.SceneSwitcher;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneSwitcher.setStage(primaryStage);
        SceneSwitcher.switchTo("Login.fxml", "Student Grades Manager - Login");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
