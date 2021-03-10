package com.github;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * @author Kevin Fernandez
 */
public class ClientListViewController {

    public static Stage stageClient = null;
    public static Stage stageGame = null;

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

        if (stageClient == null) {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateClientView" + ".fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load(), 414, 305);
                stageClient = new Stage();
                stageClient.setResizable(false);
                stageClient.setScene(scene);
                stageClient.initStyle(StageStyle.UNDECORATED);
                stageClient.show();

            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    @FXML
    private void clickBtnCreateVideoGame() {

        if (stageGame == null) {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateGameView" + ".fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load(), 414, 305);
                stageGame = new Stage();
                stageGame.setResizable(false);
                stageGame.setScene(scene);
                stageGame.initStyle(StageStyle.UNDECORATED);
                stageGame.show();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
