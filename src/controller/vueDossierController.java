package controller;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Adherent;
import model.Document;
import model.Pret;

public class vueDossierController {

	//Vue pour le dossier des adherent
	
	@FXML
	private TableView<Document> tvDocInfo;

	@FXML
	private TableColumn<Document, String> tcNumDoc;

	@FXML
	private TableColumn<Document, String> tcTitre;

	@FXML
	private TableColumn<Document, String> tcAuteur;

	@FXML
	private TableColumn<Document, LocalDate> tcDate;

	@FXML
	private TableView<Pret> tvPrets;

	@FXML
	private TableColumn<Document, String> tcNumPret;

	@FXML
	private TableColumn<Pret, LocalDate> tcDatePret;

	@FXML
	private TableColumn<Pret, LocalDate> tcDateRetourPrevu;

	@FXML
	private TableColumn<Pret, Double> tcAmande;

	@FXML
	private Button btnQuitter;

	private ObservableList<Pret> pretsList = FXCollections.observableArrayList();
	private ObservableList<Document> docsList = FXCollections.observableArrayList();


	@FXML
	public void Initialize () {
		tcNumPret.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		tcDatePret.setCellValueFactory(new PropertyValueFactory<>("datePret"));
		tcDateRetourPrevu.setCellValueFactory(new PropertyValueFactory<>("dateRetourPrevu"));
		tcAmande.setCellValueFactory(new PropertyValueFactory<>("amande"));

		// Lier les colonnes de la table des documents
		tcNumDoc.setCellValueFactory(new PropertyValueFactory<>("numDoc"));
		tcTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		tcAuteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
		tcDate.setCellValueFactory(new PropertyValueFactory<>("datePublicationFormatted"));




		tvPrets.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				afficherDetailsDocument(newValue);
			}
		});
	}

	public void quitter () {
		try {
			Stage currentStage = (Stage) btnQuitter.getScene().getWindow();
			currentStage.close();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vueIdentification.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Identification");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	private void afficherDetailsDocument(Pret pretSelectionne) {
		Document docCorrespondant = pretSelectionne.getDocument(); 
		if (docCorrespondant != null) {
			tvDocInfo.setItems(FXCollections.observableArrayList(docCorrespondant)); 
		}
	}
}
