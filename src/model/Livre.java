package model;


import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Livre extends Document{


	private StringProperty auteur;
	private StringProperty motsCles;
	

	public Livre(String numDoc, String titre, LocalDate datePublication, String auteur,String motsCles) {
		// Appel au constructeur parent de Document
		super(numDoc, titre, 0, datePublication.toString()); 
		this.auteur = new SimpleStringProperty(auteur);
		this.motsCles = new SimpleStringProperty(motsCles);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		return sb.append("Livre: \n")
				.append("Numéro de document: ").append(getNumDoc()).append("\n")
				.append("Titre: ").append(getTitre()).append("\n")
				.append("Date de publication: ").append(getDatePublication()).append("\n")
				.append("Auteur: ").append(getAuteur()).toString();
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
