package com.github;

import com.github.exceptions.DatabaseException;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Fernandez
 */
public class ClientListViewController {
    private static final Logger LOGGER = Logger.getLogger(ClientListViewController.class);

    public static Stage stageCreate = null;

    public static int listSize = 0;
    @FXML
    private Button btnRefreshTable;
    @FXML
    private TableView<Client> tableClient;
    @FXML
    private TableColumn colID;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colCountry;
    @FXML
    private TableColumn colCreatedAt;

    public static List<Client> clients;
    public ObservableList<Client> clientObservableList;

    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        colCountry.setCellValueFactory(new PropertyValueFactory<Client, String>("country"));
        colCreatedAt.setCellValueFactory(new PropertyValueFactory<Client, Date>("createdAt"));

        refreshTable();

        tableClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1) {
                    if (tableClient.getSelectionModel().getSelectedItem() != null) {
                        Client clientSelect = clients.get(tableClient.getSelectionModel().getSelectedIndex());
                        LOGGER.error("client seleccionado" + clientSelect.toString());
                        ModifyClientViewController.client = clientSelect;

                        throwNewModifyWindows();

                    }
                }
            }
        });

        /** NO FUNCIONA **/
        clientObservableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                refreshTable();
                LOGGER.error("Actualizando lista clientes");
            }
        });

        btnRefreshTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                refreshTable();
                LOGGER.error("Actualizando lista clientes");
            }
        });
    }
    /** FORMA PARTE DEL INTENTO DE TRIGGER DEL OBSERVABLE **/
    public static void addClient(Client cli) {
        clients.add(cli);
    }

    public void refreshTable() {
        try {
            clients = new ArrayList<>(App.gestorPersistencia.getClientDAO().getAll());
            clientObservableList = FXCollections.observableArrayList(clients);
            tableClient.setItems(clientObservableList);
        } catch (DatabaseException e) {
            LOGGER.error("error al obtener los clientes");
            LOGGER.error(e);
            LOGGER.error(e.getCause());
            e.printStackTrace();
        }
    }

    @FXML
    private void clickBtnSearch() {

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

    /**
     * ventana de creación
     **/
    private void throwNewCreateWindows(FXMLLoader fxmlLoader) {

        try {
            Scene scene = new Scene(fxmlLoader.load(), 414, 320);
            stageCreate = new Stage();
            stageCreate.setResizable(false);
            stageCreate.setScene(scene);
            stageCreate.initStyle(StageStyle.UNDECORATED);
            stageCreate.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    private void throwNewModifyWindows() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ModifyClientView" + ".fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 791, 615);
            Stage stage = (Stage) tableClient.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
