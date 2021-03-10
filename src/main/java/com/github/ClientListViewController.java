package com.github;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Kevin Fernandez
 */
public class ClientListViewController {

    @FXML
    private Button btnSearch;
    @FXML
    private Button btnCreateClient;
    @FXML
    private Button btnCreateVideoGame;
    @FXML
    private TableView<Client> tableClient;

    @FXML
    private void clickBtnSearch() {

    }

    @FXML
    private void clickBtnCreateClient() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateClientView" + ".fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 414, 305);
            Stage stage = (Stage) btnCreateClient.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    @FXML
    private void clickBtnCreateVideoGame() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateGameView" + ".fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 414, 305);
            Stage stage = (Stage) btnCreateClient.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
