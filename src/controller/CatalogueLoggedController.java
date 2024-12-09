package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import model.Document;
import utils.GestionSerialisation;
import utils.GestionnaireDonnee;

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
	private Button btnPayer;

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

	@FXML
	private Button btnInscrirePret;

	@FXML
	private Button btnInscrireRetour;
	
	@FXML
	private Button btnSupprimerDoc;

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
	TableColumn<Adherent, Double> tcSoldeDu;



	public void afficherListeAdherents() {
		tvAdherents.setVisible(true);
	}

	public void cacherListeAdherent() {
		tvAdherents.setVisible(false);
	}
	public static boolean connexionAdhNom(String nom, String prenom) {
		for(Adherent a : GestionnaireDonnee.adherentList) {
			if (a.getNom().equals(nom) && a.getPrenom().equals(prenom)) {
				return true;
			}
		}
		return false;
	}

	public static boolean connexionAdhTel (String tel) {
		for(Adherent a : GestionnaireDonnee.adherentList) {
			if (a.getNumTelephone().equals(tel)) {
				return true;
			}
		}	
		return false;
	}

	public void modifierAdherent() {

		Adherent selectedAdherent = tvAdherents.getSelectionModel().getSelectedItem();

		if (selectedAdherent != null) {
			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifierAdherent.fxml"));
				Parent root = loader.load();


				ModifierAdherent controller = loader.getController();
				controller.setAdherent(selectedAdherent);

				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("Modifier Adherent");
				stage.showAndWait();

				mettreAJourAdherent(selectedAdherent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Show a warning if no adherent is selected
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Avertissement");
			alert.setHeaderText("Aucun adhérent sélectionné");
			alert.setContentText("Veuillez sélectionner un adhérent à modifier.");
			alert.showAndWait();
		}
	}

	public void payerSolde() {
		Adherent selectedAdherent = tvAdherents.getSelectionModel().getSelectedItem();

		if(selectedAdherent != null) {

			if(selectedAdherent.getAmende() > 0) {

				selectedAdherent.setAmende(0);
				mettreAJourAdherent(selectedAdherent);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Paiement effectué");
				alert.setHeaderText(null);
				alert.setContentText("Le solde a été réglé. Le solde est maintenant à 0 $.");
				alert.showAndWait();
			}  else {
				// Si aucun solde à payer, affiche un message
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Aucun solde à payer");
				alert.setHeaderText(null);
				alert.setContentText("Il n'y a aucun solde à payer.");
				alert.showAndWait();
			}
		} else {
			// Si aucun adhérent n'est sélectionné, affiche un message d'erreur
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Avertissement");
			alert.setHeaderText("Aucun adhérent sélectionné");
			alert.setContentText("Veuillez sélectionner un adhérent pour procéder au paiement.");
			alert.showAndWait();
		}
	}

	public void supprimerAdherent() {

		Adherent adherent = tvAdherents.getSelectionModel().getSelectedItem();
		if (adherent != null) {
			adherentList.remove(adherent);
			GestionSerialisation.serealiserAdherent(adherentList);
		}
	}
	
	public void supprimerDocument() {
		
		Document selectedDocument = docController.getSelectedDocument();
		if (selectedDocument != null) {
			docController.supprimerDocument(selectedDocument);
			livreController.supprimerDocument(selectedDocument);
			dvdController.supprimerDocument(selectedDocument);
			periodiqueController.supprimerDocument(selectedDocument);
		} else {
			// Message si aucun document n'est sélectionné
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Avertissement");
			alert.setHeaderText("Aucun document sélectionné");
			alert.setContentText("Veuillez sélectionner un document à supprimer.");
			alert.showAndWait();
		}
	}
	
	private void mettreAJourAdherent(Adherent updatedAdherent) {
		for (int i = 0; i < GestionnaireDonnee.adherentList.size(); i++) {
			Adherent adherent = GestionnaireDonnee.adherentList.get(i);
			//fix num inscript null error
			if (adherent.getNumInscription().equals(updatedAdherent.getNumInscription())) {
				GestionnaireDonnee.adherentList.set(i, updatedAdherent);
				break;
			}
		}

		GestionSerialisation.serealiserAdherent(GestionnaireDonnee.adherentList);

		tvAdherents.setItems(FXCollections.observableArrayList(GestionnaireDonnee.adherentList));
		tvAdherents.refresh();
	}
	//----------------------------------------------------------------------------------------	

	private DocumentController docController;
	private LivreController livreController;
	private DVDController dvdController;
	private PeriodiqueController periodiqueController;
	ObservableList<Adherent> adherentList = FXCollections.observableArrayList();

	@FXML
	public void Effacer () {
		tfRecherche.clear();
	}

	@FXML
	public void initialize() throws IOException {


		adherentList = GestionnaireDonnee.adherentList;

		tcNumAdherent.setCellValueFactory(donnee -> donnee.getValue().numInscriptionProperty());
		tcNomAdherent.setCellValueFactory(donnee -> donnee.getValue().nomProperty());
		tcPrenomAdherent.setCellValueFactory(donnee -> donnee.getValue().prenomProperty());
		tcAdresse.setCellValueFactory(donnee -> donnee.getValue().adresseProperty());
		tcTelephoneAdherent.setCellValueFactory(donnee -> donnee.getValue().numTelephoneProperty());
		tcPretActifs.setCellValueFactory(donnee -> donnee.getValue().pretsActifsProperty().asObject());
		tcSoldeDu.setCellValueFactory(donnee -> donnee.getValue().amendeProperty().asObject());
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
		tfRecherche.textProperty().addListener((observable, oldText, newText) -> {
			rechercherDansTousLesTabs(newText);
		});


	}
	public static void addAdherentToTable(Adherent adherent) {
		GestionnaireDonnee.adherentList.add(adherent);
		GestionSerialisation.serealiserAdherent(GestionnaireDonnee.adherentList);
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

	@FXML
	private void inscrirePret() {


		Document selectedDocument = docController.getSelectedDocument();
		if (selectedDocument != null) {
			if (selectedDocument.isEstEmprunte()) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Avertissement");
				alert.setHeaderText("Document déjà emprunté");
				alert.setContentText("Ce document est déjà emprunté. Veuillez en choisir un autre.");
				alert.showAndWait();
			} else {

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Pret.fxml"));
					Parent root = loader.load();
					PretController pretController = loader.getController();

					pretController.setDocumentSelect(selectedDocument);
					selectedDocument.setEstEmprunte(true);  
					selectedDocument.setNomEmprunteur(null); 
					docController.getTableView().refresh();
					livreController.getTableView().refresh();
					dvdController.getTableView().refresh();
					periodiqueController.getTableView().refresh();
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("Inscrire un prêt");
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			// Message si aucun document n'est sélectionné
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Avertissement");
			alert.setHeaderText("Aucun document sélectionné");
			alert.setContentText("Veuillez sélectionner un document à emprunter.");
			alert.showAndWait();
		}
	}

	@FXML
	private void inscrireRetour() {
		Document selectedDocument = docController.getSelectedDocument();

		if (selectedDocument != null) {

			String nomEmprunteur = selectedDocument.getNomEmprunteur();
			if (selectedDocument.getNomEmprunteur() != null) {

				selectedDocument.setNomEmprunteur(null);
				selectedDocument.setEstEmprunte(false);
				
				for (Adherent adherent : GestionnaireDonnee.adherentList) {
					if (nomEmprunteur.contains(adherent.getNom())) {
						adherent.setPretsActifs(adherent.getPretsActifs() - 1);  
						
						break;
					}
				}
				docController.getTableView().refresh();
				livreController.getTableView().refresh();
				dvdController.getTableView().refresh();
				periodiqueController.getTableView().refresh();
			} else {
				// Message si aucun document n'est sélectionné
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Avertissement");
				alert.setHeaderText("Aucun document sélectionné");
				alert.setContentText("Veuillez sélectionner un document à retourner.");
				alert.showAndWait();
			}
		}
	}
}
