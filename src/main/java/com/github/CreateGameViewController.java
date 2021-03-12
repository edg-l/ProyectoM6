package com.github;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

/**
 * @author Kevin Fernandez
 */
public class CreateGameViewController {

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
    private ChoiceBox choicePlatform;

    public void initialize() {

        choicePlatform.getItems().add(Platform.PC);
        choicePlatform.getItems().add(Platform.PS3);
        choicePlatform.getItems().add(Platform.PS4);
        choicePlatform.getItems().add(Platform.PS5);
        choicePlatform.getItems().add(Platform.Xbox);
        choicePlatform.getItems().add(Platform.XboxSeriesX);
        choicePlatform.getItems().add(Platform.Switch);

    }

    @FXML
    private void clickBtnAdd() {

        String name = txtNom.getText();
        int id = Integer.parseInt(txtId.getText());
        Platform platform;
        switch ((String) choicePlatform.getValue()) {
            case "PC":
                platform = Platform.PC;
            case "PS3":
                platform = Platform.PS3;
            case "PS4":
                platform = Platform.PS4;
            case "PS5":
                platform = Platform.PS5;
            case "Xbox":
                platform = Platform.Xbox;
            case "XboxSeriesX":
                platform = Platform.XboxSeriesX;
            case "Switch":
                platform = Platform.Switch;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + (String) choicePlatform.getValue());
        }
        java.sql.Date date = java.sql.Date.valueOf(releaseDate.getValue());
        int preu = Integer.parseInt(txtPreu.getText());

        Videogame newVideoGame = new Videogame(id,name,platform,date,preu);

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
