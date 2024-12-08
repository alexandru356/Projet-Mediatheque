package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.UUID;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prepose implements Serializable {
	
	private static final long serialVersionUID = -2938596194237243687L;

	private transient StringProperty id;
	private transient StringProperty nom;
	private transient StringProperty prenom;
	private transient StringProperty numTelephone;
	private transient StringProperty adresse;
	private transient StringProperty numEmp;
	private transient StringProperty passwd;

	public Prepose(String numEmp,String nom, String prenom, String adresse, String numTelephone, String passwd) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.adresse = new SimpleStringProperty(adresse);
		this.numTelephone = new SimpleStringProperty(numTelephone);
		this.id = new SimpleStringProperty(UUID.randomUUID().toString());
		this.numEmp = new SimpleStringProperty(numEmp);
		this.passwd = new SimpleStringProperty(passwd);
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {

		out.defaultWriteObject();
		System.out.println("Serialisation de: " + getNom());

		out.writeObject(getNom());
		out.writeObject(getPrenom());
		out.writeObject(getAdresse());
		out.writeObject(getNumTelephone());
		out.writeObject(getNumEmp());
		out.writeObject(getPasswd());
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		//System.out.println("Deserialisation de: " + getNom());
		nom = new SimpleStringProperty((String) in.readObject());
		prenom = new SimpleStringProperty((String) in.readObject());
		adresse = new SimpleStringProperty((String) in.readObject());
		numTelephone = new SimpleStringProperty((String) in.readObject());
		numEmp = new SimpleStringProperty((String) in.readObject());
		passwd = new SimpleStringProperty((String) in.readObject());
	}

	public final StringProperty idProperty() {
		return this.id;
	}
	

	public final String getId() {
		return this.idProperty().get();
	}
	

	public final void setId(final String id) {
		this.idProperty().set(id);
	}
	

	public final StringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final StringProperty prenomProperty() {
		return this.prenom;
	}
	

	public final String getPrenom() {
		return this.prenomProperty().get();
	}
	

	public final void setPrenom(final String prenom) {
		this.prenomProperty().set(prenom);
	}
	

	public final StringProperty numTelephoneProperty() {
		return this.numTelephone;
	}
	

	public final String getNumTelephone() {
		return this.numTelephoneProperty().get();
	}
	

	public final void setNumTelephone(final String numTelephone) {
		this.numTelephoneProperty().set(numTelephone);
	}
	

	public final StringProperty adresseProperty() {
		return this.adresse;
	}
	

	public final String getAdresse() {
		return this.adresseProperty().get();
	}
	

	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}
	

	public final StringProperty numEmpProperty() {
		return this.numEmp;
	}
	

	public final String getNumEmp() {
		return this.numEmpProperty().get();
	}
	

	public final void setNumEmp(final String numEmp) {
		this.numEmpProperty().set(numEmp);
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
