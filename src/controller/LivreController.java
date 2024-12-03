package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Livre;
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
	
	private ObservableList<Livre> lstObsLivre = FXCollections.observableArrayList(LivreReader.chargerFichier("Livres.txt"));
	
	public LivreController () {
		
	}
	
	@FXML
	public void initialize () {
		
		colNumDoc.setCellValueFactory(donnee -> donnee.getValue().numDocProperty());
		colTitre.setCellValueFactory(donnee -> donnee.getValue().titreProperty());
		colAuteur.setCellValueFactory(donnee -> donnee.getValue().auteurProperty());
		colDate.setCellValueFactory(donnee -> donnee.getValue().datePublicationFormattedProperty());
		colEtat.setCellValueFactory(donnee -> donnee.getValue().etatProperty());
		colNbPret.setCellValueFactory(donnee -> donnee.getValue().nbPretsProperty().asObject());
		colEmprunteur.setCellValueFactory(donnee -> donnee.getValue().nomEmprunteurProperty());
		
		tableViewLivres.setItems(lstObsLivre);
	}
	

    public void filtrerDocuments(String texte) {
        ObservableList<Livre> livresFiltres = FXCollections.observableArrayList();

        for (Livre livre : lstObsLivre) {
            if (livre.getTitre().toLowerCase().contains(texte.toLowerCase()) || livre.getAuteur().toLowerCase().contains(texte.toLowerCase())) {
                livresFiltres.add(livre);
            }
        }

        tableViewLivres.setItems(livresFiltres);
    }

}
