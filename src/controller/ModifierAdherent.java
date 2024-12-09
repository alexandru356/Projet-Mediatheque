package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Adherent;
import utils.GestionSerialisation;

public class ModifierAdherent {

	//changer les proprietees d'un adherent
	
	@FXML
	TextField tfAdresse;

	@FXML
	TextField tfnumTel;

	@FXML
	Button btnConfirmer;

	@FXML
	Button btnAnnuler;

	private Adherent selectedAdherent;

	public void setAdherent(Adherent adherent) {
		this.selectedAdherent = adherent;


		tfAdresse.setText(adherent.getAdresse());
		tfnumTel.setText(adherent.getNumTelephone());
	}
	@FXML
	public void btnConfirmer() {

		selectedAdherent.setAdresse(tfAdresse.getText());
		selectedAdherent.setNumTelephone(tfnumTel.getText());

		GestionSerialisation.serealiserAdherent(utils.GestionnaireDonnee.adherentList);

		tfAdresse.clear();
		tfnumTel.clear();

		Stage stage = (Stage) btnConfirmer.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void btnAnnuler() {

		Stage stage = (Stage) tfAdresse.getScene().getWindow();
		stage.close();
	}
}
