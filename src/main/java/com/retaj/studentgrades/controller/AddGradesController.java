package com.retaj.studentgrades.controller;

import com.retaj.studentgrades.util.SceneSwitcher;
import com.retaj.studentgrades.util.StudentFileManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddGradesController {
    @FXML private TextField idField;
    @FXML private TextField gradeField;
    @FXML private Label messageLabel;

    @FXML
    private void saveGrade() {
        try {
            double grade = Double.parseDouble(gradeField.getText());
            if (grade < 0 || grade > 100) {
                messageLabel.setText("Grade must be between 0 and 100");
                return;
            }

            boolean updated = StudentFileManager.updateGrade(idField.getText(), grade);
            if (updated) {
                messageLabel.setText("Grade saved successfully");
                idField.clear();
                gradeField.clear();
            } else {
                messageLabel.setText("Student ID not found");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Enter a valid grade number");
        }
    }

    @FXML private void back() throws Exception { SceneSwitcher.switchTo("Dashboard.fxml", "Dashboard"); }
}
