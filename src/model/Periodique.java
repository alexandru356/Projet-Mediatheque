package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Periodique {

	private StringProperty numDoc;
	private StringProperty titre;
	private ObjectProperty<LocalDate> datePublication;
	private IntegerProperty numVolume;
	private IntegerProperty numPeriodique;
	private StringProperty auteur;


	public Periodique(String numDoc, String titre, String datePublication, int numVolume, int numPeriodique, String auteur) {
		this.numDoc = new SimpleStringProperty(numDoc);
		this.titre = new SimpleStringProperty(titre);
		this.datePublication = new SimpleObjectProperty(datePublication);
		this.numVolume = new SimpleIntegerProperty(numVolume);
		this.numPeriodique = new SimpleIntegerProperty(numPeriodique);
		this.auteur = new SimpleStringProperty(auteur);
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		return sb.append("Livre: \n")
				.append("ID: " + numDoc + "\n")
				.append("Titre: " + titre + "\n")
				.append("Date de publication: " + datePublication + "\n")
				.append("Numéro du Volume: " + numVolume + "\n")
				.append("Numéro du périodique: " + numPeriodique).toString();
	}




	public final StringProperty titreProperty() {
		return this.titre;
	}




	public final String getTitre() {
		return this.titreProperty().get();
	}




	public final void setTitre(final String titre) {
		this.titreProperty().set(titre);
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



	public final ObjectProperty<LocalDate> datePublicationProperty() {
		return this.datePublication;
	}
	



	public final LocalDate getDatePublication() {
		return this.datePublicationProperty().get();
	}
	



	public final void setDatePublication(final LocalDate datePublication) {
		this.datePublicationProperty().set(datePublication);
	}



	public final StringProperty numDocProperty() {
		return this.numDoc;
	}
	



	public final String getNumDoc() {
		return this.numDocProperty().get();
	}
	



	public final void setNumDoc(final String numDoc) {
		this.numDocProperty().set(numDoc);
	}
	
	


}
