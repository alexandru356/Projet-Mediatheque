package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Adherent;

public class AjouterAdherent {
	
	
	@FXML
	TextField tfNom;
	
	@FXML
	TextField tfPrenom;
	
	@FXML
	TextField tfAdresse;
	
	@FXML
	TextField tfNumTel;
	
	@FXML
	Button btnConfirmer;
	
	@FXML
	Button btnAnnuler;
	
	int numInscription = 20001;
	
	@FXML
	public void confirmerAjout() {
		String numInscription = "A" + this.numInscription;
		String nom = tfNom.getText();
		String prenom = tfPrenom.getText();
		String adresse = tfAdresse.getText();
		String numTel = tfNumTel.getText();
		
		Adherent adherent = new Adherent(numInscription,numTel, nom, prenom, adresse);
		this.numInscription++;
		CatalogueLoggedController.addAdherentToTable(adherent);
		
		
		
		tfNom.clear();
		tfPrenom.clear();
		tfAdresse.clear();
		tfNumTel.clear();
		Stage stage = (Stage) btnConfirmer.getScene().getWindow();
		stage.close();
	}
}
