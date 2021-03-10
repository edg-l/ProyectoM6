package com.github;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Kevin Fernandez
 */
public class ConnectionViewController {

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
			scene = new Scene(fxmlLoader.load(), 600, 300);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
