package controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import model.Document;

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
	private TableView<Document> tableDocuments;

	private DocumentController docController;
	private LivreController livreController;
	private DVDController dvdController;
	private PeriodiqueController periodiqueController;


	public void Quitter () {
		Platform.exit();
	}

	public void Effacer () {
		tfRecherche.clear();
	}

	public void TypeIdentigication () {
		if (rdIdentificationTelephone.isSelected()) {
			tfNom.setVisible(false);
			tfPrenom.setVisible(false);
			tfTelephone.setVisible(true);
			txtTelephone.setVisible(true);
			txtNom.setVisible(false);
			txtPrenom.setVisible(false);
		}else {
			tfNom.setVisible(true);
			tfPrenom.setVisible(true);
			tfTelephone.setVisible(false);
			txtTelephone.setVisible(false);
			txtNom.setVisible(true);
			txtPrenom.setVisible(true);
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
