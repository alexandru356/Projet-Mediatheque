package controller;

import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

	public static int counter = 2001;
	
	
	public void annuler() {
		Stage stage = (Stage) btnAnnuler.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void confirmerAjout() {
		//a enelever
		Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
		while(true) {
			String numEmp = "P" + counter++;
			String nom = tfNom.getText().trim();
			String prenom = tfPrenom.getText().trim();
			String adresse = tfAdresse.getText().trim();
			String numTel = tfTelephone.getText().trim();
			String passwd = tfMDP.getText().trim();
			boolean numTelValid = pattern.matcher(numTel).matches();
			boolean toutRempli = !nom.isEmpty() && !prenom.isEmpty() && !adresse.isEmpty() && !numTel.isEmpty()
					&& !passwd.isEmpty();


			if(numTelValid && toutRempli) {

				Prepose p = new Prepose(numEmp,nom,prenom,adresse,numTel,passwd);
				GestionPreposeController.addPreposeToTable(p);

				tfNom.clear();
				tfPrenom.clear();
				tfAdresse.clear();
				tfTelephone.clear();
				tfMDP.clear();
				Stage stage = (Stage) btnConfirmer.getScene().getWindow();
				stage.close();
				break;
			} else {
				if (nom.isEmpty()) {
					showAlert("Vous n'avez pas rempli votre nom.");
					break;
				} else if (prenom.isEmpty()) {
					showAlert("Vous n'avez pas rempli votre prénom.");
					break;
				} else if (adresse.isEmpty()) {
					showAlert("Voys n'avez pas rempli votre adresse.");
					break;
				} else if (numTel.isEmpty()) {
					showAlert("Vous n'avez pas rempli votre numéro de téléphone");
					break;
				} else if (passwd.isEmpty()) {
					showAlert("Vous n'avez pas rempli votre mot de passe.");
					break;
				} else {
					showAlert("Le numéro de téléphone doit être sous le format (xxx) xxx-xxxx");
					break;
				}
			}
		}
	}
	
	
	private void showAlert(String message) {
	    Alert alert = new Alert(AlertType.WARNING);
	    alert.setTitle("Error");
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	}

}
