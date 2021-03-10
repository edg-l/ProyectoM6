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
    private ImageView btnClientAdd;
    @FXML
    private TableView<Client> tableClient;
    
    @FXML
    private void clickBtnSearch() {

    }

    @FXML
    private void clickBtnClientAdd() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateClientView" + ".fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 656);
            Stage stage = (Stage) btnClientAdd.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
