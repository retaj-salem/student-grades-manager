package com.retaj.studentgrades.controller;

import com.retaj.studentgrades.model.Student;
import com.retaj.studentgrades.util.FileManager;
import com.retaj.studentgrades.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddStudentController {
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField majorField;
    @FXML private Label messageLabel;

    @FXML
    private void saveStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String major = majorField.getText();

        if (id.isEmpty() || name.isEmpty() || major.isEmpty()) {
            messageLabel.setText("Please fill all fields");
            return;
        }
        if (FileManager.findStudentById(id) != null) {
            messageLabel.setText("Student ID already exists");
            return;
        }

        FileManager.addStudent(new Student(id, name, major, 0));
        messageLabel.setText("Student added successfully");
        idField.clear(); nameField.clear(); majorField.clear();
    }

    @FXML private void back() { SceneManager.switchScene("dashboard.fxml", "Dashboard"); }
}
