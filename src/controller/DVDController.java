package controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DVD;
import utils.DVDReader;

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
	
	private ObservableList<DVD> lstObsDVD = FXCollections.observableArrayList(DVDReader.chargerFichier("DVD.txt"));
	
	public DVDController () {
		
	}
	
	@FXML
	public void initialize () {
		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colRealisateur.setCellValueFactory(donnee -> donnee.getValue().realisateurProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		//colEmprunteur.setCellValueFactory(donnee -> donnee.getValue());
		tableViewDvd.setItems(lstObsDVD);
	}
	
}

