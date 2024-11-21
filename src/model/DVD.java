package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DVD extends Document{

	private StringProperty realisateur;
	private StringProperty  nbDisques;

	// Constructeur
	public DVD(String numDoc, String titre, LocalDate datePublication,String nbDisques ,String realisateur) {
		super(numDoc, titre, 0, datePublication.toString());  
		this.realisateur = new SimpleStringProperty(realisateur);
		this.nbDisques = new SimpleStringProperty(nbDisques);
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

	public final StringProperty nbDisquesProperty() {
		return this.nbDisques;
	}
	

	public final String getNbDisques() {
		return this.nbDisquesProperty().get();
	}
	

	public final void setNbDisques(final String nbDisques) {
		this.nbDisquesProperty().set(nbDisques);
	}
	


	
}
