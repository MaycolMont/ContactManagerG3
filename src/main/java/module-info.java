module com.group3.contactmanagerg3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.group3.contactmanagerg3 to javafx.fxml;
    opens com.group3.controller to javafx.fxml;
    
    exports com.group3.contactmanagerg3;
    exports com.group3.controller;
}
