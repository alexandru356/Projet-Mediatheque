package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DVD;
import model.Document;
import model.Livre;
import model.Periodique;

public class AjouterDoc {

	private LivreController livreController;

	public void setLivreController(LivreController livreController) {
		this.livreController = livreController;
	}
	
	private DocumentController documentController;

	public void setDocumentController(DocumentController documentController) {
	    this.documentController = documentController;
	}
	@FXML
	MenuButton menuBtn;

	@FXML
	MenuItem menuItemDVD;

	@FXML
	MenuItem menuItemPerio;

	@FXML
	TextField tfTitre;

	@FXML
	TextField tfAuteur;

	@FXML
	TextField tfDate;

	@FXML
	TextField tfMotsCles;

	@FXML
	Button btnAnnuler;



	@FXML
	private TableView<Livre> livreTableView;
	//@FXML
	//private TableView<DVD> dvdTableView;
	//@FXML
	//private TableView<Periodique> periodiqueTableView;
	@FXML
	private TableView<Document> tousLesDocsTableView;

	//private ObservableList<Periodique> periodiqueList = FXCollections.observableArrayList();
	//private ObservableList<DVD> dvdList = FXCollections.observableArrayList();
	private ObservableList<Livre> livreList = FXCollections.observableArrayList();
	private ObservableList<Document> documentList = FXCollections.observableArrayList();


	private int livreCounter = 10;
	//private int dvdCounter = 1;
	//private int periodiqueCounter = 1;

	@FXML
	public void initialize() {
		//livreTableView.setItems(livreList);
		//dvdTableView.setItems(dvdList);
		//periodiqueTableView.setItems(periodiqueList);
		//tousLesDocsTableView.setItems(documentList);
		menuBtn.setText("Livre");
	}

	@FXML
	private void annuler() {
		Stage stage = (Stage) btnAnnuler.getScene().getWindow();
		stage.close();
	}
	@FXML
	private void addDocument() {
		//String numDoc = 
		String titre = tfTitre.getText();
		String auteur = tfAuteur.getText();
		String dateStr = tfDate.getText();
		String motsCles = tfMotsCles.getText();


		String selectedType = menuBtn.getText();
		Document document = null;

		LocalDate date;
		try {
			date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		} catch (DateTimeParseException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("La date doit être sous le format jj-mm-aaaa");
			return;
		}

		String numDocLivre = generateNumDoc();
		Livre livre = new Livre(numDocLivre, titre, date, auteur, motsCles);
		if (livreController != null && documentController != null) {
			livreController.ajouterLivre(livre);
			documentController.ajouterDocument(livre);
			livreController.getTableView().refresh();
			documentController.getTableView().refresh();
		}
		clearFields();
	}

	private String generateNumDoc() {
		return "Livre" + livreCounter++;
	}


	private boolean isValidDate(String date) {
		String datePattern = "\\d{2}-\\d{2}-\\d{4}";
		return Pattern.matches(datePattern, date);
	}

	private void clearFields() {
		tfTitre.clear();
		tfAuteur.clear();
		tfDate.clear();
		tfMotsCles.clear();
	}

}

