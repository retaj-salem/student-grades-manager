package com.retaj.studentgrades.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {
    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void switchTo(String fxmlFile, String title) throws Exception {
        FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource("/com/retaj/studentgrades/view/" + fxmlFile));
        Scene scene = new Scene(loader.load(), 760, 520);
        scene.getStylesheets().add(SceneSwitcher.class.getResource("/com/retaj/studentgrades/style/style.css").toExternalForm());
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
