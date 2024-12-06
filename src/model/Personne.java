package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {

	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty numTelephone;
	private StringProperty adresse;
	private StringProperty passwd;

	public Personne(String nom, String prenom, String numTelephone, String adresse,String passwd) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.numTelephone = new SimpleStringProperty(numTelephone);
		this.adresse = new SimpleStringProperty(adresse);
		this.passwd = new SimpleStringProperty(passwd);
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
	
	
	@Override
	public String toString() {
		return "Nom: " + nom.get() + 
				"\nPrénom: " + prenom.get() + 
				"\nNuméro de téléphone: " + numTelephone.get() + 
				"\nAdresse: " + adresse.get();
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
