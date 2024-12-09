package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Prepose;
import utils.GestionSerialisation;
import utils.GestionnaireDonnee;

public class GestionPreposeController {


	@FXML
	Button btnAjout;
	@FXML
	Button btnSupp;
	@FXML
	Button btnDeconnexion;
	@FXML
	TableView<Prepose> tableViewPrepose;
	@FXML
	TableColumn<Prepose,String> tcNumEmp;
	@FXML
	TableColumn<Prepose, String> tcNom;
	@FXML
	TableColumn<Prepose, String> tcPrenom;
	@FXML
	TableColumn<Prepose, String> tcAdresse;
	@FXML
	TableColumn<Prepose, String> tcTelephone;

	ObservableList<Prepose> preposeList = FXCollections.observableArrayList();

	@FXML
	public void initialize() {

		preposeList = GestionnaireDonnee.preposeList;

		tcNumEmp.setCellValueFactory(donnee -> donnee.getValue().numEmpProperty());
		tcNom.setCellValueFactory(donnee -> donnee.getValue().nomProperty());
		tcPrenom.setCellValueFactory(donnee -> donnee.getValue().prenomProperty());
		tcAdresse.setCellValueFactory(donnee -> donnee.getValue().adresseProperty());
		tcTelephone.setCellValueFactory(donnee -> donnee.getValue().numTelephoneProperty());
		tableViewPrepose.setItems(preposeList);
	}

	public static void addPreposeToTable(Prepose prepose) {

		GestionnaireDonnee.preposeList.add(prepose);
		GestionSerialisation.serialiserPrepose(GestionnaireDonnee.preposeList);
	}

	public void supprimerPrepose() {
		Prepose selectedPrepose = tableViewPrepose.getSelectionModel().getSelectedItem();

		if (selectedPrepose != null) {
			preposeList.remove(selectedPrepose);
			GestionSerialisation.serialiserPrepose(preposeList);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Avertissement");
			alert.setHeaderText("Aucun préposé sélectionné");
			alert.setContentText("Veuillez sélectionner un préposé à supprimer.");
			alert.showAndWait();
		}
	}
	public void ajoutPrepose() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AjoutPrepose.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ajouter  un préposé");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static boolean connexionEmp(String id, String mdp) {
		System.out.println("Prepose List: " + GestionnaireDonnee.preposeList);
		for(Prepose p : GestionnaireDonnee.preposeList) {
			if (p.getNumEmp().equals(id) && p.getPasswd().equals(mdp)) {
				return true;
			}
		}
		return false;
	}

	public void deconnexion() {
		try {
			Stage currentStage = (Stage) btnDeconnexion.getScene().getWindow();
			currentStage.close();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vueIdentification.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Médiathèque Employe");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}


	}
}
