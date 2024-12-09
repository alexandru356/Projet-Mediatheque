package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Adherent;

public class CatalogueLoggedController {

	@FXML
	private RadioButton rdAuteur;

	@FXML
	private RadioButton rdMotCle;
	
	@FXML
	private Button btnEffacer;
	
	@FXML
	private Button btnAjouterDoc;

	@FXML
	private TextField tfRecherche;
	
	@FXML
	private TabPane tabPane;
	
	@FXML
	private Tab tabTousLesDocuments;

	@FXML
	private Tab tabLivres;

	@FXML
	private Tab tabDVD;

	@FXML
	private Tab tabPeriodiques;
	
	//Pour la liste des adherents
	//----------------------------------------------------------------------------------------
	
	@FXML
	TableView<Adherent> tvAdherents;
	
	@FXML
	TableColumn<Adherent, String> tcNumAdherent;
	
	@FXML
	TableColumn<Adherent, String> tcNomAdherent;
	
	@FXML
	TableColumn<Adherent, String> tcPrenomAdherent;
	
	@FXML
	TableColumn<Adherent, String> tcAdresse;
	
	@FXML
	TableColumn<Adherent, String> tcTelephoneAdherent;
	
	@FXML
	TableColumn<Adherent, Integer> tcPretActifs;
	
	@FXML
	TableColumn<Adherent, String> tcSoldeDu;
	
	public void afficherListeAdherents() {
		tvAdherents.setVisible(true);
	}
	
	public void cacherListeAdherent() {
		tvAdherents.setVisible(false);
	}
	
	//----------------------------------------------------------------------------------------	
	
	private DocumentController docController;
	private LivreController livreController;
	private DVDController dvdController;
	private PeriodiqueController periodiqueController;

	
	@FXML
	public void Effacer () {
		tfRecherche.clear();
	}
	
	@FXML
	public void initialize() throws IOException {
		ToggleGroup group1 = new ToggleGroup();
		rdAuteur.setToggleGroup(group1);
		rdMotCle.setToggleGroup(group1);

		rdAuteur.setSelected(true);
		
		
		group1.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
			rechercherDansTousLesTabs(tfRecherche.getText());
		});
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VueDoc.fxml"));
		Parent root = loader.load();
		docController = loader.getController();
		tabTousLesDocuments.setContent(root);  

		loader = new FXMLLoader(getClass().getResource("/fxml/VueLivres.fxml"));
		root = loader.load();
		livreController = loader.getController();
		tabLivres.setContent(root);

		loader = new FXMLLoader(getClass().getResource("/fxml/VueDVD.fxml"));
		root = loader.load();
		dvdController = loader.getController();
		tabDVD.setContent(root);

		loader = new FXMLLoader(getClass().getResource("/fxml/VuePeriodiques.fxml"));
		root = loader.load();
		periodiqueController = loader.getController();
		tabPeriodiques.setContent(root);

		//si user selectionne le tab periodique, on desactive le bouton radio auteur 
		//car periodique n'a pas d'auteur
		tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
			if (newTab == tabPeriodiques) {

				rdAuteur.setDisable(true);
			} else {

				rdAuteur.setDisable(false);
			}
		});
	}
	
	
	public void rechercherDansTousLesTabs(String texte) {

		String filtreActif = getFiltreActif();

		docController.filtrerDocuments(texte,filtreActif);
		livreController.filtrerDocuments(texte,filtreActif);
		dvdController.filtrerDocuments(texte,filtreActif);
		periodiqueController.filtrerDocuments(texte,filtreActif);
	}
	
	
	private String getFiltreActif() {
		if (rdAuteur.isSelected()) {
			return "auteur";
		} else if (rdMotCle.isSelected()) {
			return "motCle";
		}
		return "";
	}
	
	@FXML
	private void ajouterDoc() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AjoutDoc.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ajouter un document");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
