package controller;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Document;
import model.Pret;

public class vueDossierController {

	@FXML
	private TableView<Document> tvDocInfo;
	
	@FXML
	private TableColumn<Document, String> tcNumDoc;
	
	@FXML
	private TableColumn<Document, String> tcTitre;
	
	@FXML
	private TableColumn<Document, String> tcAuteur;
	
	@FXML
	private TableColumn<Document, LocalDate> tcDate;
	
	@FXML
	private TableView<Pret> tvPrets;
	
	@FXML
	private TableColumn<Pret, String> tcNumPret;
	
	@FXML
	private TableColumn<Pret, LocalDate> tcDatePret;
	
	@FXML
	private TableColumn<Pret, LocalDate> tcDateRetourPrevu;
	
	@FXML
	private TableColumn<Pret, Double> tcAmande;
	
	@FXML
	private Button btnQuitter;
	
	@FXML
	public void Initialize () {
		
	}
	
	public void quitter () {
		try {
			Stage currentStage = (Stage) btnQuitter.getScene().getWindow();
			currentStage.close();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vueIdentification.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Identification");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
