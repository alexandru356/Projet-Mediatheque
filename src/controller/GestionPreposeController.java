package controller;

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

	static ObservableList<Prepose> preposeList = FXCollections.observableArrayList();


	@FXML
	public void initialize() {
		tcNumEmp.setCellValueFactory(donnee -> donnee.getValue().numEmpProperty());
		tcNom.setCellValueFactory(donnee -> donnee.getValue().nomProperty());
		tcPrenom.setCellValueFactory(donnee -> donnee.getValue().prenomProperty());
		tcAdresse.setCellValueFactory(donnee -> donnee.getValue().adresseProperty());
		tcTelephone.setCellValueFactory(donnee -> donnee.getValue().numTelephoneProperty());
		tableViewPrepose.setItems(preposeList);
	}

	public static void addPreposeToTable(Prepose prepose) {

		preposeList.add(prepose);
	}

	public void supprimerPrepose() {
		Prepose selectedPrepose = tableViewPrepose.getSelectionModel().getSelectedItem();

		if (selectedPrepose != null) {

			preposeList.remove(selectedPrepose);
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
	
	public void deconnexion() {
		Stage stage = (Stage) btnDeconnexion.getScene().getWindow();
		stage.close();
		
		
	}
}
