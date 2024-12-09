package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Document;
import model.Livre;
import utils.GestionnaireDonnee;
import utils.LivreReader;

public class LivreController {

	@FXML
	private TableView<Livre> tableViewLivres;

	@FXML
	private TableColumn<Livre, String> colNumDoc;

	@FXML
	private TableColumn<Livre, String> colTitre;

	@FXML
	private TableColumn<Livre, String> colAuteur;

	@FXML
	private TableColumn<Livre, String> colDate;

	@FXML
	private TableColumn<Livre, String> colEtat;

	@FXML
	private TableColumn<Livre, Integer> colNbPret;

	@FXML
	private TableColumn<Livre, String> colEmprunteur;

	//private ObservableList<Livre> lstObsLivre = FXCollections.observableArrayList(LivreReader.chargerFichier("Livres.txt"));

	public Livre getSelectedLivre() {
		return tableViewLivres.getSelectionModel().getSelectedItem();
	}
	@FXML
	public void initialize () {

		ObservableList<Livre> livresFiltres = FXCollections.observableArrayList();

		for (Document doc : GestionnaireDonnee.documentList) {
			if (doc instanceof Livre) {
				livresFiltres.add((Livre) doc);
			}
		}


		tableViewLivres.setItems(livresFiltres);

		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colAuteur.setCellValueFactory(donnee -> donnee.getValue().auteurProperty());
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		colEmprunteur.setCellValueFactory(donnee -> donnee.getValue().nomEmprunteurProperty());
	}
	public void ajouterLivre(Livre livre) {
		GestionnaireDonnee.documentList.add(livre); 
		tableViewLivres.getItems().add(livre);  
		tableViewLivres.refresh();
	}
	//public ObservableList<Livre> getObservableList() {
	//	return lstObsLivre;
	//}
	public TableView<Livre> getTableView() {
		return tableViewLivres;
	}

	public void filtrerDocuments(String texte, String filtreActif) {
		ObservableList<Livre> livresFiltres = FXCollections.observableArrayList();

		for (Document doc : GestionnaireDonnee.documentList) {
			if (doc instanceof Livre) {
				Livre livre = (Livre) doc;
				if ("auteur".equals(filtreActif) && livre.getAuteur().toLowerCase().contains(texte.toLowerCase())) {
					livresFiltres.add(livre);
				} else if ("motCle".equals(filtreActif) && livre.getMotsCles().toLowerCase().contains(texte.toLowerCase())) {
					livresFiltres.add(livre);
				}
			}
		}

		tableViewLivres.setItems(livresFiltres);
	}

}
