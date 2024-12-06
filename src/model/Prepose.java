package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prepose extends Personne {
	
	private final StringProperty numEmp;
	  
	public Prepose(String numEmp,String nom, String prenom, String adresse, String numTelephone,String passwd) {
		super(nom, prenom, adresse, numTelephone, passwd);
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
