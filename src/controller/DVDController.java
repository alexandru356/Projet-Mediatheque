package controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Adherent;
import model.DVD;
import model.Document;
import model.Livre;
import utils.DVDReader;
import utils.GestionnaireDonnee;

public class DVDController {


	@FXML
	private TableView<DVD> tableViewDvd;

	@FXML
	private TableColumn<DVD, String> colNumDoc;

	@FXML
	private TableColumn<DVD, String> colTitre;

	@FXML
	private TableColumn<DVD, String> colRealisateur;

	@FXML
	private TableColumn<DVD, String> colDate;

	@FXML
	private TableColumn<DVD, String> colEtat;

	@FXML
	private TableColumn<DVD, Integer> colNbPret;

	@FXML
	private TableColumn<DVD, String> colEmprunteur;

	private ObservableList<DVD> dvdList = FXCollections.observableArrayList();

	public DVD getSelectedDVD() {
		return tableViewDvd.getSelectionModel().getSelectedItem();
	}
	@FXML
	public void initialize () {

		ObservableList<DVD> dvdFiltres = FXCollections.observableArrayList();

		for (Document doc : GestionnaireDonnee.documentList) {
			if (doc instanceof DVD) {
				dvdFiltres.add((DVD) doc);
			}
		}
		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colRealisateur.setCellValueFactory(donnee -> donnee.getValue().realisateurProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		colEmprunteur.setCellValueFactory(donnee -> donnee.getValue().nomEmprunteurProperty());

		tableViewDvd.setItems(dvdFiltres);
	}

	public void filtrerDocuments(String texte, String filtreActif) {
		ObservableList<DVD> dvdFiltres = FXCollections.observableArrayList();


		for (Document dvdItem : GestionnaireDonnee.documentList) {
			if (dvdItem instanceof DVD) {
				DVD dvd = (DVD) dvdItem;
				if ("auteur".equals(filtreActif) && dvd.getRealisateur().toLowerCase().contains(texte.toLowerCase())) {
					dvdFiltres.add(dvd);
				} else if ("motCle".equals(filtreActif) && dvd.getMotsCles().toLowerCase().contains(texte.toLowerCase())) {
					dvdFiltres.add(dvd);
				}
			}
		}


		tableViewDvd.setItems(dvdFiltres);
	}
	public TableView<DVD> getTableView() {
		return tableViewDvd;
	}
}

