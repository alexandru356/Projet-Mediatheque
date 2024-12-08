package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Adherent;
import model.Document;
import model.Prepose;
import model.Pret;
import utils.GestionSerialisation;

public class GestionAdherentController {
	
	
	
	//Mettre tous les nodes du fmxl
	
	
	
	static ObservableList<Adherent> adherentList = FXCollections.observableArrayList();
	
	@FXML
	public void Initialize () {
		adherentList = GestionSerialisation.deserealiserAdherent();
		
		if (adherentList == null) {
			adherentList = FXCollections.observableArrayList(); 
		}
		System.out.println(adherentList);
		
		
		//TODO
		//initialiser les donnees des TableColumns
	}
	
	public static boolean connexionAdhNom(String nom, String prenom) {
		for(Adherent a : adherentList) {
			if (a.getNom().equals(nom) && a.getPrenom().equals(prenom)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean connexionAdhTel (String tel) {
		for(Adherent a : adherentList) {
			if (a.getNumTelephone().equals(tel)) {
				return true;
			}
		}	
		return false;
	}
	
	public static void addAdherentToTable(Adherent adherent) {
		adherentList.add(adherent);
		GestionSerialisation.serealiserAdherent(adherentList);
		System.out.println(adherentList);
	}
	
	public void supprimerAdherent() {
		//TODO
	}
	
	public void ajoutAdherent() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AjoutAdherent.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ajouter  un adherent");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modifierAdherent() {
		//TODO
	}
	
	public void payerSolde() {
		//TODO
	}
}
