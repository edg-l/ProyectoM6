module com.github {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mongo.java.driver;

    opens com.github to javafx.fxml;
    exports com.github;
}