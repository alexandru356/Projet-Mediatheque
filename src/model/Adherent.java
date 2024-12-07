package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adherent {


	private IntegerProperty numInscription;
	private DoubleProperty amende;

	//Constantes pour les limites de l'adhérent
	private static final int MAX_LIVRES = 3;
	private static final int MAX_DVD = 2;
	private static final int MAX_PERIODIQUES = 1;
	private static final double AMENDE_PAR_JOUR = 0.50; 
	
	private transient StringProperty nom;
	private transient StringProperty prenom;
	private transient StringProperty numTelephone;
	private transient StringProperty adresse;
	private transient StringProperty passwd;
	

	public Adherent(int numInscription, String numTelephone, String nom, String prenom, String adresse, String passwd) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.numTelephone = new SimpleStringProperty(numTelephone);
		this.adresse = new SimpleStringProperty(adresse);
		this.passwd = new SimpleStringProperty(passwd);
		this.numInscription = new SimpleIntegerProperty(numInscription);
		this.amende = new SimpleDoubleProperty(0.0);
	}

	
	
	
	public final IntegerProperty numInscriptionProperty() {
		return this.numInscription;
	}


	public final int getNumInscription() {
		return this.numInscriptionProperty().get();
	}


	public final void setNumInscription(final int numInscription) {
		this.numInscriptionProperty().set(numInscription);
	}

	public final DoubleProperty amendeProperty() {
		return this.amende;
	}


	public final double getAmende() {
		return this.amendeProperty().get();
	}


	public final void setAmende(final double amende) {
		this.amendeProperty().set(amende);
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
