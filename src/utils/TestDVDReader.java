package utils;

import javafx.collections.ObservableList;
import model.DVD;

public class TestDVDReader {
	public static void main(String[] args) {

		ObservableList<DVD> d = DVDReader.chargerFichier("DVD.txt");
		  for (DVD dvd : d) {
	            System.out.println(dvd);  
	        }
	}
}
