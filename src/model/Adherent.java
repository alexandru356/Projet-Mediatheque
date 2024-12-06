package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adherent extends Personne{


	private IntegerProperty numInscription;
	private DoubleProperty amende;

	//Constantes pour les limites de l'adhérent
	private static final int MAX_LIVRES = 3;
	private static final int MAX_DVD = 2;
	private static final int MAX_PERIODIQUES = 1;
	private static final double AMENDE_PAR_JOUR = 0.50; 

	public Adherent(int numInscription, String numTelephone, String nom, String prenom, String adresse, String passwd) {
		super(nom,prenom,numTelephone,adresse,passwd);
		this.numInscription = new SimpleIntegerProperty(numInscription);
		this.amende = new SimpleDoubleProperty(0.0);
	}

	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()).append("\n");
	    sb.append("Numéro d'inscription : ").append(getNumInscription()).append("\n");
	    sb.append("Amende : $").append(String.format("%.2f", getAmende())).append("\n");

	    return sb.toString();
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

}
