package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Adherent;
import model.Prepose;

public class GestionSerialisation {
	
	private GestionSerialisation() {
		throw new UnsupportedOperationException("Classe utilitaire qui ne doit pas etre instanciee");
	}
	
	public static void serialiserPrepose(ObservableList<Prepose> preposeList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/preposes.ser"))) {
            oos.writeObject(new ArrayList<Prepose>(preposeList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Prepose> deserialiserPrepose() {
        List<Prepose> preposeList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/preposes.ser"))) {
            preposeList = (List<Prepose>) ois.readObject();
            
            return FXCollections.observableArrayList(preposeList);
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void serealiserAdherent(ObservableList<Adherent> adherentList) {
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/adherent.ser"))){
    		oos.writeObject(new ArrayList<Adherent>(adherentList));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public static ObservableList<Adherent> deserealiserAdherent() {
    	List<Adherent> adherentList = null;
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/adherent.ser"))){
    		adherentList = (List<Adherent>) ois.readObject();
    		
    		return FXCollections.observableArrayList(adherentList);
    		
    	} catch (IOException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
}
