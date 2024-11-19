package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pret {


	private Adherent adherent;
	private Document document;
	private StringProperty datePret;
	private StringProperty dateRetour;


	public Pret(Adherent adherent, Document document, String datePret, String dateRetour) {
		this.adherent = adherent;
		this.document = document;
		this.datePret = new SimpleStringProperty(datePret);
		this.dateRetour = new SimpleStringProperty(dateRetour);
	}


	public final StringProperty datePretProperty() {
		return this.datePret;
	}



	public final String getDatePret() {
		return this.datePretProperty().get();
	}



	public final void setDatePret(final String datePret) {
		this.datePretProperty().set(datePret);
	}



	public final StringProperty dateRetourProperty() {
		return this.dateRetour;
	}



	public final String getDateRetour() {
		return this.dateRetourProperty().get();
	}



	public final void setDateRetour(final String dateRetour) {
		this.dateRetourProperty().set(dateRetour);
	}

	@Override
	public String toString() {
		return "Adhérent: " + adherent.getNom() + " " + adherent.getPrenom() + 
				"\nDocument: " + document.getTitre() +
				"\nDate de prêt: " + datePret.get() + 
				"\nDate de retour: " + dateRetour.get();
	}
}
