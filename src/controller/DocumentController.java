package controller;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Document;

public class DocumentController {

	@FXML
	private TableView<Document> tableView;
	
	@FXML
	private TableColumn<Document, String> colNumDoc;
	
	@FXML
	private TableColumn<Document, String> colTitre;
	
	@FXML
	private TableColumn<Document, String> colAuteur;
	
	@FXML
	private TableColumn<Document, LocalDate> colDate;
	
	@FXML
	private TableColumn<Document, Boolean> colEtat;
	
	@FXML
	private TableColumn<Document, Integer> colNbPret;
	
	@FXML
	private TableColumn<Document, String> colEmprunteur;
	
	private ObservableList<Document> lstObsDoc = FXCollections.observableArrayList();
	
	public DocumentController () {
		
	}
	
	
	@FXML
	public void initialize() {
		
	}
}
