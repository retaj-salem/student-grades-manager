package com.retaj.studentgrades.controller;

import com.retaj.studentgrades.util.SceneManager;
import javafx.fxml.FXML;

public class DashboardController {
    @FXML private void openAddStudent() { SceneManager.switchScene("add-student.fxml", "Add Student"); }
    @FXML private void openAddGrade() { SceneManager.switchScene("add-grade.fxml", "Add Grades"); }
    @FXML private void openViewStudents() { SceneManager.switchScene("view-students.fxml", "View Students"); }
    @FXML private void openReports() { SceneManager.switchScene("reports.fxml", "View Reports"); }
    @FXML private void logout() { SceneManager.switchScene("login.fxml", "Login Screen"); }
}
