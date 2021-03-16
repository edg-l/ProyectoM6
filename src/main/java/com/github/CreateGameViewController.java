package com.github;

import com.github.exceptions.DatabaseException;
import com.github.exceptions.DuplicatedException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Label txtError;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtID;
    @FXML
    private DatePicker dateRelease;
    @FXML
    private TextField txtPreu;
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
        int id = Integer.parseInt(txtID.getText());
        Platform platform = Platform.PC;

        for (Platform platform1 : Platform.values()) {
            if (platform1.equals(choicePlatform.getValue())) {
                platform = platform1;
            }
        }

        java.sql.Date date = java.sql.Date.valueOf(dateRelease.getValue());
        int preu = Integer.parseInt(txtPreu.getText());

        Videogame newVideoGame = new Videogame(id, name, platform, date, preu);

        try {
            App.gestorPersistencia.getVideogameDAO().insert(newVideoGame);
            ClientListViewController.stageCreate.close();
            ClientListViewController.stageCreate = null;
        } catch (DuplicatedException e) {
            LOGGER.debug(e);
            txtError.setText("Ya existe un videogame con este ID.");
        } catch (DatabaseException e) {
            txtError.setText("Error interno de la base de datos.");
            LOGGER.error(e);
            LOGGER.error(e.getCause());
        }
    }

    @FXML
    private void clickBtnBack() {
        ClientListViewController.stageCreate.close();
        ClientListViewController.stageCreate = null;
    }

}
