package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Adherent;
import model.Document;
import model.Livre;
import model.Pret;
import utils.GestionnaireDonnee;

public class PretController {


	@FXML
	private TableView<Adherent> TableView;

	@FXML
	private TableColumn<Adherent, String> tcNum;

	@FXML
	private TableColumn<Adherent, String> tcNom;

	@FXML
	private TableColumn<Adherent, String> tcPrenom;

	@FXML
	private TableColumn<Adherent, String> tcAdresse;

	@FXML
	private TableColumn<Adherent, String> tcTel;

	private ObservableList<Adherent> adherentList;


	private Document documentSelect; 


	public void setDocumentSelect(Document document) {
		this.documentSelect = document;
	}



	@FXML
	private void initialize() {
		adherentList = GestionnaireDonnee.adherentList; 

		tcNum.setCellValueFactory(cellData -> cellData.getValue().numInscriptionProperty());
		tcNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		tcPrenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		tcAdresse.setCellValueFactory(cellData -> cellData.getValue().adresseProperty());
		tcTel.setCellValueFactory(cellData -> cellData.getValue().numTelephoneProperty());
		TableView.setItems(adherentList);
	}

	@FXML
	private void btnConfirmer() {
		 Adherent selectedAdherent = TableView.getSelectionModel().getSelectedItem();
		if (selectedAdherent != null) {
			selectedAdherent.setPretsActifs(selectedAdherent.getPretsActifs() + 1);
            documentSelect.setNomEmprunteur(selectedAdherent.getNom() + " " + selectedAdherent.getPrenom());
            

            Stage stage = (Stage) TableView.getScene().getWindow();
            stage.close();
        } else {
      
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Sélectionner un document et un adhérent");
            alert.setContentText("Veuillez sélectionner un document et un adhérent.");
            alert.showAndWait();
        }
	}
}
