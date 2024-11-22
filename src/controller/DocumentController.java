package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DVD;
import model.Document;
import model.Livre;
import model.Periodique;
import utils.DVDReader;
import utils.LivreReader;
import utils.PeriodiqueReader;

public class DocumentController {

	@FXML
	private TableView<Document> tableViewDocs;
	
	@FXML
	private TableColumn<Document, String> colNumDoc;
	
	@FXML
	private TableColumn<Document, String> colTitre;
	
	@FXML
	private TableColumn<Document, String> colAuteur;
	
	@FXML
	private TableColumn<Document, String> colDate;
	
	@FXML
	private TableColumn<Document, String> colEtat;
	
	@FXML
	private TableColumn<Document, Integer> colNbPret;
	
	@FXML
	private TableColumn<Document, String> colEmprunteur;
	
	private ObservableList<Document> lstObsDoc = FXCollections.observableArrayList();
	
	public DocumentController () {
		
	}
	
	
	@FXML
	public void initialize() {
		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		//colEmprunteur.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		ObservableList<DVD> listeDVDs = FXCollections.observableArrayList(DVDReader.chargerFichier("DVD.txt"));
	    ObservableList<Livre> listeLivres = FXCollections.observableArrayList(LivreReader.chargerFichier("Livres.txt"));
	    ObservableList<Periodique> listePeriodiques = FXCollections.observableArrayList(PeriodiqueReader.chargerFichier("Periodiques.txt"));
	    lstObsDoc.addAll(listeDVDs);
	    lstObsDoc.addAll(listeLivres);
	    lstObsDoc.addAll(listePeriodiques);
	    
	    tableViewDocs.setItems(lstObsDoc);
	}
}
