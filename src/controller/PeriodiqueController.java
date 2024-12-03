package controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Periodique;
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
	
	private ObservableList<Periodique> lstObsPeriodique = FXCollections.observableArrayList(PeriodiqueReader.chargerFichier("Periodiques.txt"));
	
	public PeriodiqueController () {
		
	}
	
	@FXML
	public void initialize () {
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
	

    public void filtrerDocuments(String texte) {
        ObservableList<Periodique> periodiquesFiltres = FXCollections.observableArrayList();

        for (Periodique periodiqueItem : lstObsPeriodique) {
            if (periodiqueItem.getTitre().toLowerCase().contains(texte.toLowerCase()) || 
                periodiqueItem.getNumPeriodique().toLowerCase().contains(texte.toLowerCase())) {
                periodiquesFiltres.add(periodiqueItem);
            }
        }


        tableViewPeriodique.setItems(periodiquesFiltres);
    }

}
