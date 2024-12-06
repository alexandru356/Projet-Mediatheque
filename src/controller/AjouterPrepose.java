package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Prepose;

public class AjouterPrepose {
	
	@FXML
	TextField tfNom;
	@FXML
	TextField tfPrenom;
	@FXML 
	TextField tfAdresse;
	@FXML
	TextField tfTelephone;
	@FXML
	TextField tfMDP;
	@FXML
	Button btnConfirmer;
	@FXML
	Button btnAnnuler;
	
	static int counter = 2001;

	public void annuler() {
		Stage stage = (Stage) btnAnnuler.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void confirmerAjout() {
		String numEmp = "P" + counter++;
		String nom = tfNom.getText().trim();
		String prenom = tfPrenom.getText().trim();
		String adresse = tfAdresse.getText().trim();
		String numTel = tfTelephone.getText().trim();
		String passwd = tfMDP.getText().trim();
		
		
		if(!nom.isEmpty() && !prenom.isEmpty() && !adresse.isEmpty() && !numTel.isEmpty() && !passwd.isEmpty()) {
			
			Prepose p = new Prepose(numEmp,nom,prenom,adresse,numTel,passwd);
			GestionPreposeController.addPreposeToTable(p);
			
			tfNom.clear();
			tfPrenom.clear();
			tfAdresse.clear();
			tfTelephone.clear();
			tfMDP.clear();
		}	//implement else with warning when time comes
	}
}
