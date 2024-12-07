package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prepose extends Personne {
	
	private final StringProperty numEmp;
	private final StringProperty passwd;
	  
	public Prepose(String numEmp,String nom, String prenom, String adresse, String numTelephone, String passwd) {
		super(nom, prenom, adresse, numTelephone);
		this.numEmp = new SimpleStringProperty(numEmp);
		this.passwd = new SimpleStringProperty(passwd);
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



	public final StringProperty passwdProperty() {
		return this.passwd;
	}
	



	public final String getPasswd() {
		return this.passwdProperty().get();
	}
	



	public final void setPasswd(final String passwd) {
		this.passwdProperty().set(passwd);
	}
	
}
