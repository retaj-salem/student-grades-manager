package com.retaj.studentgrades.controller;

import com.retaj.studentgrades.model.Student;
import com.retaj.studentgrades.util.FileManager;
import com.retaj.studentgrades.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class ReportsController {
    @FXML private Label totalLabel;
    @FXML private Label averageLabel;
    @FXML private Label highestLabel;

    @FXML
    private void initialize() {
        List<Student> students = FileManager.readStudents();
        totalLabel.setText("Total Students: " + students.size());

        if (students.isEmpty()) {
            averageLabel.setText("Average Grade: 0");
            highestLabel.setText("Highest Grade: 0");
            return;
        }

        double sum = 0;
        double highest = students.get(0).getGrade();
        for (Student student : students) {
            sum += student.getGrade();
            if (student.getGrade() > highest) highest = student.getGrade();
        }
        averageLabel.setText(String.format("Average Grade: %.2f", sum / students.size()));
        highestLabel.setText("Highest Grade: " + highest);
    }

    @FXML private void back() { SceneManager.switchScene("dashboard.fxml", "Dashboard"); }
}
