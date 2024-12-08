package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Document;
import utils.ValidationIdentification;

public class CatalogueController {

	@FXML
	private RadioButton rdAuteur;

	@FXML
	private RadioButton rdMotCle;

	@FXML
	private Button btnQuitter;

	@FXML
	private Button btnEffacer;

	@FXML
	private TextField tfRecherche;

	//Nodes pour l'identification :

	@FXML
	private RadioButton rdIdentificationNom;

	@FXML
	private RadioButton rdIdentificationTelephone;

	@FXML
	private Button btnConsulter;

	@FXML
	private TextField tfNom;

	@FXML
	private TextField tfPrenom;

	@FXML
	private TextField tfTelephone;

	@FXML
	private Text txtNom;

	@FXML
	private Text txtPrenom;

	@FXML
	private Text txtTelephone;

	@FXML
	private Tab tabTousLesDocuments;

	@FXML
	private Tab tabLivres;

	@FXML
	private Tab tabDVD;

	@FXML
	private Tab tabPeriodiques;

	@FXML
	private TabPane tabPane;

	@FXML
	private TableView<Document> tableDocuments;

	private DocumentController docController;
	private LivreController livreController;
	private DVDController dvdController;
	private PeriodiqueController periodiqueController;


	public void Quitter () {
		try {
			Stage currentStage = (Stage) btnQuitter.getScene().getWindow();
			currentStage.close();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vueIdentification.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Médiathèque Employe");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void Effacer () {
		tfRecherche.clear();
	}

	public void TypeIdentification () {
		if (rdIdentificationNom.isSelected()) {
			tfNom.setVisible(true);
			tfPrenom.setVisible(true);
			txtNom.setVisible(true);
			txtPrenom.setVisible(true);
			tfTelephone.setVisible(false);
			txtTelephone.setVisible(false);
			tfTelephone.clear();
		} else {
			tfNom.setVisible(false);
			tfPrenom.setVisible(false);
			txtNom.setVisible(false);
			txtPrenom.setVisible(false);
			txtTelephone.setVisible(true);
			tfTelephone.setVisible(true);
			tfNom.clear();
			tfPrenom.clear();
		}
	}
	
	public void ouvrirDossier() {
		try {
			Stage currentStage = (Stage) btnQuitter.getScene().getWindow();
			currentStage.close();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vueDossier.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Votre dossier");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Login() throws FileNotFoundException, IOException {
		
Alert errorAlert = new Alert(Alert.AlertType.ERROR);
		
		if(rdIdentificationNom.isSelected()) {
			
			String nom = tfNom.getText();
			String prenom = tfPrenom.getText();
			
			Boolean adherentValid = GestionAdherentController.connexionAdhNom(nom, prenom);
			
			//Pour faire des tests
			//System.out.print("nom : ." + nom + ".");
			
			
			//Gerer les messages d'erreurs different et si le login est bon
			if(nom == "") {
				
				errorAlert.setTitle("Erreur");
				errorAlert.setHeaderText("Nom invalide !");
				errorAlert.setContentText("Vous n'avez pas tape votre nom.");
				errorAlert.show();
				
			}else if(prenom == "") {
				
				errorAlert.setTitle("Erreur");
				errorAlert.setHeaderText("Prenom invalide !");
				errorAlert.setContentText("Vous n'avez pas tape votre prenom.");
				errorAlert.show();
				
			}else if(adherentValid){
				
				ouvrirDossier();
				
			}else {
				errorAlert.setTitle("Erreur");
				errorAlert.setHeaderText("Compte invalide !");
				errorAlert.setContentText("Les donnees que vous avez entre ne correspondent pas a un adherent valide.");
				errorAlert.show();
			}
			
		}else{
			
			String telephone = tfTelephone.getText();
			
			Boolean adherentValid = GestionAdherentController.connexionAdhTel(telephone);
			
			if (!ValidationIdentification.verifierFomartTelephone(telephone)) {
				errorAlert.setTitle("Erreur");
				errorAlert.setHeaderText("Numero de telephone invalide !");
				errorAlert.setContentText("Le format du numero de telephone n'est pas valide.\n"
						+ "(***) ***-****");
				errorAlert.show();
			}else if (adherentValid){
				ouvrirDossier();
			} else {
				errorAlert.setTitle("Erreur");
				errorAlert.setHeaderText("Compte invalide !");
				errorAlert.setContentText("Les donnees que vous avez entre ne correspondent pas a un adherent valide.");
				errorAlert.show();
			}
		}
		
	}

	public CatalogueController () {

	}


	@FXML
	public void initialize () throws IOException {

		ToggleGroup group1 = new ToggleGroup();
		rdAuteur.setToggleGroup(group1);
		rdMotCle.setToggleGroup(group1);

		rdAuteur.setSelected(true);

		//Pour choisir la methode d'identification

		ToggleGroup groupIdentification = new ToggleGroup();
		rdIdentificationNom.setToggleGroup(groupIdentification);
		rdIdentificationTelephone.setToggleGroup(groupIdentification);

		rdIdentificationNom.setSelected(true);


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

		tfRecherche.textProperty().addListener((observable, oldText, newText) -> {
			rechercherDansTousLesTabs(newText);
		});

		group1.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
			rechercherDansTousLesTabs(tfRecherche.getText());
		});
		
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

	private String getFiltreActif() {
		if (rdAuteur.isSelected()) {
			return "auteur";
		} else if (rdMotCle.isSelected()) {
			return "motCle";
		}
		return "";
	}

	public void rechercherDansTousLesTabs(String texte) {

		String filtreActif = getFiltreActif();

		docController.filtrerDocuments(texte,filtreActif);
		livreController.filtrerDocuments(texte,filtreActif);
		dvdController.filtrerDocuments(texte,filtreActif);
		periodiqueController.filtrerDocuments(texte,filtreActif);
	}

}
