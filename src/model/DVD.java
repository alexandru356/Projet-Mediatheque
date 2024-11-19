package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DVD {

	private StringProperty identifiant;
	private StringProperty titre;
	private StringProperty datePublication;
	private StringProperty auteur;


	public DVD(String identifiant, String titre, String datePublication, String auteur) {
		this.identifiant = new SimpleStringProperty(identifiant);
		this.titre = new SimpleStringProperty(titre);
		this.datePublication = new SimpleStringProperty(datePublication);
		this.auteur = new SimpleStringProperty(auteur);
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		return sb.append("Livre: \n")
				.append("ID: " + identifiant + "\n")
				.append("Titre: " + titre + "\n")
				.append("Date de publication: " + datePublication + "\n")
				.append("Auteur: " + auteur).toString();
	}



	public final StringProperty identifiantProperty() {
		return this.identifiant;
	}




	public final String getIdentifiant() {
		return this.identifiantProperty().get();
	}




	public final void setIdentifiant(final String identifiant) {
		this.identifiantProperty().set(identifiant);
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




	public final StringProperty datePublicationProperty() {
		return this.datePublication;
	}




	public final String getDatePublication() {
		return this.datePublicationProperty().get();
	}




	public final void setDatePublication(final String datePublication) {
		this.datePublicationProperty().set(datePublication);
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
