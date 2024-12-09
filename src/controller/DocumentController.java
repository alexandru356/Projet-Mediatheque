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
import utils.GestionnaireDonnee;
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

	public Document getSelectedDocument() {
		return tableViewDocs.getSelectionModel().getSelectedItem();
	}


	public void ajouterDocument(Document document) {
		GestionnaireDonnee.documentList.add(document);
		tableViewDocs.refresh(); 
	}

	public ObservableList<Document> getObservableList() {
		return lstObsDoc;
	}
	public TableView<Document> getTableView() {
		return tableViewDocs;
	}

	@FXML
	public void initialize() {

		
		lstObsDoc = GestionnaireDonnee.documentList;
		tableViewDocs.setItems(lstObsDoc);

		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colAuteur.setCellValueFactory(donnee -> {
			Document doc = donnee.getValue();
			if (doc instanceof Livre) {
				return ((Livre) doc).auteurProperty();
			} else if (doc instanceof DVD) {
				return ((DVD) doc).realisateurProperty();
			}
			return null;
		});
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		colEmprunteur.setCellValueFactory(donnee -> donnee.getValue().nomEmprunteurProperty());
	}
	public void filtrerDocuments(String texte, String filtreActif) {
		ObservableList<Document> documentsFiltres = FXCollections.observableArrayList();

		for (Document doc : GestionnaireDonnee.documentList) {
			if (filtreActif.equals("titre") && doc.getTitre().toLowerCase().contains(texte.toLowerCase())) {
				documentsFiltres.add(doc);
			} else if (filtreActif.equals("auteur")) {
				if (doc instanceof Livre && ((Livre) doc).getAuteur().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(doc);
				} else if (doc instanceof Periodique && ((Periodique) doc).getAuteur().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(doc);
				} else if (doc instanceof DVD && ((DVD) doc).getRealisateur().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(doc);
				}
			} else if (filtreActif.equals("motCle")) {
				if (doc instanceof Livre && ((Livre) doc).getMotsCles().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(doc);
				} else if (doc instanceof Periodique && ((Periodique) doc).getMotsCles().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(doc);
				} else if (doc instanceof DVD && ((DVD) doc).getMotsCles().toLowerCase().contains(texte.toLowerCase())) {
					documentsFiltres.add(doc);
				}
			}
		}

		tableViewDocs.setItems(documentsFiltres);
	}


	public void supprimerDocument(Document selectedDocument) {
		
		GestionnaireDonnee.documentList.remove(selectedDocument);
		tableViewDocs.getItems().remove(selectedDocument);
        tableViewDocs.refresh();
    }
		
	
}
