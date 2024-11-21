package utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Periodique;

public class PeriodiqueReader {

	private PeriodiqueReader() {
		throw new UnsupportedOperationException("classe utilitaire, ne peut etre instancier");
	}

	public static ObservableList<Periodique> chargerFichier(String nomFichier){

		String pathFichierTexte = "/donnees/" + nomFichier;

		ObservableList<Periodique> listePeriodique = FXCollections.observableArrayList();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		try(InputStream inStream = Periodique.class.getResourceAsStream(pathFichierTexte);
				Scanner lecteur = new Scanner(inStream)){
			lecteur.useDelimiter(",|\\n");

			while(lecteur.hasNextLine()) {
				String numDoc = lecteur.next().trim();
				String titre = lecteur.next().trim();
				String datePublicationStr = lecteur.next().trim();
				String numVolume = lecteur.next().trim();
				String numPeriodique = lecteur.next().trim();
				String auteur = "";

				LocalDate datePublication = LocalDate.parse(datePublicationStr, formatter);

				Periodique periodique = new Periodique(numDoc,titre,datePublication,numVolume,numPeriodique,auteur);

				listePeriodique.add(periodique);
			} 
		}catch (IOException e) {
			e.printStackTrace();
		}



		return listePeriodique;
	}
}
