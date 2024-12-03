package utils;

import javafx.collections.ObservableList;
import model.Periodique;


public class TestPeriodiqueReader {
	public static void main(String[] args) {
		
		ObservableList<Periodique> p = PeriodiqueReader.chargerFichier("Periodiques.txt");
		  for (Periodique pe : p) {
	            System.out.println(pe);  
	        }
	}
}
