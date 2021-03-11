package com.github;

import java.io.IOException;

import com.github.db.ConexioJDBC;
import com.github.db.ConexioMongo;
import com.github.exceptions.DatabaseException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Kevin Fernandez
 */
public class ConnectionViewController {

    @FXML
    private RadioButton radioSQL;
    @FXML
    private RadioButton radioNoSQL;
    @FXML
    private TextField txtHost;
    @FXML
    private TextField txtPort;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Label labelError;

    private final ToggleGroup group = new ToggleGroup();
    private String selectedBBDD = "";

    public void initialize() {

        radioSQL.setToggleGroup(group);
        radioNoSQL.setToggleGroup(group);

        txtHost.setText("Host");
        txtPort.setText("Port");
        txtUser.setText("User");
        txtPass.setText("Password");

        //group.selectedToggleProperty().addListener((observable, oldVal, newVal) -> txtHost.setText(newVal.toString() + " was selected"));
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
                RadioButton chk = (RadioButton) radioSQL.getToggleGroup().getSelectedToggle(); // Cast object to radio button
                System.out.println("Selected - " + chk.getText());
                selectedBBDD = chk.getText();
            }
        });
        
        btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {

                switch (selectedBBDD) {
                    case "BBDD SQL":
                        try {
                            labelError.setTextFill(Color.GREEN);
                            labelError.setText("Connecting...");
                            ConexioJDBC.connect();
                            clientListWindow();
                        } catch (DatabaseException e) {
                            labelError.setTextFill(Color.RED);
                            labelError.setText("Error: Cannot connect to BBDD");
                        }

                        break;
                    case "BBDD NO-SQL":

                        try {
                            labelError.setTextFill(Color.GREEN);
                            labelError.setText("Connecting...");
                            ConexioMongo.connect();
                            clientListWindow();
                        } catch (DatabaseException e) {
                            labelError.setTextFill(Color.RED);
                            labelError.setText("Error: Cannot connect to BBDD");
                        }

                        break;
                    case "":
                        labelError.setTextFill(Color.RED);
                        labelError.setText("Error: No BBDD type SELECTED");
                }
            }
        });
    }

    private void clientListWindow() {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ClientListView" + ".fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 535, 656);
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setTitle("Clients List");
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
