package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adherent implements Serializable {

	private static final long serialVersionUID = -2938596194237212317L;
	private transient StringProperty numInscription;
	private transient DoubleProperty amende;

	//Constantes pour les limites de l'adhérent
	private static final int MAX_LIVRES = 3;
	private static final int MAX_DVD = 2;
	private static final int MAX_PERIODIQUES = 1;
	private static final double AMENDE_PAR_JOUR = 0.50; 

	private transient StringProperty nom;
	private transient StringProperty prenom;
	private transient StringProperty numTelephone;
	private transient StringProperty adresse;


	//numInscription 
	public Adherent(String numInscription, String numTelephone, String nom, String prenom, String adresse) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.numTelephone = new SimpleStringProperty(numTelephone);
		this.adresse = new SimpleStringProperty(adresse);
		this.numInscription = new SimpleStringProperty(numInscription);
		this.amende = new SimpleDoubleProperty(0.0);
	}

	private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        out.defaultWriteObject();
        System.out.println("Serialisation de: " + getNom());
        out.writeObject(getNom());
        out.writeObject(getPrenom());
        out.writeObject(getNumTelephone());
        out.writeObject(getAdresse());
    }
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		nom = new SimpleStringProperty((String) in.readObject());
		prenom = new SimpleStringProperty((String) in.readObject());
		adresse = new SimpleStringProperty((String) in.readObject());
		numTelephone = new SimpleStringProperty((String) in.readObject());
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




	public final StringProperty numInscriptionProperty() {
		return this.numInscription;
	}







	public final String getNumInscription() {
		return this.numInscriptionProperty().get();
	}







	public final void setNumInscription(final String numInscription) {
		this.numInscriptionProperty().set(numInscription);
	}



}
