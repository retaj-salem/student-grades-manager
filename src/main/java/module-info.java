module com.retaj.studentgrades {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.retaj.studentgrades to javafx.fxml;
    opens com.retaj.studentgrades.controller to javafx.fxml;
    opens com.retaj.studentgrades.model to javafx.base;
    exports com.retaj.studentgrades;
    exports com.retaj.studentgrades.model;
}
