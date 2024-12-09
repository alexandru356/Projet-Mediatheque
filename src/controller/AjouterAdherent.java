package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Adherent;
import utils.ValidationIdentification;

public class AjouterAdherent {

	//classe pour la fenetre d'ajout d'adherent
	
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

	private static int counter = 20001;

	@FXML
	public void confirmerAjout() {

		while(true) {
			String numInscription = "A" + counter++;
			String nom = tfNom.getText();
			String prenom = tfPrenom.getText();
			String adresse = tfAdresse.getText();
			String numTel = tfNumTel.getText();

			boolean toutRempli = !nom.isEmpty() && !prenom.isEmpty() && !adresse.isEmpty() && !numTel.isEmpty();

			if(toutRempli && ValidationIdentification.verifierFomartTelephone(numTel)) {
				
				
				Adherent adherent = new Adherent(numInscription,numTel, nom, prenom, adresse);
				CatalogueLoggedController.addAdherentToTable(adherent);

				tfNom.clear();
				tfPrenom.clear();
				tfAdresse.clear();
				tfNumTel.clear();
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
