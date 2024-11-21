package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DVD;
import model.Livre;

public class DVDReader {

	private DVDReader () {
		throw new UnsupportedOperationException("Classe Utilitaire ne peut pas etre instancier");
	}
	
	public static ObservableList<DVD> chargerFichier(String nomFichier){
		
		String pathFichierTexte = "/donnees/" + nomFichier;
		
		ObservableList<DVD> listeDVD = FXCollections.observableArrayList();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
		
		try(InputStream inStream = DVD.class.getResourceAsStream(pathFichierTexte);
				Scanner lecteur = new Scanner(inStream)) {
			lecteur.useDelimiter(",|\\n");
			
			while(lecteur.hasNextLine()) {
				String numDoc = lecteur.next().trim();
				String titre = lecteur.next().trim();
				String datePublicationStr = lecteur.next().trim();
				String realisateur = lecteur.next().trim();
				
				LocalDate datePublication = LocalDate.parse(datePublicationStr, formatter);
				
				//DVD dvd = new DVD(numDoc,titre,datePublication,realisateur);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeDVD;
		
	}
}
