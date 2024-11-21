package utils;

import javafx.collections.ObservableList;
import model.Livre;

public class TestLivreReader {
	public static void main(String[] args) {
		
		ObservableList<Livre> livres = LivreReader.chargerFichier("Livres.txt");
		  for (Livre livre : livres) {
	            System.out.println(livre);  
	        }
	}
}
