module com.github {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens com.github to javafx.fxml;
    exports com.github;
}