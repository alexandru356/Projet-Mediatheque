package model;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Amende {


	private Adherent adherent;
	private DoubleProperty montant;
	private ObjectProperty<LocalDate> dateLimite;

	public Amende(Adherent adherent, double montant, LocalDate dateLimite) {
		this.adherent = adherent;
		this.montant = new SimpleDoubleProperty(montant);
		this.dateLimite = new SimpleObjectProperty<>(dateLimite);
	}

	@Override
	public String toString() {
		return "Adhérent: " + adherent.getNom() + " " + adherent.getPrenom() + 
				"\nMontant de l'amende: " + montant.get() + 
				"\nDate limite de paiement: " + dateLimite.get();
	}

	public final DoubleProperty montantProperty() {
		return this.montant;
	}


	public final double getMontant() {
		return this.montantProperty().get();
	}


	public final void setMontant(final double montant) {
		this.montantProperty().set(montant);
	}


	public final ObjectProperty<LocalDate> dateLimiteProperty() {
		return this.dateLimite;
	}


	public final LocalDate getDateLimite() {
		return this.dateLimiteProperty().get();
	}


	public final void setDateLimite(final LocalDate dateLimite) {
		this.dateLimiteProperty().set(dateLimite);
	}

}
