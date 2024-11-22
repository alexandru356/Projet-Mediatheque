package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import model.Document;

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
	
	//Nodes pour l'identification :
	
	@FXML
	private RadioButton rdIdentificationNom;
	
	@FXML
	private RadioButton rdIdentificationTelephone;
	
	@FXML
	private Button btnConsulter;
	
	@FXML
	private TextField tfNom;
	
	@FXML
	private TextField tfPrenom;
	
	@FXML
	private TextField tfTelephone;
	
	@FXML
	private Text txtNom;
	
	@FXML
	private Text txtPrenom;
	
	@FXML
	private Text txtTelephone;
	
	public void Quitter () {
		Platform.exit();
	}
	
	public void Effacer () {
		tfRecherche.clear();
	}
	
	public void TypeIdentigication () {
		if (rdIdentificationTelephone.isSelected()) {
			tfNom.setVisible(false);
			tfPrenom.setVisible(false);
			tfTelephone.setVisible(true);
			txtTelephone.setVisible(true);
			txtNom.setVisible(false);
			txtPrenom.setVisible(false);
		}else {
			tfNom.setVisible(true);
			tfPrenom.setVisible(true);
			tfTelephone.setVisible(false);
			txtTelephone.setVisible(false);
			txtNom.setVisible(true);
			txtPrenom.setVisible(true);
		}
	}
	
	public CatalogueController () {
		
	}
	
	
	@FXML
	public void initialize () {
		
		ToggleGroup group1 = new ToggleGroup();
		rdAuteur.setToggleGroup(group1);
		rdMotCle.setToggleGroup(group1);
		
		rdAuteur.setSelected(true);
		
		//Pour choisir la methode d'identification
		
		ToggleGroup groupIdentification = new ToggleGroup();
		rdIdentificationNom.setToggleGroup(groupIdentification);
		rdIdentificationTelephone.setToggleGroup(groupIdentification);
		
		rdIdentificationNom.setSelected(true);
	}
}
