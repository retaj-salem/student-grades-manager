package com.retaj.studentgrades.controller;

import com.retaj.studentgrades.model.Student;
import com.retaj.studentgrades.util.FileManager;
import com.retaj.studentgrades.util.SceneManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewStudentsController {
    @FXML private TableView<Student> tableView;
    @FXML private TableColumn<Student, String> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, String> majorColumn;
    @FXML private TableColumn<Student, Double> gradeColumn;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tableView.setItems(FXCollections.observableArrayList(FileManager.readStudents()));
    }

    @FXML private void refresh() { tableView.setItems(FXCollections.observableArrayList(FileManager.readStudents())); }
    @FXML private void back() { SceneManager.switchScene("dashboard.fxml", "Dashboard"); }
}
