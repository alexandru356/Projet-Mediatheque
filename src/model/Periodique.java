package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Periodique extends Document{



	private IntegerProperty numVolume;
	private IntegerProperty numPeriodique;
	private StringProperty auteur;


	public Periodique(String numDoc, String titre, String datePublication, int numVolume, int numPeriodique, String auteur) {
		super(numDoc,titre,0,datePublication);
		this.numVolume = new SimpleIntegerProperty(numVolume);
		this.numPeriodique = new SimpleIntegerProperty(numPeriodique);
		this.auteur = new SimpleStringProperty(auteur);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		return sb.append("Livre: \n")
                .append("Numéro de document: ").append(getNumDoc()).append("\n")
                .append("Titre: ").append(getTitre()).append("\n")
                .append("Date de publication: ").append(getDatePublication()).append("\n")
                .append("Auteur: ").append(getAuteur())
				.append("Numéro du Volume: ").append(getNumVolume())
				.append("Numéro Périodique: ").append(getNumPeriodique()).toString();
	}


	public final IntegerProperty numVolumeProperty() {
		return this.numVolume;
	}
	


	public final int getNumVolume() {
		return this.numVolumeProperty().get();
	}
	


	public final void setNumVolume(final int numVolume) {
		this.numVolumeProperty().set(numVolume);
	}
	


	public final IntegerProperty numPeriodiqueProperty() {
		return this.numPeriodique;
	}
	


	public final int getNumPeriodique() {
		return this.numPeriodiqueProperty().get();
	}
	


	public final void setNumPeriodique(final int numPeriodique) {
		this.numPeriodiqueProperty().set(numPeriodique);
	}
	


	public final StringProperty auteurProperty() {
		return this.auteur;
	}
	


	public final String getAuteur() {
		return this.auteurProperty().get();
	}
	


	public final void setAuteur(final String auteur) {
		this.auteurProperty().set(auteur);
	}
	



}
