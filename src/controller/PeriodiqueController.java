package controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Document;
import model.Livre;
import model.Periodique;
import utils.GestionnaireDonnee;
import utils.PeriodiqueReader;

public class PeriodiqueController {

	@FXML
	private TableView<Periodique> tableViewPeriodique;

	@FXML
	private TableColumn<Periodique, String> colNumDoc;

	@FXML
	private TableColumn<Periodique, String> colTitre;

	@FXML
	private TableColumn<Periodique, String> colDate;

	@FXML
	private TableColumn<Periodique, String> colVol;

	@FXML
	private TableColumn<Periodique, String> colNumPeriodique;

	@FXML
	private TableColumn<Periodique, String> colEtat;

	@FXML
	private TableColumn<Periodique, Integer> colNbPret;

	@FXML
	private TableColumn<Periodique, String> colEmprunteur;


	public Periodique getSelectedPeriodique() {
		return tableViewPeriodique.getSelectionModel().getSelectedItem();
	}
	@FXML
	public void initialize () {

		ObservableList<Periodique> lstObsPeriodique = FXCollections.observableArrayList();

		for (Document doc : GestionnaireDonnee.documentList) {
			if (doc instanceof Periodique) {
				lstObsPeriodique.add((Periodique) doc);
			}
		}

		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colVol.setCellValueFactory(donnee -> donnee.getValue().numVolumeProperty());
		colNumPeriodique.setCellValueFactory(donnee -> donnee.getValue().numPeriodiqueProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		colEmprunteur.setCellValueFactory(donnee -> donnee.getValue().nomEmprunteurProperty());

		tableViewPeriodique.setItems(lstObsPeriodique);
	}


	public void filtrerDocuments(String texte, String filtreActif) {
		ObservableList<Periodique> periodiquesFiltres = FXCollections.observableArrayList();


		for (Document periodiqueItem : GestionnaireDonnee.documentList) {
			if (periodiqueItem instanceof Periodique) {

				Periodique periodique = (Periodique) periodiqueItem;

				if ("auteur".equals(filtreActif) && periodique.getAuteur().toLowerCase().contains(texte.toLowerCase())) {
					periodiquesFiltres.add(periodique);
				} else if ("motCle".equals(filtreActif) && periodique.getMotsCles().toLowerCase().contains(texte.toLowerCase())) {
					periodiquesFiltres.add(periodique);
				}
			}

		}


		tableViewPeriodique.setItems(periodiquesFiltres);
	}
	public TableView<Periodique> getTableView() {
		return tableViewPeriodique;
	}
	public void supprimerDocument(Document selectedDocument) {
		
		GestionnaireDonnee.documentList.remove(selectedDocument);
		tableViewPeriodique.getItems().remove(selectedDocument);
		tableViewPeriodique.refresh();
	}
}
