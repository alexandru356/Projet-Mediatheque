package controller;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DVD;

public class DVDController {
	

	@FXML
	private TableView<DVD> tableView;
	
	@FXML
	private TableColumn<DVD, String> colNumDoc;
	
	@FXML
	private TableColumn<DVD, String> colTitre;
	
	@FXML
	private TableColumn<DVD, String> colRealisateur;
	
	@FXML
	private TableColumn<DVD, LocalDate> colDate;
	
	@FXML
	private TableColumn<DVD, Boolean> colEtat;
	
	@FXML
	private TableColumn<DVD, Integer> colNbPret;
	
	@FXML
	private TableColumn<DVD, String> colEmprunteur;
	
	private ObservableList<DVD> lstObsDVD = FXCollections.observableArrayList();
	
	public DVDController () {
		
	}
	
	@FXML
	public void initialize () {
		
	}
	
}

