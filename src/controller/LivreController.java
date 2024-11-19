package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Livre;

public class LivreController {

	@FXML
	private TableView<Livre> tableView;
	
	@FXML
	private TableColumn<Livre, String> colNumDoc;
	
	@FXML
	private TableColumn<Livre, String> colTitre;
	
	@FXML
	private TableColumn<Livre, String> colAuteur;
	
	@FXML
	private TableColumn<Livre, String> colDate;
	
	@FXML
	private TableColumn<Livre, Boolean> colEtat;
	
	@FXML
	private TableColumn<Livre, Integer> colNbPret;
	
	@FXML
	private TableColumn<Livre, String> colEmprunteur;
	
	private ObservableList<Livre> lstObsLivre = FXCollections.observableArrayList();
	
	public LivreController () {
		
	}
	
	@FXML
	public void initialize () {
		tableView.setItems(lstObsLivre);
	}
}
