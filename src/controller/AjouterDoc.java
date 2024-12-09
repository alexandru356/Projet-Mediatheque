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
import utils.GestionnaireDonnee;

public class AjouterDoc {
	
	//classe pour la fenetre d'ajout de document

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
	Button btnConfirmer;
	
	private int livreCounter = 10;
	private int dvdCounter = 1;
	private int periodiqueCounter = 1;

	@FXML
	public void initialize() {
		menuBtn.setText("Livre");
	}

	@FXML
	private void annuler() {
		Stage stage = (Stage) btnAnnuler.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void ajouterDocument() {

		String titre = tfTitre.getText();
		String auteur = tfAuteur.getText();
		String dateStr = tfDate.getText();
		String motsCles = tfMotsCles.getText();

		LocalDate date;
		try {
			date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		} catch (DateTimeParseException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("La date doit être sous le format jj-mm-aaaa");
			return;
		}

		String selectedType = menuBtn.getText();

		if("Livre".equals(selectedType)) {
			String numDocLivre = generateNumDoc("Livre");
			Livre livre = new Livre(numDocLivre, titre, date, auteur, motsCles);
			GestionnaireDonnee.documentList.add(livre);
			
			

	        if (livreController != null) {
	            livreController.ajouterLivre(livre);
	            livreController.getTableView().refresh();
	            
	        }
		} else {
	        // Si aucun type n'est sélectionné
	        Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.setTitle("Erreur");
	        alert.setContentText("Veuillez sélectionner un type de document dans le menu.");
	        alert.showAndWait();
	        return;
	    }
		Stage stage = (Stage) btnConfirmer.getScene().getWindow();
        stage.close();
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
	private String generateNumDoc(String type) {
		if ("Livre".equals(type)) {
			return "Livre" + livreCounter++;
		} else if ("DVD".equals(type)) {
			return "DVD" + dvdCounter++;
		} else if ("Periodique".equals(type)) {
			return "Periodique" + periodiqueCounter++;
		}
		return "Unknown" + System.currentTimeMillis();
	}
}

