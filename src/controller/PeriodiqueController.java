package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Periodique;

public class PeriodiqueController {

	@FXML
	private TableView<Periodique> tableView;
	
	@FXML
	private TableColumn<Periodique, String> colNumDoc;
	
	@FXML
	private TableColumn<Periodique, String> colTitre;
	
	@FXML
	private TableColumn<Periodique, String> colDate;
	
	@FXML
	private TableColumn<Periodique, Integer> colVol;
	
	@FXML
	private TableColumn<Periodique, Integer> colNumPeriodique;
	
	@FXML
	private TableColumn<Periodique, Boolean> colEtat;
	
	@FXML
	private TableColumn<Periodique, Integer> colNbPret;
	
	@FXML
	private TableColumn<Periodique, String> colEmprunteur;
	
	private ObservableList<Periodique> lstObsPeriodique = FXCollections.observableArrayList();
	
	public PeriodiqueController () {
		
	}
	
	@FXML
	public void initialize () {
	}
}
