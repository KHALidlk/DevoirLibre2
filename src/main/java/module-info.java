module com.application.controle2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;

    // Export the controllers package to javafx.fxml
    exports com.application.controle2.Controller to javafx.fxml;

    // Export the models package to Jackson
    exports com.application.controle2.model to com.fasterxml.jackson.databind;

    // Open the models package to Jackson for reflective access
    opens com.application.controle2.model to com.fasterxml.jackson.databind;

    // Open the controllers package to javafx.fxml
    opens com.application.controle2.Controller to javafx.fxml;

    // Export your main package if required by other modules
    exports com.application.controle2;
}
