package com.github;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Kevin Fernandez
 */
public class CreateGameViewController {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnAdd;
    @FXML
    private void clickBtnAdd() {

    }
    @FXML
    private void clickBtnBack() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ClientListView" + ".fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 535, 615);
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
