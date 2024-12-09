package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import utils.GestionSerialisation;

public class CatalogueLoggedController {

	@FXML
	private RadioButton rdAuteur;

	@FXML
	private RadioButton rdMotCle;
	
	@FXML
	private Button btnEffacer;
	
	@FXML
	private Button btnAjouterAdherent;
	
	@FXML
	private Button btnAjouterDoc;
	
	@FXML
	private Button btnDeconnexion;

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
	public static boolean connexionAdhNom(String nom, String prenom) {
		for(Adherent a : adherentList) {
			if (a.getNom().equals(nom) && a.getPrenom().equals(prenom)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean connexionAdhTel (String tel) {
		for(Adherent a : adherentList) {
			if (a.getNumTelephone().equals(tel)) {
				return true;
			}
		}	
		return false;
	}
	
	public void modifierAdherent() {
		//TODO
	}
	
	public void payerSolde() {
		//TODO
	}
	
	public void supprimerAdherent() {
		//TODO
	}
	//----------------------------------------------------------------------------------------	
	
	private DocumentController docController;
	private LivreController livreController;
	private DVDController dvdController;
	private PeriodiqueController periodiqueController;
	static ObservableList<Adherent> adherentList = FXCollections.observableArrayList();
	
	@FXML
	public void Effacer () {
		tfRecherche.clear();
	}
	
	public static void addAdherentToTable(Adherent adherent) {
		adherentList.add(adherent);
		GestionSerialisation.serealiserAdherent(adherentList);
		System.out.println(adherentList);
	}
	
	@FXML
	public void initialize() throws IOException {
		
		
		adherentList = GestionSerialisation.deserealiserAdherent();
		
		if (adherentList == null) {
			adherentList = FXCollections.observableArrayList();
		}
		
		tcNumAdherent.setCellValueFactory(cellData -> cellData.getValue().numInscriptionProperty());
		tcNomAdherent.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		tcPrenomAdherent.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		tcAdresse.setCellValueFactory(cellData -> cellData.getValue().adresseProperty());
		tcTelephoneAdherent.setCellValueFactory(cellData -> cellData.getValue().numTelephoneProperty());
		tvAdherents.setItems(adherentList);
		
		
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
	
	
	public void deconnexion() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vueIdentification.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage) btnDeconnexion.getScene().getWindow();
			stage.close();
			stage.setScene(scene);
			stage.setTitle("Identification");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void AjoutAdherent() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AjoutAdherent.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ajouter un adhérent");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
