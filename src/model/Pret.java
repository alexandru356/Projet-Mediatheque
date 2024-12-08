package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pret {
	
	private Adherent adherent;
	private Document document;
	private ObjectProperty<LocalDate> datePret;
	private ObjectProperty<LocalDate>  dateRetour;


	public Pret(Adherent adherent, Document document, String datePret, String dateRetour) {
		this.adherent = adherent;
		this.document = document;
		this.datePret = new SimpleObjectProperty(datePret);
		this.dateRetour = new SimpleObjectProperty(dateRetour);
	}


	/*@Override
	public String toString() {
		return "Adhérent: " + adherent.getNom() + " " + adherent.getPrenom() + 
				"\nDocument: " + document.getTitre() +
				"\nDate de prêt: " + datePret.get() + 
				"\nDate de retour: " + dateRetour.get();
	}*/


	public final ObjectProperty<LocalDate> datePretProperty() {
		return this.datePret;
	}
	

	public final LocalDate getDatePret() {
		return this.datePretProperty().get();
	}
	

	public final void setDatePret(final LocalDate datePret) {
		this.datePretProperty().set(datePret);
	}


	public final ObjectProperty<LocalDate> dateRetourProperty() {
		return this.dateRetour;
	}
	

	public final LocalDate getDateRetour() {
		return this.dateRetourProperty().get();
	}
	


	public final void setDateRetour(final LocalDate dateRetour) {
		this.dateRetourProperty().set(dateRetour);
	}
	
}
