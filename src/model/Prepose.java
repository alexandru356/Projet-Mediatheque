package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prepose extends Personne {
	
	private final StringProperty numEmp;
	  
	public Prepose(String numEmp,String nom, String prenom, String numTelephone, String adresse,String passwd) {
		super(nom, prenom, numTelephone, adresse, passwd);
		this.numEmp = new SimpleStringProperty(numEmp);
	}
	
	public String getNumEmp() {
        return numEmp.get();
    }


    public void setNumEmp(String numEmp) {
        this.numEmp.set(numEmp);
    }

    public StringProperty numEmpProperty() {
        return numEmp;
    }
}
