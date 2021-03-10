package com.github;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
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
	private void clickRadioSQL() {

	}
	@FXML
	private void clickRadioNoSQL() {

	}
	@FXML
	private void clickBtnLogin() {
		
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ClientListView" + ".fxml"));
		Scene scene;
		try {
			scene = new Scene(fxmlLoader.load(), 535, 656);
			Stage stage = (Stage) btnLogin.getScene().getWindow();
			stage.setResizable(false);
			stage.setScene(scene);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
