package utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Livre;

//Lire le fichier avec les livres

public class LivreReader {
	
	private LivreReader() {
		throw new UnsupportedOperationException("classe utilitaire, ne peut etre instancier");
	}
	
	public static ObservableList<Livre> chargerFichier(String nomFichier){
		
		String pathFichierTexte = "/donnees/" + nomFichier;
		
		ObservableList<Livre> listeLivre = FXCollections.observableArrayList();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		try(InputStream inStream = Livre.class.getResourceAsStream(pathFichierTexte);
					Scanner lecteur = new Scanner(inStream)) {
			lecteur.useDelimiter(",|\\n");
			
			while(lecteur.hasNextLine()) {
				String numDoc = lecteur.next().trim();
				String titre = lecteur.next().trim();
				String datePublicationStr = lecteur.next().trim();
				String auteur = lecteur.next().trim();
				String motsCles = lecteur.next().trim();
				
				LocalDate datePublication = LocalDate.parse(datePublicationStr, formatter);
				
				Livre livre = new Livre(numDoc,titre,datePublication,auteur,motsCles);
				
				listeLivre.add(livre);
				} 
			}catch (IOException e) {

				e.printStackTrace();
			}
		
		return listeLivre;
	}
}
