package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Document {
	
	
	private StringProperty identifiant;
	private StringProperty titre;
	private IntegerProperty nbPrets;
	private StringProperty datePublication;

	public Document(String identifiant, String titre, int nbPrets, String datePublication) {
		this.identifiant = new SimpleStringProperty(identifiant);
		this.titre = new SimpleStringProperty(titre);
		this.nbPrets = new SimpleIntegerProperty(nbPrets);
		this.datePublication = new SimpleStringProperty(datePublication);
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


	public final IntegerProperty nbPretsProperty() {
		return this.nbPrets;
	}


	public final int getNbPrets() {
		return this.nbPretsProperty().get();
	}


	public final void setNbPrets(final int nbPrets) {
		this.nbPretsProperty().set(nbPrets);
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

}
