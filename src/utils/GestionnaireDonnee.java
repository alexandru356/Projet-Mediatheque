package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Adherent;
import model.Prepose;

public class GestionnaireDonnee {

	public static ObservableList<Adherent> adherentList = FXCollections.observableArrayList();
	public static ObservableList<Prepose> preposeList = FXCollections.observableArrayList();

	public static void chargerDonnees() {
		
		
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
	    
	    System.out.println("After deserialization, preposeList reference: " + System.identityHashCode(preposeList));
	    System.out.println("Preposes loaded: " + preposeList);
	}

}
