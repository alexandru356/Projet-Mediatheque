package utils;

import javafx.collections.ObservableList;
import model.Periodique;

//classe de tests pas importante a la correction

public class TestPeriodiqueReader {
	public static void main(String[] args) {
		
		ObservableList<Periodique> p = PeriodiqueReader.chargerFichier("Periodiques.txt");
		  for (Periodique pe : p) {
	            System.out.println(pe);  //ou call the get method pour montrer les mots cles ajouter
	        }
	}
}
