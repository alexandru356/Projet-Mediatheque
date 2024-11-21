package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class CatalogueController {

	@FXML
	private RadioButton rdAuteur;
	
	@FXML
	private RadioButton rdMotCle;
	
	@FXML
	private Button btnQuitter;
	
	@FXML
	private Button btnEffacer;
	
	@FXML
	private TextField tfRecherche;
	
	public void Quitter () {
		Platform.exit();
	}
	
	public void Effacer () {
		tfRecherche.clear();
	}
	
	public CatalogueController () {
		
	}
	
	
	@FXML
	public void initialize () {
		
	}
}
