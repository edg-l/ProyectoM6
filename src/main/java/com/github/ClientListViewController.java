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

    public static Stage stageCreate = null;

    @FXML
    private TableView<Client> tableClient;

    @FXML
    private void clickBtnSearch() {

        if (App.bbddSQL) { // SQL

        } else { // MONGO DB

        }
    }

    @FXML
    private void clickBtnCreateClient() {

        if (stageCreate == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateClientView" + ".fxml"));
            throwNewCreateWindows(fxmlLoader);
        }
    }

    @FXML
    private void clickBtnCreateVideoGame() {

        if (stageCreate == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateGameView" + ".fxml"));
            throwNewCreateWindows(fxmlLoader);
        }
    }

    /** ventana de creación **/
    private void throwNewCreateWindows(FXMLLoader fxmlLoader) {

        try {
            Scene scene = new Scene(fxmlLoader.load(), 414, 305);
            stageCreate = new Stage();
            stageCreate.setResizable(false);
            stageCreate.setScene(scene);
            stageCreate.initStyle(StageStyle.UNDECORATED);
            stageCreate.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
