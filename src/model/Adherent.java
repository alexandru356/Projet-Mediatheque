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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Adherent implements Serializable {

	private static final long serialVersionUID = -2938596194237212317L;



	//Constantes pour les limites de l'adhérent
	private static final int MAX_LIVRES = 3;
	private static final int MAX_DVD = 2;
	private static final int MAX_PERIODIQUES = 1;
	private static final double AMENDE_PAR_JOUR = 0.50; 

	private transient StringProperty numInscription;
	private transient StringProperty nom;
	private transient StringProperty prenom;
	private transient StringProperty numTelephone;
	private transient StringProperty adresse;
	private transient IntegerProperty pretsActifs;
	private transient DoubleProperty amende;

	private transient ObservableList<Pret> prets;


	public Adherent(String numInscription, String numTelephone, String nom, String prenom, String adresse) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.numTelephone = new SimpleStringProperty(numTelephone);
		this.adresse = new SimpleStringProperty(adresse);
		this.numInscription = new SimpleStringProperty(numInscription);
		this.amende = new SimpleDoubleProperty(0.00);
		this.pretsActifs = new SimpleIntegerProperty(0);
		this.prets = FXCollections.observableArrayList();
	}

	private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
		out.defaultWriteObject();  
		out.writeObject(getNumInscription());  
		out.writeObject(getNom());
		out.writeObject(getPrenom());
		out.writeObject(getNumTelephone());
		out.writeObject(getAdresse());
		out.writeObject(getAmende());
		out.writeObject(getPretsActifs());
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();  
		numInscription = new SimpleStringProperty((String) in.readObject());
		nom = new SimpleStringProperty((String) in.readObject());
		prenom = new SimpleStringProperty((String) in.readObject());
		numTelephone = new SimpleStringProperty((String) in.readObject());
		adresse = new SimpleStringProperty((String) in.readObject());
		amende = new SimpleDoubleProperty((Double) in.readObject());
		pretsActifs = new SimpleIntegerProperty((Integer) in.readObject());
	}



	public void ajouterPret(Pret pret) {
		this.prets.add(pret);
	}

	public ObservableList<Pret> getPrets() {
		return prets;
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

	public final IntegerProperty pretsActifsProperty() {
		return this.pretsActifs;
	}


	public final int getPretsActifs() {
		return this.pretsActifsProperty().get();
	}


	public final void setPretsActifs(final int pretsActifs) {
		this.pretsActifsProperty().set(pretsActifs);
	}




}
