module com.group3.contactmanagerg3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.group3.contactmanagerg3 to javafx.fxml;
    exports com.group3.contactmanagerg3;
}
