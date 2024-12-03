package model;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Periodique extends Document{



	private StringProperty numVolume;
	private StringProperty numPeriodique;
	private StringProperty auteur;
	private StringProperty motsCles;


	public Periodique(String numDoc, String titre, LocalDate datePublication, String numVolume, String numPeriodique, String auteur, String motsCles) {
		super(numDoc,titre,0,datePublication.toString());
		this.numVolume = new SimpleStringProperty(numVolume);
		this.numPeriodique = new SimpleStringProperty(numPeriodique);
		this.auteur = new SimpleStringProperty(auteur);
		this.motsCles = new SimpleStringProperty(motsCles);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		return sb.append("Periodique: \n")
                .append("Numéro de document: ").append(getNumDoc()).append("\n")
                .append("Titre: ").append(getTitre()).append("\n")
                .append("Date de publication: ").append(getDatePublication()).append("\n")
                .append("Auteur: ").append(getAuteur()).append("\n")
				.append("Numéro du Volume: ").append(getNumVolume()).append("\n")
				.append("Numéro Périodique: ").append(getNumPeriodique()).toString();
	}


	public final StringProperty numVolumeProperty() {
		return this.numVolume;
	}
	


	public final String getNumVolume() {
		return this.numVolumeProperty().get();
	}
	


	public final void setNumVolume(final String numVolume) {
		this.numVolumeProperty().set(numVolume);
	}
	


	public final StringProperty numPeriodiqueProperty() {
		return this.numPeriodique;
	}
	


	public final String getNumPeriodique() {
		return this.numPeriodiqueProperty().get();
	}
	


	public final void setNumPeriodique(final String numPeriodique) {
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


	public final StringProperty motsClesProperty() {
		return this.motsCles;
	}
	


	public final String getMotsCles() {
		return this.motsClesProperty().get();
	}
	


	public final void setMotsCles(final String motsCles) {
		this.motsClesProperty().set(motsCles);
	}
	
	
	
}
