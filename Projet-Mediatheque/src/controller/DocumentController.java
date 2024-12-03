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
		ObservableList<DVD> listeDVDs = FXCollections.observableArrayList(DVDReader.chargerFichier("DVD.txt"));
	    ObservableList<Livre> listeLivres = FXCollections.observableArrayList(LivreReader.chargerFichier("Livres.txt"));
	    ObservableList<Periodique> listePeriodiques = FXCollections.observableArrayList(PeriodiqueReader.chargerFichier("Periodiques.txt"));
	    lstObsDoc.addAll(listeDVDs);
	    lstObsDoc.addAll(listeLivres);
	    lstObsDoc.addAll(listePeriodiques);
	}
	
	@FXML
	public void initialize() {
		tableViewDocs.setItems(lstObsDoc);
		
		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colAuteur.setCellValueFactory(donnee -> {
			Document doc = donnee.getValue();
			
			 if (doc instanceof Livre) {
				 return ((Livre) doc).auteurProperty();
			 }else if(doc instanceof DVD) {
				 return ((DVD) doc).realisateurProperty();
			 }else {
				 return null;
			 }
		});
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		colEmprunteur.setCellValueFactory(donnee -> donnee.getValue().nomEmprunteurProperty());
	}
	
	public void filtrerDocuments(String texte) {
		ObservableList<Document> documentsFiltres = FXCollections.observableArrayList();


		for (Document doc : lstObsDoc) {

			if (doc.getTitre().toLowerCase().contains(texte.toLowerCase())) {
				documentsFiltres.add(doc);
			} else if (doc instanceof DVD) {
				DVD dvd = (DVD) doc;
				if (dvd.getRealisateur().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(dvd);
				}
			} else if (doc instanceof Livre) {
				Livre livre = (Livre) doc;
				if (livre.getAuteur().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(livre);
				}
			} else if (doc instanceof Periodique) {
				Periodique periodique = (Periodique) doc;
				if (periodique.getAuteur().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(periodique);
				}
			}
		}

		tableViewDocs.setItems(documentsFiltres);
	}

}
