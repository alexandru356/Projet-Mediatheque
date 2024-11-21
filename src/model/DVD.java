package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DVD extends Document{

	private StringProperty realisateur;
	private IntegerProperty  nbDisques;

	// Constructeur
	public DVD(String numDoc, String titre, int nbPrets, LocalDate datePublication, String realisateur, int nbDisques) {
		super(numDoc, titre, nbPrets, datePublication.toString());  
		this.realisateur = new SimpleStringProperty(realisateur);
		this.nbDisques = new SimpleIntegerProperty(nbDisques);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("DVD: \n")
	      .append("Numéro de document: ").append(getNumDoc()).append("\n")
	      .append("Titre: ").append(getTitre()).append("\n")
	      .append("Date de publication: ").append(getDatePublication()).append("\n")
	      .append("Réalisateur: ").append(getRealisateur()).append("\n")
	      .append("Nombre de disques: ").append(getNbDisques());
	    return sb.toString();
	}
		
	public final StringProperty realisateurProperty() {
		return this.realisateur;
	}


	public final String getRealisateur() {
		return this.realisateurProperty().get();
	}


	public final void setRealisateur(final String realisateur) {
		this.realisateurProperty().set(realisateur);
	}


	public final IntegerProperty nbDisquesProperty() {
		return this.nbDisques;
	}


	public final int getNbDisques() {
		return this.nbDisquesProperty().get();
	}


	public final void setNbDisques(final int nbDisques) {
		this.nbDisquesProperty().set(nbDisques);
	}

}
