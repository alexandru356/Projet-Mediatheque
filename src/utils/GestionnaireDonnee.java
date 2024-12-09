package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Adherent;
import model.Document;
import model.Prepose;

public class GestionnaireDonnee {

	public static ObservableList<Adherent> adherentList = FXCollections.observableArrayList();
	public static ObservableList<Prepose> preposeList = FXCollections.observableArrayList();
	public static ObservableList<Document> documentList = FXCollections.observableArrayList();

	public static void chargerDonnees() {
		
		
		documentList.addAll(LivreReader.chargerFichier("Livres.txt"));
		documentList.addAll(DVDReader.chargerFichier("DVD.txt"));
		documentList.addAll(PeriodiqueReader.chargerFichier("Periodiques.txt"));
		
		ObservableList<Document> livres = GestionSerialisation.deserialiserLivres();
		ObservableList<Document> dvds = GestionSerialisation.deserialiserDVDs();
		ObservableList<Document> periodiques = GestionSerialisation.deserialiserPeriodiques();

		if (livres != null) documentList.addAll(livres);
		if (dvds != null) documentList.addAll(dvds);
		if (periodiques != null) documentList.addAll(periodiques);


		ObservableList<Prepose> deserializedPreposes = GestionSerialisation.deserialiserPrepose();
		if (deserializedPreposes != null) {
			preposeList = deserializedPreposes;
		} else {
			preposeList = FXCollections.observableArrayList();
		}

		ObservableList<Adherent> deserializedAdherents = GestionSerialisation.deserealiserAdherent();
		if (deserializedAdherents != null) {
			adherentList = deserializedAdherents;
		} else {
			adherentList = FXCollections.observableArrayList();
		}


	}

}
