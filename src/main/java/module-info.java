module com.sarah {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sarah to javafx.fxml;
    exports com.sarah;
}
