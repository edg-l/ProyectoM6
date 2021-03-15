package com.github;

import com.github.exceptions.DatabaseException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Fernandez
 */
public class ModifyClientViewController {

    private static final Logger LOGGER = Logger.getLogger(ModifyClientViewController.class);

    public static Client client;

    @FXML
    TextField txtNomClient;
    @FXML
    TextField txtIDClient;
    @FXML
    RadioButton radioYes;
    @FXML
    RadioButton radioNo;

    @FXML
    private TableView<Videogame> tableClient;
    @FXML
    private TableView<Videogame> tableGame;
    @FXML
    private TableColumn colIDclientgame;
    @FXML
    private TableColumn colNameclientgame;
    @FXML
    private TableColumn colPlatformclientgame;
    @FXML
    private TableColumn colPriceclientgame;

    @FXML
    private TableColumn colID;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colPlatform;
    @FXML
    private TableColumn colPrice;

    private List<Videogame> videogamesClient;
    public ObservableList<Videogame> videogamesClientObservableList;

    private List<Videogame> videogames;
    public ObservableList<Videogame> videogamesObservableList;


    @FXML
    private void clickBtnSaveAndExit() {

    }

    @FXML
    private void clickBtnFind() {

    }

    public void initialize() {
        //test
        ArrayList<Videogame> listgames = new ArrayList<Videogame>();
        Videogame newVi = new Videogame(12,"mario",Platform.PC,new Date(System.nanoTime()),123);
        listgames.add(newVi);
        client.setVideogames(listgames);
        //test
        txtNomClient.setText(client.getName());
        txtIDClient.setText(client.getId() + "");
        if (client.isPartner()) {
            radioYes.setSelected(true);
        } else {
            radioNo.setSelected(true);
        }

        colIDclientgame.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("id"));
        colNameclientgame.setCellValueFactory(new PropertyValueFactory<Videogame, String>("name"));
        colPlatformclientgame.setCellValueFactory(new PropertyValueFactory<Videogame, String>("platform"));
        colPriceclientgame.setCellValueFactory(new PropertyValueFactory<Videogame, Date>("price"));

        colID.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Videogame, String>("name"));
        colPlatform.setCellValueFactory(new PropertyValueFactory<Videogame, String>("platform"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Videogame, Date>("price"));

        refreshTables();

        tableGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1) {
                    if (tableGame.getSelectionModel().getSelectedItem() != null) {
                        Videogame videogameSelected = videogames.get(tableGame.getSelectionModel().getSelectedIndex());
                        LOGGER.error("videogame seleccionado" + videogameSelected.toString());

                        /**falta añadir objeto bbdd*/
                        /** lo haremos con un botón de guardar cambios **/

                        client.getVideogames().add(videogameSelected);

                        refreshTables();
                    }
                }
            }
        });
    }

    public void refreshTables() {

        videogamesClient = client.getVideogames();
        videogamesClientObservableList = FXCollections.observableArrayList(client.getVideogames());
        tableClient.setItems(videogamesClientObservableList);

        try {
            videogames = new ArrayList<>(App.gestorPersistencia.getVideogameDAO().getAll());
            videogamesObservableList = FXCollections.observableArrayList(videogames);
            tableGame.setItems(videogamesObservableList);

        } catch (DatabaseException e) {
            LOGGER.error("error al obtener los videogames");
            LOGGER.error(e);
            LOGGER.error(e.getCause());
            e.printStackTrace();
        }
    }
}
