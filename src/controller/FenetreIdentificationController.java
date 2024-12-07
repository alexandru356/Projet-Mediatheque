package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.ValidationIdentification;

public class FenetreIdentificationController {

	@FXML
	private RadioButton rdIdentificationNom;

	@FXML
	private RadioButton rdIdentificationTelephone;

	@FXML
	private Button btnConnexion;

	@FXML
	private Button btnConsulter;

	@FXML
	private TextField tfNom;

	@FXML
	private TextField tfPrenom;

	@FXML
	private TextField tfTelephone;

	@FXML
	private Button btnCatalogue;

	@FXML
	private TextField tfNumEmploye;

	@FXML
	private TextField tfMDP;
	
	@FXML
	private Text txtNom;
	
	@FXML
	private Text txtPrenom;
	
	@FXML
	private Text txtTelephone;
	

	@FXML
	private TitledPane tpAdherent;

	public FenetreIdentificationController() {

	}

	@FXML
	public void initialize() {
		
		
		ToggleGroup group = new ToggleGroup();
		rdIdentificationNom.setToggleGroup(group);
		rdIdentificationTelephone.setToggleGroup(group);
		rdIdentificationNom.setSelected(true);
		
		// platform run later assure que le titled pane expands 
		//apres que le layout a ete initializer au complet
		Platform.runLater(() -> {
			if (tpAdherent != null) {
				tpAdherent.setExpanded(true);
			}
		});
	}
	
	@FXML
	public void typeIdentification() {
		if (rdIdentificationNom.isSelected()) {
			tfNom.setVisible(true);
			tfPrenom.setVisible(true);
			txtNom.setVisible(true);
			txtPrenom.setVisible(true);
			tfTelephone.setVisible(false);
			txtTelephone.setVisible(false);
		} else {
			tfNom.setVisible(false);
			tfPrenom.setVisible(false);
			txtNom.setVisible(false);
			txtPrenom.setVisible(false);
			txtTelephone.setVisible(true);
			tfTelephone.setVisible(true);
		}
	}
	public void OuvrirCatalogue() {
		try {
			Stage currentStage = (Stage) btnCatalogue.getScene().getWindow();
			currentStage.close();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Médiathèque");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void connexionAdmin() throws FileNotFoundException, IOException {
		String identifiant = tfNumEmploye.getText();
		String motDePasse = tfMDP.getText();

		boolean identifantsValide = ValidationIdentification.verifierId(identifiant, motDePasse);
		boolean idValideEmp = GestionPreposeController.connexionEmp(identifiant, motDePasse);

		if (identifantsValide) {
			ouvrirVueAdmin();
			tfNumEmploye.clear();
			tfMDP.clear();
		} else {
			System.err.println("Identifiants invalide");
		}
		if(idValideEmp) {
			ouvrirVueEmploye();
            tfNumEmploye.clear();
            tfMDP.clear();
		} else {
			System.err.println("Identifiants employé invalide");
		}
	}

	public void ouvrirVueAdmin() {

		try {
			Stage currentStage = (Stage) btnCatalogue.getScene().getWindow();
			currentStage.close();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VueAdmin.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Médiathèque Admin");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void ouvrirVueEmploye() {
		try {
			Stage currentStage = (Stage) btnCatalogue.getScene().getWindow();
			currentStage.close();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainViewEmploye.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Menu préposé");
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
