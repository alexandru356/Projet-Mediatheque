package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DVD {

	private StringProperty numDoc;
	private StringProperty titre;
	private ObjectProperty<LocalDate> datePublication;
	private StringProperty auteur;


	public DVD(String numDoc, String titre, String datePublication, String auteur) {
		this.numDoc = new SimpleStringProperty(numDoc);
		this.titre = new SimpleStringProperty(titre);
		this.datePublication = new SimpleObjectProperty(datePublication);
		this.auteur = new SimpleStringProperty(auteur);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		return sb.append("Livre: \n")
				.append("ID: " + numDoc + "\n")
				.append("Titre: " + titre + "\n")
				.append("Date de publication: " + datePublication + "\n")
				.append("Auteur: " + auteur).toString();
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
