package utils;

import javafx.collections.ObservableList;

//classe de tests pas importante a la correction
import model.Livre;

public class TestLivreReader {
	public static void main(String[] args) {
		
		ObservableList<Livre> livres = LivreReader.chargerFichier("Livres.txt");
		  for (Livre livre : livres) {
	            System.out.println(livre);  //ou call the get method pour montrer les mots cles ajouter
	        }
	}
}
