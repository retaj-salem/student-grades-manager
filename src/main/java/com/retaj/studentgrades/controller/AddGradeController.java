package com.retaj.studentgrades.controller;

import com.retaj.studentgrades.model.Student;
import com.retaj.studentgrades.util.FileManager;
import com.retaj.studentgrades.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class AddGradeController {
    @FXML private TextField idField;
    @FXML private TextField gradeField;
    @FXML private Label messageLabel;

    @FXML
    private void saveGrade() {
        String id = idField.getText();
        try {
            double grade = Double.parseDouble(gradeField.getText());
            if (grade < 0 || grade > 100) {
                messageLabel.setText("Grade must be between 0 and 100");
                return;
            }

            List<Student> students = FileManager.readStudents();
            boolean found = false;
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    student.setGrade(grade);
                    found = true;
                    break;
                }
            }

            if (found) {
                FileManager.saveAllStudents(students);
                messageLabel.setText("Grade saved successfully");
            } else {
                messageLabel.setText("Student not found");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Enter a valid number");
        }
    }

    @FXML private void back() { SceneManager.switchScene("dashboard.fxml", "Dashboard"); }
}
