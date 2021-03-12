package com.github;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Date;

/**
 * @author Kevin Fernandez
 */
public class CreateGameViewController {
    private static final Logger LOGGER = Logger.getLogger(CreateGameViewController.class);

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtId;
    @FXML
    private DatePicker releaseDate;
    @FXML
    private TextField txtPreu;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnAdd;
    @FXML
    private ChoiceBox<Platform> choicePlatform;

    public void initialize() {
        for(Platform platform: Platform.values()) {
            choicePlatform.getItems().add(platform);
        }
    }

    @FXML
    private void clickBtnAdd() {

        String name = txtNom.getText();
        int id = Integer.parseInt(txtId.getText());
        Platform platform = Platform.PC;

        for (Platform platform1 : Platform.values()) {
            if (platform1.toString().equals(choicePlatform.getValue())) {
                platform = platform1;
            }
        }

        java.sql.Date date = java.sql.Date.valueOf(releaseDate.getValue());
        int preu = Integer.parseInt(txtPreu.getText());

        Videogame newVideoGame = new Videogame(id, name, platform, date, preu);

    }

    @FXML
    private void clickBtnBack() {
        ClientListViewController.stageCreate.close();
        ClientListViewController.stageCreate = null;
        // SOLO CLOSE
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ClientListView" + ".fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 535, 615);
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }*/
    }

}
