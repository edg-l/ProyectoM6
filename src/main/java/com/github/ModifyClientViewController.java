package com.github;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Kevin Fernandez
 */
public class ModifyClientViewController {
    @FXML
    ImageView btnAddVideoGame;

    @FXML
    private void clickBtnAddVideoGame() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateGameView" + ".fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 791, 615);
            Stage stage = (Stage) btnAddVideoGame.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    @FXML
    private void clickBtnAdd() {

    }
}
