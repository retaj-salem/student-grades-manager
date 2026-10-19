package com.retaj.studentgrades.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
        stage.setResizable(false);
    }

    public static void switchScene(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/com/retaj/studentgrades/" + fxmlFile));
            Scene scene = new Scene(loader.load(), 720, 480);
            scene.getStylesheets().add(SceneManager.class.getResource("/com/retaj/studentgrades/style.css").toExternalForm());
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Cannot load " + fxmlFile, e);
        }
    }
}
